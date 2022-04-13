package com.webproject.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;


@Data
@Entity
@Table(name = "Products")
public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	@Column(name = "product_name",columnDefinition = "nvarchar(100) not null")
	private String name;

	@Column(columnDefinition="Decimal(10,2) default '100.00'")
	private float price;

	@Column(columnDefinition = "integer default 0")
	private int quantity;

	@Column(length = 100, columnDefinition = "nvarchar(50) not null")
	private String unit;

	@Column(length = 100, columnDefinition = "nvarchar(255) null")
	private String image;

	@Column(columnDefinition = "integer default 0")
	private int views;

	@Column(length = 100, columnDefinition = "nvarchar(max) null")
	private String description;

	@Column(columnDefinition = "integer default 0")
	private int Discount;

	@Column(nullable = false)
	private Date creationDate;
	
	@ManyToOne
	@JoinColumn(name= "categoryId")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name= "brandId")
	private Brand brand;
	
	@OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
	private Set<OrderDetail> orderDetails;

}
