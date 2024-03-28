package com.akillifiyat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.akillifiyat.MarketAPIS.A101API;
import com.akillifiyat.MarketAPIS.BimAPI;
import com.akillifiyat.MarketAPIS.CarrefourAPI;
import com.akillifiyat.MarketAPIS.MigrosAPI;
import com.akillifiyat.entity.A101Discount;
import com.akillifiyat.entity.BimDiscount;
import com.akillifiyat.entity.CarrefourDiscount;
import com.akillifiyat.entity.MigrosDiscount;
import com.akillifiyat.repository.A101DiscountRepository;
import com.akillifiyat.repository.BimDiscountRepository;
import com.akillifiyat.repository.CarrefourDiscountRepository;
import com.akillifiyat.repository.MigrosDiscountRepository;

@Service
public class LoadToDatabaseDiscountService {

	private final A101DiscountRepository a101DiscountRepository;
	private final BimDiscountRepository bimDiscountRepository;
	private final CarrefourDiscountRepository carrefourDiscountRepository;
	private final MigrosDiscountRepository migrosDiscountRepository;
	private final MigrosAPI migrosAPI;
	private final BimAPI bimAPI;
	private final CarrefourAPI carrefourAPI;
	private final A101API a101API;

	@Autowired
	public LoadToDatabaseDiscountService(A101DiscountRepository a101DiscountRepository,
			BimDiscountRepository bimDiscountRepository, CarrefourDiscountRepository carrefourDiscountRepository,
			MigrosDiscountRepository migrosDiscountRepository, MigrosAPI migrosAPI, BimAPI bimAPI,
			CarrefourAPI carrefourAPI, A101API a101API) {
		this.a101DiscountRepository = a101DiscountRepository;
		this.bimDiscountRepository = bimDiscountRepository;
		this.carrefourDiscountRepository = carrefourDiscountRepository;
		this.migrosDiscountRepository = migrosDiscountRepository;
		this.migrosAPI = migrosAPI;
		this.bimAPI = bimAPI;
		this.carrefourAPI = carrefourAPI;
		this.a101API = a101API;
	}

//	@Scheduled(fixedRate = 60000)
	void loadToA101() {
		List<A101Discount> a101Discount = a101API.discountProducts();
		a101DiscountRepository.deleteAll();
		for (A101Discount discount : a101Discount)
			a101DiscountRepository.save(discount);

	}


//	@Scheduled(fixedRate = 60000)
	void loadToBim() {
		List<BimDiscount> bimDiscount = bimAPI.discountProducts();
		bimDiscountRepository.deleteAll();
		for (BimDiscount discount : bimDiscount)
			bimDiscountRepository.save(discount);

	}


	@Scheduled(fixedRate = 60000)
	void loadToCarrefour() {
		List<CarrefourDiscount> carrefourDiscount = carrefourAPI.discountProducts();
		carrefourDiscountRepository.deleteAll();
		for (CarrefourDiscount discount : carrefourDiscount)
			carrefourDiscountRepository.save(discount);

	}


	@Scheduled(fixedRate = 60000)
	void loadToMigros() {
		List<MigrosDiscount> migrosDiscount = migrosAPI.discountProducts();
		migrosDiscountRepository.deleteAll();
		System.out.println("heyoooo");
		for (MigrosDiscount discount : migrosDiscount)
			migrosDiscountRepository.save(discount);

	}
	
	

}
