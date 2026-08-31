package zey.library_managament.DTO;

import lombok.Data;

@Data
public class BorrowDTO {
    private Long id;
    private Long authorId;
    private Long bookId;

    // Görüntüleme için eklenen alanlar
    private String authorName;
    private String bookTitle;
    private String bookCoverUrl;

    private String borrowDate;
    private String returnDate;
}