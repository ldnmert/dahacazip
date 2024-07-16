package com.akillifiyat.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akillifiyat.MarketAPIS.A101API;
import com.akillifiyat.MarketAPIS.CarrefourAPI;
import com.akillifiyat.MarketAPIS.MigrosAPI;
import com.akillifiyat.MarketAPIS.SokAPI;
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

	public LoadToDatabase(A101API a101API, CarrefourAPI carrefourAPI, SokAPI sokAPI,
			ProductRepository productRepostiroy, DiscountProductRepository discountProductRepository,
			MigrosAPI migrosAPI) {
		this.a101API = a101API;
		this.carrefourAPI = carrefourAPI;
		this.sokAPI = sokAPI;
		this.productRepository = productRepostiroy;
		this.discountProductRepository = discountProductRepository;
		this.migrosAPI = migrosAPI;
	}

//	@Scheduled(fixedRate = 3600)
//	void loadDatabase() {
//		sokAPI.getAllProducts();

//	}

}
