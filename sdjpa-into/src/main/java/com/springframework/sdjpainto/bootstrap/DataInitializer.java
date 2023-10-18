package com.springframework.sdjpainto.bootstrap;

import com.springframework.sdjpainto.domain.Book;
import com.springframework.sdjpainto.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BookRepository bookRepository;

    @Autowired
    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse");
        Book saveDDD = this.bookRepository.save(bookDDD);

        Book bookSIA = new Book("Spring in Action", "123234", "Driely");
        Book saveSIA = this.bookRepository.save(bookSIA);

        List<Book> books = this.bookRepository.findAll();
        books.forEach(book -> {
            System.out.println("Book id" + book.getId());
            System.out.println("Book title: " + book.getTitle());
        });
    }
}
