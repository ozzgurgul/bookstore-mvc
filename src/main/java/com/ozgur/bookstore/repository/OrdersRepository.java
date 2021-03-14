package com.ozgur.bookstore.repository;

import com.ozgur.bookstore.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders,Long> {

    List<Orders> findById(long order_id);

}
