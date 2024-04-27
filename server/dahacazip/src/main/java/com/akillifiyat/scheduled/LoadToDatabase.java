package com.akillifiyat.scheduled;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.akillifiyat.MarketAPIS.A101API;
import com.akillifiyat.MarketAPIS.CarrefourAPI;
import com.akillifiyat.MarketAPIS.MigrosAPI;
import com.akillifiyat.MarketAPIS.SokAPI;
import com.akillifiyat.entity.DiscountProduct;
import com.akillifiyat.entity.Product;
import com.akillifiyat.repository.DiscountProductRepository;
import com.akillifiyat.repository.ProductRepository;

@Service
public class LoadToDatabase {

	private MigrosAPI migrosAPI;
	
	private A101API a101API;
	
	private CarrefourAPI carrefourAPI;
	
	private SokAPI sokAPI;
	
	private ProductRepository productRepository;
	
	private DiscountProductRepository discountProductRepository;
	
	@Autowired
	public LoadToDatabase(A101API a101API, CarrefourAPI carrefourAPI, SokAPI sokAPI, ProductRepository productRepostiroy, DiscountProductRepository discountProductRepository, MigrosAPI migrosAPI) {
		this.a101API = a101API;
		this.carrefourAPI = carrefourAPI;
		this.sokAPI = sokAPI;
		this.productRepository = productRepostiroy;
		this.discountProductRepository = discountProductRepository;
		this.migrosAPI = migrosAPI;
	}



//
//	@Scheduled(fixedRate = 14400000)
//	void loadAllProducts() {
//		
//
//		
//		List<Product> a101Product = a101API.a101AllProducts();
//		for (Product p : a101Product)
//			productRepository.save(p);
		
//		List<Product> migrosProduct = migrosAPI.getAllMigrosProducts();
//		for (Product p : migrosProduct)
//			productRepository.save(p);
//
//		List<Product> carrefourProduct = carrefourAPI.getAllProducts();
//		for (Product p : carrefourProduct)
//			productRepository.save(p);
//
//		List<Product> sokProduct = sokAPI.getAllProducts();
//		for (Product p : sokProduct)
//			productRepository.save(p);
//	}
	
//	@Scheduled(fixedRate = 14400000)
//	void loadAllDiscountProducts() {
//
//		discountProductRepository.deleteAll();
//		
//		List<DiscountProduct> a101Product = a101API.discountProducts();
//		for (DiscountProduct p : a101Product)
//			discountProductRepository.save(p);
//
//		List<DiscountProduct> carrefourProduct = carrefourAPI.discountProducts();
//		for (DiscountProduct p : carrefourProduct)
//			discountProductRepository.save(p);
//
//		List<DiscountProduct> migrosProduct = migrosAPI.discountProducts();
//		for (DiscountProduct p : migrosProduct)
//			discountProductRepository.save(p);

//	}
	
}
