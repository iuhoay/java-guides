package dev.iuhoay.java.crud.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthorRequest(
        @NotBlank(message = "Name is required")
        String name
) {
}
