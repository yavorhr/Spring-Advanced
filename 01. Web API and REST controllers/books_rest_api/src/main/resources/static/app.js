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
        booksTableBody.appendChild(row);

        // Initial load of books
    }
        loadBooks();
});