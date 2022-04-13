package com.webproject.tutorial.entity;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "Orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@Column(columnDefinition = "nvarchar(255) not null")
	private String address;
	
	@Column(length = 100)
	private String phone;
	
	@Column(columnDefinition = "nvarchar(100) not null")
	private String status;
	
	@Column(nullable = false)
	private Date creationDate;
	
	@Column(nullable = false)
	private Date deliveryDate;
	
	@OneToMany(mappedBy = "order" , cascade = CascadeType.ALL)
	private Set<OrderDetail> orderDetails;
	
	@ManyToOne
	@JoinColumn(name= "userId")
	private User user;
}
