package com.webproject.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "Brands")
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long brandId;

	@Column(name = "brand_name", columnDefinition = "nvarchar(100) not null")
	private String name;

	@Column(columnDefinition = "nvarchar(255) null")
	private String logo;
	
	@OneToMany(mappedBy = "brand",cascade = CascadeType.ALL)
	private Set<Product> products;
}
