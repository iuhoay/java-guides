package dev.iuhoay.java.crud.service;

import dev.iuhoay.java.crud.dto.AuthorDTO;
import dev.iuhoay.java.crud.dto.AuthorRequest;
import dev.iuhoay.java.crud.dto.mapper.AuthorDTOMapper;
import dev.iuhoay.java.crud.entity.Author;
import dev.iuhoay.java.crud.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<AuthorDTO> getAuthors() {
        List<Author> authorList = authorRepository.findAll();
        return authorList.stream().map(AuthorDTOMapper.INSTANCE).toList();
    }

    public AuthorDTO getAuthor(Long id) {
        return authorRepository.findById(id).map(AuthorDTOMapper.INSTANCE).orElse(null);
    }

    public AuthorDTO createAuthor(AuthorRequest authorRequest) {
        Author author = authorRepository.save(Author.builder().name(authorRequest.name()).build());
        return AuthorDTOMapper.INSTANCE.apply(author);
    }

    public AuthorDTO updateAuthor(Long id, AuthorRequest authorRequest) {
        Author author = authorRepository.findById(id).orElse(null);
        assert author != null;
        author.setName(authorRequest.name());
        return AuthorDTOMapper.INSTANCE.apply(authorRepository.save(author));
    }

    public void destroyAuthor(Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        assert author != null;
        authorRepository.delete(author);
    }
}
