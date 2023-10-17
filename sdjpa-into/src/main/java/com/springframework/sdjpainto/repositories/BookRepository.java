package com.springframework.sdjpainto.repositories;

import com.springframework.sdjpainto.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
