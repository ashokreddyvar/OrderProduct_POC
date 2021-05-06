package com.example.ojas.DaoOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ojas.modelClasses.Order;
@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

}
