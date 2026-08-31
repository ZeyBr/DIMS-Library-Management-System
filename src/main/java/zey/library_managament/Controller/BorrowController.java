package zey.library_managament.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zey.library_managament.DTO.BorrowDTO;
import zey.library_managament.Service.IBorrowService; // Servis arayüzünün import edildiğinden emin olun

import java.util.List;

@RestController
@RequestMapping("/api/borrows")
@RequiredArgsConstructor
public class BorrowController {

    // Hatanın çözümü için bu satırın ekli ve isminin tam olarak 'borrowService' olması gerekir:
    private final IBorrowService borrowService;

    @PostMapping
    public ResponseEntity<BorrowDTO> createBorrow(@RequestBody BorrowDTO borrowDTO) {
        return ResponseEntity.ok(borrowService.createBorrow(borrowDTO));
    }

    @GetMapping
    public ResponseEntity<List<BorrowDTO>> getAllBorrows() {
        return ResponseEntity.ok(borrowService.getAllBorrows());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrow(@PathVariable Long id) {
        borrowService.deleteBorrow(id);
        return ResponseEntity.noContent().build();
    }
}