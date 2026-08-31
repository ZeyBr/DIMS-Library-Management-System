package zey.library_managament.Service;

import zey.library_managament.DTO.BorrowDTO;
import java.util.List;

public interface IBorrowService {
    BorrowDTO createBorrow(BorrowDTO borrowDTO);
    List<BorrowDTO> getAllBorrows();
    void deleteBorrow(Long id); // Eklendi
}