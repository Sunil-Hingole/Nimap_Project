package com.nimap.main.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nimap.main.model.CategoryInfo;
import com.nimap.main.model.ProductInfo;
import com.nimap.main.service.CateService;
import com.nimap.main.service.ProdService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class MainControl {

	@Autowired
	ProdService productService;
	
	@Autowired
	CateService categoryService;
	
	
	//CATEGORY
	//POST
	@PostMapping("/api/categories")
	public CategoryInfo InsertCategorysInformation(@RequestBody CategoryInfo cateInfo) {
		return categoryService.insert_CategoryInformation(cateInfo);
	}
	
	//DELETE_ID
	@DeleteMapping("/api/categories/{di}")
	public void deleteCategorysInformation(@PathVariable("di") int cateId) {
		categoryService.delete_CategorysInfomation(cateId);
	}
	
	//PUT_ID
	@PutMapping("/api/categories/{di}")
	public CategoryInfo putCategorysInformation(@RequestBody CategoryInfo cateInfo, @PathVariable("di") int cateId) {
		return categoryService.update_CategoryInformationById(cateInfo, cateId);
	}
	
	//GET_PAGE
	@GetMapping("/api/categories")
	public List<CategoryInfo> categorysInformation(@RequestParam (value="page", defaultValue="0", required=false)int page) {
		return categoryService.get_CategorysInfomation(page, 1);
	}
	
	//GET_ID
	@GetMapping("/api/categories/{di}")
	public CategoryInfo categoryInformation(@PathVariable("di") int cateId) {
		return categoryService.get_CategoryInformation(cateId);
	}
	
	
	/*
	=========================================================================================================================
	*/
	
	
	//PRODUCT
	//POST
		@PostMapping("/api/products")
		public ProductInfo InsertProductInformation(@RequestBody ProductInfo prodInfo) {
			return productService.insert_ProductInformation(prodInfo);
		}
		
		//DELETE_ID
		@DeleteMapping("/api/products/{di}")
		public void deleteProductsInformation(@PathVariable("di") int prodId) {
			productService.delete_ProductsInformation(prodId);
		}
		
		//PUT_ID
		@PutMapping("/api/products/{di}")
		public ProductInfo putProductsInformation(@RequestBody ProductInfo prodInfo, @PathVariable("di") int prodId) {
			return productService.update_ProductInformationById(prodInfo, prodId);
		}
		
		//GET_PAGE
		@GetMapping("/api/products")
		public List<ProductInfo> productsInformation(@RequestParam (value="page", defaultValue="0", required=false)int page) {
			return productService.get_ProductsInformation(page, 1);
		}
		
		//GET_ID
		@GetMapping("/api/products/{di}")
		public ProductInfo productInformation(@PathVariable("di") int prodId) {
			return productService.get_ProductInformation(prodId);
		}
}
