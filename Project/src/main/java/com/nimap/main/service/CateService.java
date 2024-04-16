package com.nimap.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.main.model.CategoryInfo;
import com.nimap.main.reposit.CateRepository;

@Service
public class CateService {

	@Autowired
	CateRepository categoryRepository;
	
	
	public CategoryInfo insert_CategoryInformation(CategoryInfo CateInfo) {
		return categoryRepository.save(CateInfo);
	}
	
	public CategoryInfo update_CategoryInformationById(CategoryInfo cateInfo, int cateId) {
		CategoryInfo c=categoryRepository.findById(cateId).get();
		c.setCateType(cateInfo.getCateType());
		c.setCateAddedBy(cateInfo.getCateAddedBy());
		return categoryRepository.save(c);
	}
	
	public CategoryInfo get_CategoryInformation(int cateId) {
		CategoryInfo cateInfo=categoryRepository.findById(cateId).get();
		return cateInfo;
	}
	
	
	public List<CategoryInfo> get_CategorysInfomation(int p,int ps){
		Pageable page=PageRequest.of(p, ps);
		Page<CategoryInfo> categoryPage=categoryRepository.findAll(page);
		return categoryPage.getContent();
	}
	
	
	public void delete_CategorysInfomation(int cateId)	{
		categoryRepository.deleteById(cateId);
	}
}
