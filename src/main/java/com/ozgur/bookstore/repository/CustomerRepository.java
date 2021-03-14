package com.ozgur.bookstore.repository;

import com.ozgur.bookstore.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAll();
    Customer findById(long id);
}
