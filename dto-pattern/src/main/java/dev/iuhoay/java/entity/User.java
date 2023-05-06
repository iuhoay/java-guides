package dev.iuhoay.java.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class User {
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDateTime createdAt;
}
