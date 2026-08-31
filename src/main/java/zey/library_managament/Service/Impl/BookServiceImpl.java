package zey.library_managament.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zey.library_managament.DTO.BookDTO;
import zey.library_managament.Entity.Book;
import zey.library_managament.Exception.ResourceNotFoundException;
import zey.library_managament.Mapper.LibraryMapper;
import zey.library_managament.Repository.IBookRepository;
import zey.library_managament.Service.IBookService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {

    private final IBookRepository bookRepository;
    private final LibraryMapper mapper;

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setPublicationYear(bookDTO.getPublicationYear());

        Book savedBook = bookRepository.save(book);
        return mapper.toBookDTO(savedBook);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(mapper::toBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kitap bulunamadı: " + id));
        bookRepository.delete(book);
    }
}