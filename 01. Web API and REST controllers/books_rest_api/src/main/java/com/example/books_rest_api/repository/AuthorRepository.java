package com.example.books_rest_api.repository;

import com.example.books_rest_api.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository  extends JpaRepository<Author,Long> {

  Optional<Author> findByFirstNameAndLastName(String firstName, String lastName);
}
