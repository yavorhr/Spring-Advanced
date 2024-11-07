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

        // Initial load of books
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
        loadBooks();
});