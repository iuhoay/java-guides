package dev.iuhoay.java.crud.dto.mapper;

import dev.iuhoay.java.crud.dto.AuthorDTO;
import dev.iuhoay.java.crud.entity.Author;

import java.util.function.Function;

public interface AuthorDTOMapper extends Function<Author, AuthorDTO> {
    static AuthorDTOMapper INSTANCE = new AuthorDTOMapper() {};
    @Override
    default AuthorDTO apply(Author author) {
        return new AuthorDTO(author.getId(), author.getName());
    }
}
