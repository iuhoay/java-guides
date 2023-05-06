package dev.iuhoay.java.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDateTime createdAt;
}
