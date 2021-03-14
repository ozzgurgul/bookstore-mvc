package com.ozgur.bookstore.controller;

import com.ozgur.bookstore.entity.Book;
import com.ozgur.bookstore.request.book.BookRequest;
import com.ozgur.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody BookRequest request){

        return bookService.createBook(request);

    }

    @GetMapping("/listAll")
    public List<Book> findAllBooks(){

        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable long id){

            return bookService.findById(id);

    }

    @GetMapping("/{name}")
    public Book findByName(@RequestParam(value="name") String name){

        return bookService.findByName(name);
    }
}
