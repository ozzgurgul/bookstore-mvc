package com.ozgur.bookstore.repository;

import com.ozgur.bookstore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    Author findById(long id);

}
