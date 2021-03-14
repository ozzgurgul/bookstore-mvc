package com.ozgur.bookstore.service;

import com.ozgur.bookstore.entity.Author;
import com.ozgur.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author findAuthorById(long id){

       return authorRepository.findById(id);
    }

}
