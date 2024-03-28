//package com.akillifiyat.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.akillifiyat.MarketAPIS.A101API;
//import com.akillifiyat.MarketAPIS.BimAPI;
//import com.akillifiyat.MarketAPIS.CarrefourAPI;
//import com.akillifiyat.MarketAPIS.MigrosAPI;
//import com.akillifiyat.entity.A101Discount;
//import com.akillifiyat.entity.BimDiscount;
//import com.akillifiyat.entity.CarrefourDiscount;
//import com.akillifiyat.entity.MigrosDiscount;
//
//@Service
//public class ApiService {
//
//	@Autowired
//	private MigrosAPI migrosAPI;
//
//	@Autowired
//	private CarrefourAPI carrefourAPI;
//
//	@Autowired
//	private A101API a101API;
//
//	@Autowired
//	private BimAPI bimAPI;
//
//	public List<MigrosDiscount> migrosDiscountProductsForHomepage() {
//		return migrosAPI.discountProducts();
//	}
//
//	public List<CarrefourDiscount> carrefoursaDiscountProductsForHomepage() {
//		return carrefourAPI.discountProducts();
//	}
//
//	public List<A101Discount> a101DiscountProductsForHomepage() {
//		return a101API.discountProducts();
//	}
//
//	public List<BimDiscount> bimDiscountProductsForHomepage() {
//
//		return bimAPI.discountProducts();
//
//	}
//
//}
