package com.ozgur.bookstore.request.book;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"name","addedDate","price","currency_stock","author","category"})
public class BookRequest {

    private String name;
    private Date addedDate;
    private double price;
    private int currency_stock;

    private AuthorRequest author;
    private CategoryRequest category;

}
