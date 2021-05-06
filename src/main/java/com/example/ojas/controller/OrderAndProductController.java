package com.example.ojas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ojas.modelClasses.Messeges;
import com.example.ojas.modelClasses.Order;
import com.example.ojas.modelClasses.Product;
import com.example.ojas.service.ServiceOfOrderAndProduct;

@RestController
@RequestMapping("/rest")
public class OrderAndProductController {
	@Autowired
	ServiceOfOrderAndProduct serviceop;
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
	return serviceop.addProduct(product);
}
	@GetMapping("/getproduct/list")
	public Iterable<Product> getProduct1() {
		
		return serviceop.getProduct();
	}

	@PostMapping("/create/order")
	public Order addOrder(@RequestBody Order order) {
	return serviceop.addOrder(order);
}
	@GetMapping("/getorder")
	public Iterable<Order> getOrder( Order order) {
		return serviceop.getOrder();
	}
	 @GetMapping("/product/get")
	    public Optional<Product> getProduct(@PathVariable("id") Integer id){
	       // model.addAttribute("id", id);
	        return serviceop.getProductById(id);
	    }
	    
	    @GetMapping("/getorderid/{id}")
	    public Optional<Order> getOrder(@PathVariable("id") Integer id){
	     //   model.addAttribute("id", id);
	        return serviceop.getOrderId(id);
	    }

@GetMapping("/order/place")
public Messeges placeOrder(@RequestParam("product_id") Integer id, @RequestParam("quantity") Integer quantity) {
	Messeges msg = getMsgObj();
	try {
		Order order = new Order();
		int code = serviceop.placeOrder(id, quantity, order);
		if(code == 0) {
			msg.setCode(0);
			msg.setMessage("Success");
		}
		else if(code == 1) {
			msg.setCode(1);
			msg.setMessage("Invalid");
		}
		return msg;
	} catch (Exception e) {
		return msg;
	}
}

@GetMapping("/order/update")
public Messeges updateOrder(@RequestParam("id") Integer id, @RequestParam("quantity") Integer quantity) {
	Messeges msg = getMsgObj();
	try {
		int code = serviceop.updateOrder(id, quantity);
		if(code == 0) {
			msg.setCode(0);
			msg.setMessage("Success");
		}
		else if(code == 1) {
			msg.setCode(1);
			msg.setMessage("Invalid");
		}
		return msg;
	} catch (Exception e) {
		return msg;
	}
}

public static Messeges getMsgObj() {
	return new Messeges();
}

}


