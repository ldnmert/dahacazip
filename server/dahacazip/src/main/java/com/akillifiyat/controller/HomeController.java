package com.akillifiyat.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akillifiyat.entity.A101Discount;
import com.akillifiyat.entity.BimDiscount;
import com.akillifiyat.entity.CarrefourDiscount;
import com.akillifiyat.entity.MigrosDiscount;
import com.akillifiyat.repository.A101DiscountRepository;
import com.akillifiyat.repository.BimDiscountRepository;
import com.akillifiyat.repository.CarrefourDiscountRepository;
import com.akillifiyat.repository.MigrosDiscountRepository;

@RestController
@RequestMapping("/api")
public class HomeController {

	private final A101DiscountRepository a101DiscountRepository;
	private final MigrosDiscountRepository migrosDiscountRepository;
	private final BimDiscountRepository bimDiscountRepository;
	private final CarrefourDiscountRepository carrefourDiscountRepository;

//	@Autowired
	public HomeController(A101DiscountRepository a101DiscountRepository,
			MigrosDiscountRepository migrosDiscountRepository, BimDiscountRepository bimDiscountRepository,
			CarrefourDiscountRepository carrefourDiscountRepository) {
		this.a101DiscountRepository = a101DiscountRepository;
		this.migrosDiscountRepository = migrosDiscountRepository;
		this.bimDiscountRepository = bimDiscountRepository;
		this.carrefourDiscountRepository = carrefourDiscountRepository;
	}
	
	

	@GetMapping("/discount-products-migros")
	ResponseEntity<List<MigrosDiscount>> migrosDiscount() {

		List<MigrosDiscount> migrosDiscountList = migrosDiscountRepository.findAll();
		int i = 0;
		i += migrosDiscountList.size();
		System.out.println(i + "migros");
		return new ResponseEntity<>(migrosDiscountList, HttpStatus.OK);
	}

	@GetMapping("/discount-products-carrefour")
	public ResponseEntity<List<CarrefourDiscount>> carrefourDiscount() {
		List<CarrefourDiscount> carrefourDiscountList = carrefourDiscountRepository.findAll();
		int i = 0;
		i += carrefourDiscountList.size();
		System.out.println(i + "carrefoyr");
		return new ResponseEntity<>(carrefourDiscountList, HttpStatus.OK);
	}

	@GetMapping("/discount-products-bim")
	public ResponseEntity<List<BimDiscount>> bimDiscount() {
		List<BimDiscount> bimDiscountList = bimDiscountRepository.findAll();
		int i = 0;
		i += bimDiscountList.size();
		System.out.println(i + "bim");
		System.out.println();
		return new ResponseEntity<>(bimDiscountList, HttpStatus.OK);
	}

	@GetMapping("/discount-products-a101")
	public ResponseEntity<List<A101Discount>> a101Discount() {
		List<A101Discount> a101DiscountList = a101DiscountRepository.findAll();
		int i = 0;
		i += a101DiscountList.size();
		System.out.println(i + "a101");
	
		return new ResponseEntity<>(a101DiscountList, HttpStatus.OK);
	}
	

}
