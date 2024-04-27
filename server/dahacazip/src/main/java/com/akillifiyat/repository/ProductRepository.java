package com.akillifiyat.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.akillifiyat.entity.Product;
	
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	@Query(value = "SELECT * FROM product WHERE MATCH(nameproduct) AGAINST (:keyword IN NATURAL LANGUAGE MODE) ORDER BY price DESC", nativeQuery = true)
	List<Product> findProductsDesc(@Param("keyword") String keyword);
//
//	
	@Query(value = "SELECT * FROM product WHERE MATCH(nameproduct) AGAINST (:keyword IN NATURAL LANGUAGE MODE) ORDER BY price ASC", nativeQuery = true)
	List<Product> findProductsAsc(@Param("keyword") String keyword);
	
	
	@Query(value = "SELECT * FROM product WHERE MATCH(nameproduct) AGAINST (:keyword IN NATURAL LANGUAGE MODE)", nativeQuery = true)
	List<Product> findProducts(@Param("keyword") String keyword);
	
//	@Query(value = "SELECT * FROM product WHERE nameproduct LIKE %:keyword%", nativeQuery = true)
//	List<Product> findProducts(@Param("keyword") String keyword);

//	@Query(value = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (PARTITION BY market_name ORDER BY price DESC) AS row_num FROM product WHERE MATCH(nameproduct) AGAINST (:keyword IN NATURAL LANGUAGE MODE)) AS ranked WHERE row_num <= 20", nativeQuery = true)
//	List<Product> findProductsDesc(@Param("keyword") String keyword);
	
//	@Query(value = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (PARTITION BY market_name ORDER BY price ASC) AS row_num FROM product WHERE MATCH(nameproduct) AGAINST (:keyword IN NATURAL LANGUAGE MODE)) AS ranked WHERE row_num <= 20", nativeQuery = true)
//	List<Product> findProductsAsc(@Param("keyword") String keyword);
	
//	@Query(value = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (PARTITION BY market_name) AS row_num FROM product WHERE MATCH(nameproduct) AGAINST (:keyword IN NATURAL LANGUAGE MODE)) AS ranked WHERE row_num <= 20", nativeQuery = true)
//	List<Product> findProducts(@Param("keyword") String keyword);
	



}
