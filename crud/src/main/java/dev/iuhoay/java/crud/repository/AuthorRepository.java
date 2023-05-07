package dev.iuhoay.java.crud.repository;

import dev.iuhoay.java.crud.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
