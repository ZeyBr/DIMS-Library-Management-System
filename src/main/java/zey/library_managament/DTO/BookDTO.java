package zey.library_managament.DTO;

import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private int publicationYear;
}