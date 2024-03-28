package com.akillifiyat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class MigrosDiscount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(unique = true)
	String name;

	Float price;

	Float priceWithoutDiscount;

	String image;

	Integer discountRate;
	
	public MigrosDiscount(String name, Float priceWithoutDiscount, Float price, Integer discountRate ,String image) {

		this.name = name;
		this.price = price;
		this.priceWithoutDiscount = priceWithoutDiscount;
		this.image = image;
		this.discountRate = discountRate;
	}

}
