package com.example.ojas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ojas.DaoOrder.OrderDao;
import com.example.ojas.DaoOrder.ProductDao;
import com.example.ojas.modelClasses.Order;
import com.example.ojas.modelClasses.Product;

@Service
public class ServiceOfOrderAndProduct {
	@Autowired
	public OrderDao rdao;
	@Autowired
	public ProductDao pdao;
	
	public Order addOrder(Order order) {
		return rdao.save(order);
		
	}
	public Product addProduct(Product product) {
		return pdao.save(product);
		
		
	}
	public Iterable<Product> getProduct() {
        return pdao.findAll();
    } 
	   public Iterable<Order> getOrder() {
	        return rdao.findAll();
	    }
	    
	    public Iterable<Order> getAllOrder() {
	        return rdao.findAll();
	    }
	 public Optional<Product> getProductById(Integer productid){
	        return pdao.findById(productid);
	    }
	    public Optional<Order> getOrderId(Integer orderid) {
	        return rdao.findById(orderid);
	    }
	    
	    public int placeOrder(Integer productId, Integer quantity, Order order) {
			int result = 1;
			Product product = pdao.findById(productId).orElse(new Product());
			if(product == null)
				return result;
			order.setQuantuty(quantity);
			
			order.setProduct(product);
			rdao.save(order);
			result = 0;
			return result;
			
		}
		
		public int updateOrder(Integer id, Integer quantity) {
			int result = 1;
			Order order = rdao.findById(id).orElse(new Order());
			if(order == null) {
				return result;
			}
			
			order.setQuantuty(quantity);
			rdao.save(order); 
			result = 0;
			
			return result;
		}
	}

	
	
	


