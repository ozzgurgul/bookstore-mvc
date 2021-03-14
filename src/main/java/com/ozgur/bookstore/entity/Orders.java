package com.ozgur.bookstore.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ozgur.bookstore.entity.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date created_at;
    private double total;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
        name = "order_books",
        joinColumns =@JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> book;

}
