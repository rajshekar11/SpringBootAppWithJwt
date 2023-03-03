package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	
	private Integer pId;
	private String productName;
	private Integer quantity;
	private Double price;
	@ManyToOne
	private Merchant merchant;

}
