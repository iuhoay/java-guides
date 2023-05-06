package dev.iuhoay.java.dto;

import com.fasterxml.jackson.annotation.JsonGetter;

public record UserDTO(
        @JsonGetter("first_name")
        String firstName,
        @JsonGetter("last_name")
        String lastName,
        Integer age,
        @JsonGetter("created_at")
        String createdAt
) {
    @JsonGetter("full_name")
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
