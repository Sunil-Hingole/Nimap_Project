package com.nimap.main.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.main.model.CategoryInfo;
import com.nimap.main.model.ProductInfo;
import com.nimap.main.reposit.CateRepository;
import com.nimap.main.reposit.ProdRepository;

@Service
public class ProdService {

	@Autowired
	ProdRepository productRepository;
	
	@Autowired
	CateRepository categoryRepository;
	
	
	public ProductInfo insert_ProductInformation(ProductInfo ProdInfo) {
		CategoryInfo cateInfo=categoryRepository.findBycateId(ProdInfo.getCategory().getCateId());
		ProdInfo.setCategory(cateInfo);
		return productRepository.save(ProdInfo);
	}
	
	public ProductInfo update_ProductInformationById(ProductInfo prodInfo, int prodId) {
		ProductInfo p=productRepository.findById(prodId).get();
		p.setName(prodInfo.getName());
		p.setQuantity(prodInfo.getQuantity());
		p.setPrice(prodInfo.getPrice());
		CategoryInfo cate=categoryRepository.findBycateId(prodInfo.getCategory().getCateId());
		p.setCategory(cate);
		productRepository.save(p);
		return p;
	}
	
	
	public ProductInfo get_ProductInformation(int prodId) {
		ProductInfo prodInfo=productRepository.findById(prodId).get();
		return prodInfo;
	}
	
	
	public List<ProductInfo> get_ProductsInformation(int p, int ps){
		Pageable page=PageRequest.of(p, ps);
		Page<ProductInfo> productPage=productRepository.findAll(page);
		return productPage.getContent();
	}
	
	
	public void delete_ProductsInformation(int prodId) {
		productRepository.deleteById(prodId);
	}
}
