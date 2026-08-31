package zey.library_managament.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zey.library_managament.DTO.BorrowDTO;
import zey.library_managament.Entity.Author;
import zey.library_managament.Entity.Book;
import zey.library_managament.Entity.Borrow;
import zey.library_managament.Exception.ResourceNotFoundException;
import zey.library_managament.Mapper.LibraryMapper;
import zey.library_managament.Repository.IAuthorRepository;
import zey.library_managament.Repository.IBookRepository;
import zey.library_managament.Repository.IBorrowRepository;
import zey.library_managament.Service.IBorrowService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements IBorrowService {

    private final IBorrowRepository borrowRepository;
    private final IAuthorRepository authorRepository;
    private final IBookRepository bookRepository;
    private final LibraryMapper mapper;

    @Override
    public BorrowDTO createBorrow(BorrowDTO borrowDTO) {
        // İlişkili yazar ve kitabı kontrol et
        Author author = authorRepository.findById(borrowDTO.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException("Yazar bulunamadı: " + borrowDTO.getAuthorId()));

        Book book = bookRepository.findById(borrowDTO.getBookId())
                .orElseThrow(() -> new ResourceNotFoundException("Kitap bulunamadı: " + borrowDTO.getBookId()));

        Borrow borrow = new Borrow();
        borrow.setAuthor(author);
        borrow.setBook(book);
        borrow.setBorrowDate(borrowDTO.getBorrowDate());
        borrow.setReturnDate(borrowDTO.getReturnDate());

        Borrow savedBorrow = borrowRepository.save(borrow);
        return mapper.toBorrowDTO(savedBorrow);
    }

    @Override
    public List<BorrowDTO> getAllBorrows() {
        return borrowRepository.findAll().stream()
                .map(mapper::toBorrowDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBorrow(Long id) {
        Borrow borrow = borrowRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ödünç kaydı bulunamadı: " + id));
        borrowRepository.delete(borrow);
    }
}