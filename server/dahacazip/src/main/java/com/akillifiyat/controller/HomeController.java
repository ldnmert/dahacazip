package com.akillifiyat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akillifiyat.entity.DiscountProduct;

import com.akillifiyat.repository.DiscountProductRepository;

@RestController
@RequestMapping("/discount")
public class HomeController {

	DiscountProductRepository discountProductRepository;

	@Autowired
	public HomeController(DiscountProductRepository discountProductRepository) {

		this.discountProductRepository = discountProductRepository;
	}

	@GetMapping("/get-discount-products")
	ResponseEntity<List<DiscountProduct>> migrosDiscount() {

		List<DiscountProduct> discountProducts = discountProductRepository.findAll();
		return new ResponseEntity<>(discountProducts, HttpStatus.OK);
	}

}
