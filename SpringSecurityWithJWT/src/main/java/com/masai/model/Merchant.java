package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Merchant {
	
	private Integer mId;
	private String name;
	@Column(unique = true)
	private String email;
	private LocalDate dob;
	private String address;
	private String password;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "merchant")
	private List<Product> products=new ArrayList<>();
}
