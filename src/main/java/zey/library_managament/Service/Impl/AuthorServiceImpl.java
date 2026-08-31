package zey.library_managament.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zey.library_managament.DTO.AuthorDTO;
import zey.library_managament.Entity.Author;
import zey.library_managament.Exception.ResourceNotFoundException;
import zey.library_managament.Mapper.LibraryMapper;
import zey.library_managament.Repository.IAuthorRepository;
import zey.library_managament.Service.IAuthorService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements IAuthorService {

    private final IAuthorRepository authorRepository;
    private final LibraryMapper mapper;

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        Author savedAuthor = authorRepository.save(author);
        return mapper.toAuthorDTO(savedAuthor);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(mapper::toAuthorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Silinecek yazar bulunamadı. ID: " + id));
        authorRepository.delete(author);
    }
}