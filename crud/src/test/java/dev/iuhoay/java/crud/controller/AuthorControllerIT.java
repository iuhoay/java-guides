package dev.iuhoay.java.crud.controller;

import dev.iuhoay.java.crud.entity.Author;
import dev.iuhoay.java.crud.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration test for {@link AuthorController}
 */
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class AuthorControllerIT {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    AuthorRepository authorRepository;

    @Test
    void index() throws Exception {
        // Given
        authorRepository.save(Author.builder().name("Author 1").build());
        // Then
        mockMvc.perform(get("/api/authors").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value("Author 1"))
                .andExpect(jsonPath("$[0].id").isNotEmpty())
        ;
    }

    @Test
    void show() throws Exception {
        // Given
        Author author = authorRepository.save(Author.builder().name("Author 2").build());
        // Then
        mockMvc.perform(get("/api/authors/" + author.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Author 2"))
                .andExpect(jsonPath("$.id").isNotEmpty())
        ;
    }

    @Test
    void create() throws Exception {
        // Given
        String requestBody = "{\"name\": \"Author 3\"}";
        // Then
        mockMvc.perform(post("/api/authors").contentType(MediaType.APPLICATION_JSON).content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Author 3"))
                .andExpect(jsonPath("$.id").isNotEmpty())
        ;
    }

    @Test
    void update() throws Exception {
        // Given
        Author author = authorRepository.save(Author.builder().name("Author 4").build());
        String requestBody = "{\"name\": \"Author 5\"}";
        // Then
        mockMvc.perform(put("/api/authors/" + author.getId()).contentType(MediaType.APPLICATION_JSON).content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Author 5"))
                .andExpect(jsonPath("$.id").isNotEmpty())
        ;
    }

    @Test
    void destroy() throws Exception {
        // Given
        Author author = authorRepository.save(Author.builder().name("Author 6").build());
        // Then
        mockMvc.perform(delete("/api/authors/" + author.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
        ;
    }

}
