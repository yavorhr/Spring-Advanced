document.addEventListener('DOMContentLoaded', function () {
    const booksTableBody = document.querySelector('#booksTable tbody');
    const form = document.querySelector('form');
    const searchInput = document.querySelector('#searchInput');

    // 1. Load all books from the endpoint and display them in the table
    function loadBooks() {
        fetch('http://localhost:8080/books')
            .then(response => response.json())
            .then(books => {
                booksTableBody.innerHTML = ''; // Clear current rows
                books.forEach(book => {
                    appendBookToTable(book);
                });
            })
            .catch(error => console.error('Error loading books:', error));
    }

    // Helper function to create and append a book row to the table
    function appendBookToTable(book) {
        const row = document.createElement('tr');

        row.innerHTML = `
            <td>${book.title}</td>
            <td>${book.author.fullName}</td>
            <td>${book.releaseDate}</td>
            <td>${book.copies}</td>
            <td>${book.publisher}</td>
            <td>
            <button class="delete-btn" data-id="${book.id}">Delete</button>
            </td>
        `;
        // Add event listener for delete button
        row.querySelector('.delete-btn').addEventListener('click', function () {
            deleteBook(book.id, row);
        });

        booksTableBody.appendChild(row);
    }

    // 2. Delete a book using AJAX and remove the element from the table
    function deleteBook(bookId, rowElement) {
        fetch(`http://localhost:8080/books/${bookId}`, {
            method: 'DELETE'
        })
            .then(response => {
                if (response.ok) {
                    rowElement.remove(); // Remove the row from the table
                    loadBooks();
                    console.log(`Book with ID ${bookId} deleted`);
                } else {
                    console.error(`Failed to delete book with ID ${bookId}`);
                }
            })
            .catch(error => console.error('Error deleting book:', error));
    }
    
    // 3. Handle form submission to create a new book and render it
    form.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent form from submitting normally

        const formData = new FormData(form);

        const newBook = {
            title: formData.get('title'),
            author: formData.get('author'),
            releaseDate: formData.get('releaseDate'),
            copies: parseInt(formData.get('copies'), 10),
            publisher: formData.get('publisher')
        };

        fetch('http://localhost:8080/books', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newBook)
        })
            .then(response => response.json())
            .then(createdBook => {
                appendBookToTable(createdBook);
                form.reset(); // Clear form inputs
            })
            .catch(error => console.error('Error creating book:', error));
    });

    // 4. Search functionality to filter books by title
    searchInput.addEventListener('input', function () {
        const query = searchInput.value.toLowerCase();
        const rows = booksTableBody.querySelectorAll('tr');

        rows.forEach(row => {
            const title = row.querySelector('td').textContent.toLowerCase();
            if (title.includes(query)) {
                row.style.display = '';
            } else {
                row.style.display = 'none';
            }
        });
    });

    //Init load of books
        loadBooks();
});