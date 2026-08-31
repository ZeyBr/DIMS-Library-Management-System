package zey.library_managament.Mapper;

import org.springframework.stereotype.Component;
import zey.library_managament.DTO.AuthorDTO;
import zey.library_managament.DTO.BookDTO;
import zey.library_managament.DTO.BorrowDTO;
import zey.library_managament.Entity.Author;
import zey.library_managament.Entity.Book;
import zey.library_managament.Entity.Borrow;

@Component
public class LibraryMapper {

    public AuthorDTO toAuthorDTO(Author author) {
        if (author == null) return null;
        AuthorDTO dto = new AuthorDTO();
        dto.setId(author.getId());
        dto.setName(author.getName());
        return dto;
    }

    public BookDTO toBookDTO(Book book) {
        if (book == null) return null;
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setPublicationYear(book.getPublicationYear());
        return dto;
    }

    public BorrowDTO toBorrowDTO(Borrow borrow) {
        if (borrow == null) return null;
        BorrowDTO dto = new BorrowDTO();
        dto.setId(borrow.getId());

        if (borrow.getAuthor() != null) {
            dto.setAuthorId(borrow.getAuthor().getId());
            dto.setAuthorName(borrow.getAuthor().getName());
        }

        if (borrow.getBook() != null) {
            dto.setBookId(borrow.getBook().getId());
            dto.setBookTitle(borrow.getBook().getTitle());
        }

        dto.setBorrowDate(borrow.getBorrowDate());
        dto.setReturnDate(borrow.getReturnDate());
        return dto;
    }
}