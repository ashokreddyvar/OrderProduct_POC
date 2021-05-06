package com.example.ojas.DaoOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ojas.modelClasses.Product;
@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

}
