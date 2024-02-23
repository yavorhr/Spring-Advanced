$('#loadBooks').click(() => {
  reloadBooks()
});

function reloadBooks() {
  $("#authors-container").empty();

  fetch("http://localhost:8080/books").
    then(response => response.json()).
    then(json => json.forEach(book => {
      let tableRow = '<tr>' +
            '<td>' + book.title + '</td>' +
            '<td>' + book.author.name + '</td>' +
            '<td>' + book.isbn+ '</td>' +
            '<td>' +
              '<button class="edit-btn" data-book-id="' + book.id +'">Edit</button>' +
              '<button class="delete-btn" data-book-id="' + book.id +'">Delete</button>' +
            '</td>' +
          '</tr>'
    $("#authors-container").append(tableRow)
  }))
}

$('body').on('click', 'button.delete-btn', function () {
  let bookId = $(this).data('book-id');
  console.log("Book id to delete is " + bookId);

  fetch('http://localhost:8080/books/' + bookId, {
    method: 'DELETE'
  }).then(_ => reloadBooks())
});
