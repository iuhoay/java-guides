package dev.iuhoay.java.crud.service;

import dev.iuhoay.java.crud.dto.AuthorDTO;
import dev.iuhoay.java.crud.entity.Author;
import dev.iuhoay.java.crud.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class AuthorServiceTest {
    @Autowired
    AuthorService authorService;
    @MockBean
    AuthorRepository authorRepository;

    @Test
    void getAuthors() {
        // Given
        List<Author> authorList = List.of(
                Author.builder().name("Author 1").build(),
                Author.builder().name("Author 2").build()
        );
        // When
        when(authorRepository.findAll()).thenReturn(authorList);
        // Then
        List<AuthorDTO> authorDTOList = authorService.getAuthors();
        assertEquals(2, authorDTOList.size());
    }
}
