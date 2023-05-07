package dev.iuhoay.java.crud.controller;

import dev.iuhoay.java.crud.dto.AuthorDTO;
import dev.iuhoay.java.crud.dto.AuthorRequest;
import dev.iuhoay.java.crud.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    /**
     * Get all authors
     * <p>
     * GET /api/authors
     * <p>
     * HTTP Status: 200 OK
     *
     * @return List<AuthorDTO>
     */
    @GetMapping
    public List<AuthorDTO> index() {
        return authorService.getAuthors();
    }

    /**
     * Get an author
     * <p>
     * GET /api/authors/{id}
     * <p>
     * HTTP Status: 200 OK
     *
     * @param id Author id
     * @return AuthorDTO
     */
    @GetMapping("/{id}")
    public AuthorDTO show(@PathVariable Long id) {
        return authorService.getAuthor(id);
    }

    /**
     * Create an author
     * <p>
     * POST /api/authors
     * <p>
     * HTTP Status: 201 Created
     *
     * @param authorRequest AuthorRequest
     * @return AuthorDTO
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDTO create(@RequestBody @Valid AuthorRequest authorRequest) {
        return authorService.createAuthor(authorRequest);
    }

    /**
     * Update an author
     * <p>
     * PUT /api/authors/{id}
     * <p>
     * HTTP Status: 200 OK
     *
     * @param id            Author id
     * @param authorRequest AuthorRequest
     * @return AuthorDTO
     */
    @PutMapping("/{id}")
    public AuthorDTO update(@PathVariable Long id, @RequestBody @Valid AuthorRequest authorRequest) {
        return authorService.updateAuthor(id, authorRequest);
    }

    /**
     * Delete an author
     * <p>
     * DELETE /api/authors/{id}
     * <p>
     * HTTP Status: 204 No Content
     *
     * @param id Author id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        authorService.destroyAuthor(id);
    }
}
