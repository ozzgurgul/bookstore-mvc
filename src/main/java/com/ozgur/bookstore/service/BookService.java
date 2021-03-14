package com.ozgur.bookstore.service;

import com.ozgur.bookstore.entity.Author;
import com.ozgur.bookstore.entity.Book;
import com.ozgur.bookstore.entity.Category;
import com.ozgur.bookstore.repository.BookRepository;
import com.ozgur.bookstore.request.book.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public ResponseEntity<Object> createBook(BookRequest request) {

        Book book = new Book();
        book.setName(request.getName());
        book.setAddedDate(request.getAddedDate());
        book.setPrice(request.getPrice());
        book.setCurrency_stock(request.getCurrency_stock());

        Author author = new Author(0L, request.getAuthor().getAuthor_name(), Collections.singletonList(book));
        Category category = new Category(0L, request.getCategory().getCategory_name(), Collections.singletonList(book));

        book.setAuthor(author);
        book.setCategory(category);

        bookRepository.save(book);

        return ResponseEntity.ok("Book added");

    }

    public List<Book> findAll() {

        return bookRepository.findAll();
    }

    public Book findById(long id) {

            return bookRepository.findById(id);

    }

    public Book findByName(String name){

        return bookRepository.findByName(name);
    }

    }


