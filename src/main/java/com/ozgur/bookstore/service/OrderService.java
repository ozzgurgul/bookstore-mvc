package com.ozgur.bookstore.service;

import com.ozgur.bookstore.entity.Book;
import com.ozgur.bookstore.entity.Orders;
import com.ozgur.bookstore.entity.customer.Customer;
import com.ozgur.bookstore.repository.BookRepository;
import com.ozgur.bookstore.repository.CustomerRepository;
import com.ozgur.bookstore.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookRepository bookRepository;


  public ResponseEntity<Object> create(String book_name,long customer_id){

      if(bookRepository.findByName(book_name) == null) {

          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found with name :" +"'"+ book_name +"'" );
      }

      if (customerRepository.findById(customer_id) == null){

          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found with id :" +"'"+ customer_id+"'" );
      }

        Book book = bookRepository.findByName(book_name);
        Customer customer= customerRepository.findById(customer_id);
        Orders order = new Orders();
        double totalPrice = book.getPrice() + order.getTotal();
        order.setTotal(totalPrice);
        order.setCreated_at(new Date(System.currentTimeMillis()));

        book.setName(book.getName());
        book.setCategory(book.getCategory());
        int stock = book.getCurrency_stock() -1;
        book.setCurrency_stock(stock);
        book.setPrice(book.getPrice());
        order.setBook(Collections.singletonList(book));
        order.setCustomer(customer);

        if(book.getCurrency_stock()<0){

            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("insufficient stock");
        }

        ordersRepository.save(order);

        return ResponseEntity.ok("order added");

    }

    public List<Orders> listAll(){

        return ordersRepository.findAll();
    }

}
