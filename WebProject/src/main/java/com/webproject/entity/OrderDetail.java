package com.webproject.entity;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;


@Data
@Entity
@Table(name = "Orderdetails")
public class OrderDetail implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderDetailId;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = true)
	private float total;
	
	@ManyToOne
	@JoinColumn(name= "orderId")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name= "productId")
	private Product product;
	
}
