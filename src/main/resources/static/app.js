document.addEventListener("DOMContentLoaded", () => {
    loadAuthors();
    loadBooks();
    loadBorrows();
});

// Yazar işlemleri
document.getElementById("authorForm").addEventListener("submit", function(e) {
    e.preventDefault();
    const name = document.getElementById("authorName").value;

    fetch('/api/authors', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name })
    })
        .then(res => res.json())
        .then(() => {
            document.getElementById("authorForm").reset();
            loadAuthors();
        });
});

function loadAuthors() {
    fetch('/api/authors')
        .then(res => res.json())
        .then(data => {
            const tbody = document.querySelector("#authorTable tbody");
            const select = document.getElementById("borrowAuthor");
            if (!tbody || !select) return;

            tbody.innerHTML = "";
            select.innerHTML = '<option value="">Yazar Seçin...</option>';

            data.forEach(author => {
                tbody.innerHTML += `<tr><td>${author.id}</td><td>${author.name}</td>
                <td><button class="delete-btn" onclick="deleteAuthor(${author.id})">Sil</button></td></tr>`;
                select.innerHTML += `<option value="${author.id}">${author.name}</option>`;
            });
        });
}

function deleteAuthor(id) {
    fetch(`/api/authors/${id}`, { method: 'DELETE' }).then(() => loadAuthors());
}

// Kitap işlemleri
document.getElementById("bookForm").addEventListener("submit", function(e) {
    e.preventDefault();
    const title = document.getElementById("title").value;
    const year = document.getElementById("year").value;

    fetch('/api/books', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title, publicationYear: parseInt(year) })
    })
        .then(res => res.json())
        .then(() => {
            document.getElementById("bookForm").reset();
            loadBooks();
        });
});

function loadBooks() {
    fetch('/api/books')
        .then(res => res.json())
        .then(data => {
            const tbody = document.querySelector("#bookTable tbody");
            const select = document.getElementById("borrowBook");
            if (!tbody || !select) return;

            tbody.innerHTML = "";
            select.innerHTML = '<option value="">Kitap Seçin...</option>';

            data.forEach(book => {
                const coverUrl = `https://covers.openlibrary.org/b/title/${encodeURIComponent(book.title.trim())}-M.jpg`;

                tbody.innerHTML += `<tr>
                <td><img src="${coverUrl}" alt="Kapak" style="width: 40px; height: 60px; border-radius: 6px; object-fit: cover; border: 2px solid #1E1E1E;" onerror="this.src='https://via.placeholder.com/40x60?text=Kapak'"></td>
                <td>${book.id}</td>
                <td><strong>${book.title}</strong></td>
                <td>${book.publicationYear}</td>
                <td><button class="delete-btn" onclick="deleteBook(${book.id})">Sil</button></td>
            </tr>`;

                select.innerHTML += `<option value="${book.id}">${book.title}</option>`;
            });
        });
}

function deleteBook(id) {
    fetch(`/api/books/${id}`, { method: 'DELETE' }).then(() => loadBooks());
}

// Ödünç verme işlemleri
document.getElementById("borrowForm").addEventListener("submit", function(e) {
    e.preventDefault();
    const payload = {
        authorId: parseInt(document.getElementById("borrowAuthor").value),
        bookId: parseInt(document.getElementById("borrowBook").value),
        borrowDate: document.getElementById("borrowDate").value,
        returnDate: document.getElementById("returnDate").value
    };

    fetch('/api/borrows', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payload)
    })
        .then(res => res.json())
        .then(() => {
            document.getElementById("borrowForm").reset();
            loadBorrows();
        });
});

function loadBorrows() {
    fetch('/api/borrows')
        .then(res => res.json())
        .then(data => {
            const tbody = document.querySelector("#borrowTable tbody");
            if (!tbody) return;

            tbody.innerHTML = "";
            data.forEach(borrow => {
                const coverUrl = `https://covers.openlibrary.org/b/title/${encodeURIComponent((borrow.bookTitle || "").trim())}-M.jpg`;

                tbody.innerHTML += `<tr>
                <td><img src="${coverUrl}" alt="Kapak" style="width: 40px; height: 60px; border-radius: 6px; object-fit: cover; border: 2px solid #1E1E1E;" onerror="this.src='https://via.placeholder.com/40x60?text=Kapak'"></td>
                <td><strong>${borrow.bookTitle || 'Bilinmiyor'}</strong></td>
                <td>${borrow.authorName || 'Bilinmiyor'}</td>
                <td>${borrow.borrowDate}</td>
                <td><span style="background: #F5D6D6; padding: 4px 8px; border-radius: 6px; font-weight: 700; font-size: 0.85rem;">${borrow.returnDate}</span></td>
                <td><button class="delete-btn" onclick="deleteBorrow(${borrow.id})">İptal Et</button></td>
            </tr>`;
            });
        });
}

function deleteBorrow(id) {
    fetch(`/api/borrows/${id}`, { method: 'DELETE' }).then(() => loadBorrows());
}