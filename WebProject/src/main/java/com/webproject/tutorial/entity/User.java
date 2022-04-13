package com.webproject.tutorial.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(columnDefinition = "nvarchar(255) not null")
	private String email;
	
	@Column(columnDefinition = "nvarchar(255) not null")
	private String password;
	
	@Column(columnDefinition = "nvarchar(255) not null")
	private String displayName;
	
	@Column(columnDefinition = "varchar(50) default 'ROLE_USER'")
	private String role;
	
	private boolean enable;
	
	private String otpCode;
	
	private Date requestOtp;
	
	@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
	private Set<Order> orders;
	
	
}
