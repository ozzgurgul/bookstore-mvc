package com.ozgur.bookstore.service;

import com.ozgur.bookstore.entity.customer.Adress;
import com.ozgur.bookstore.entity.customer.Contact;
import com.ozgur.bookstore.entity.customer.Customer;
import com.ozgur.bookstore.repository.CustomerRepository;
import com.ozgur.bookstore.request.customer.CustomerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public ResponseEntity<Object> create(CustomerRequest request) {

        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setLastName(request.getLastName());
        customer.setIdentificationNumber(request.getIdentificationNumber());

        Adress adress = new Adress(0L,request.getAddress().getCity(),request.getAddress().getStreet(),request.getAddress().getZipcode(),customer);
        Contact contact = new Contact(0L,request.getContact().getEmail(),request.getContact().getPhoneNumber(),customer);

        customer.setAdress(adress);
        customer.setContact(contact);

        customerRepository.save(customer);

        return ResponseEntity.status(HttpStatus.OK).body("Customer created");
    }

    public List<Customer> findAll(){

        return customerRepository.findAll();
    }

    public Customer findById(long id){

            return customerRepository.findById(id);

    }

    }

