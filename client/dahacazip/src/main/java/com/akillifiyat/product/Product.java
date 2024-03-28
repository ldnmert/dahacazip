package com.akillifiyat.product;

public class Product {

	public String productName;
	public Float price;
	public Float priceWithoutDiscount;
	public String price2;
	public String price3;

	public Product(String productName, Float price, Float priceWithoutDiscount) {
		this.productName = productName;
		this.price = price;
		this.priceWithoutDiscount = priceWithoutDiscount;
	}

	public Product(String productName, Float price) {
		this.productName = productName;
		this.price = price;
	}
	
	public Product(String productName, String price2, String price3) {
		this.productName = productName;
		this.price2 = price2;
		this.price3 = price3;
	}
	

}
