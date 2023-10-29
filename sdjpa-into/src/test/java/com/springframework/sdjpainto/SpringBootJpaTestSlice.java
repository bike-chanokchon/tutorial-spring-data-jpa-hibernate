package com.springframework.sdjpainto;

import com.springframework.sdjpainto.domain.Book;
import com.springframework.sdjpainto.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.springframework.sdjpainto.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SpringBootJpaTestSlice {
    @Autowired
    BookRepository bookRepository;

    @Rollback(value = false)
    @Order(1)
    @Test
    void testJpaTestSplice() {
        long countBefore = this.bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

        bookRepository.save(new Book("My book", "1235555", "Self"));

        long countAfter = this.bookRepository.count();
        assertThat(countBefore).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    void testJpaTestSpliceTransaction() {
        long countBefore = this.bookRepository.count();
        assertThat(countBefore).isEqualTo(3);
    }
}
