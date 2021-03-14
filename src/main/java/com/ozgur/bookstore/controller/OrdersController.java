package com.ozgur.bookstore.controller;


import com.ozgur.bookstore.entity.Orders;
import com.ozgur.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{book_name}/{customer_id}")
    public ResponseEntity<Object> createOrder(@PathVariable String book_name, @PathVariable long customer_id){

        return orderService.create(book_name, customer_id);

    }

    @GetMapping
    public List<Orders> listAll(){

        return orderService.listAll();
    }


}
