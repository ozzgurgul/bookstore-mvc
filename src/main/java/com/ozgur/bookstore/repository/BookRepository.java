package com.ozgur.bookstore.repository;

import com.ozgur.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();
    Book findById(long id);
    Book findByName(String name);
}
