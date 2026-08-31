package zey.library_managament.Service;

import zey.library_managament.DTO.BookDTO;
import java.util.List;

public interface IBookService {
    BookDTO createBook(BookDTO bookDTO);
    List<BookDTO> getAllBooks();
    void deleteBook(Long id);
}