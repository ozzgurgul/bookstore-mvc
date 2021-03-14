package com.ozgur.bookstore.controller;

import com.ozgur.bookstore.entity.Book;
import com.ozgur.bookstore.entity.customer.Customer;
import com.ozgur.bookstore.request.customer.CustomerRequest;
import com.ozgur.bookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CustomerRequest request) {
        return customerService.create(request);
    }

    @GetMapping("/listAll")
    public List<Customer> findAllCustomers(){

        return customerService.findAll();
    }

    @GetMapping("/findCustomer/{id}")
    public Customer findById(@PathVariable long id){

        return customerService.findById(id);
    }


}
