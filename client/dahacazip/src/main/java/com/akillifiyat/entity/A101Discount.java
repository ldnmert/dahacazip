package com.akillifiyat.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class A101Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(unique = true)
	String name;

	String price;

	String priceWithoutDiscount;

	
	String image;

	public A101Discount(String name, String price, String priceWithoutDiscount, String image) {

		this.name = name;
		this.price = price;
		this.priceWithoutDiscount = priceWithoutDiscount;
		this.image = image;
	}

}
