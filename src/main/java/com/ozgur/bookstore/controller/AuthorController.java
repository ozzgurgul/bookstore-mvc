package com.ozgur.bookstore.controller;


import com.ozgur.bookstore.entity.Author;
import com.ozgur.bookstore.entity.Book;
import com.ozgur.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}")
    public Author findById( @PathVariable long id ){

        return authorService.findAuthorById(id);
    }

}
