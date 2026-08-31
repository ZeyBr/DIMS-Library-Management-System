package zey.library_managament.Service;

import zey.library_managament.DTO.AuthorDTO;
import java.util.List;

public interface IAuthorService {
    AuthorDTO createAuthor(AuthorDTO authorDTO);
    List<AuthorDTO> getAllAuthors();
    void deleteAuthor(Long id);
}