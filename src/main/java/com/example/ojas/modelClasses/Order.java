package com.example.ojas.modelClasses;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name="user")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int quantuty;
	@CreationTimestamp
	private LocalDateTime ordertime;
	@UpdateTimestamp
	private LocalDateTime lastmodifiedtime;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Product product;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantuty() {
		return quantuty;
	}
	public void setQuantuty(int quantuty) {
		this.quantuty = quantuty;
	}
	
	public LocalDateTime getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(LocalDateTime ordertime) {
		this.ordertime = ordertime;
	}
	
	public LocalDateTime getLastmodifiedtime() {
		return lastmodifiedtime;
	}
	public void setLastmodifiedtime(LocalDateTime lastmodifiedtime) {
		this.lastmodifiedtime = lastmodifiedtime;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
