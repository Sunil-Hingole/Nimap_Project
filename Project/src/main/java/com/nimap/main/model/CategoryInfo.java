package com.nimap.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CategoryInfo {
	
	@Id
	private int cateId;
	
	private String cateType;
	
	private String cateAddedBy;
	
	
	public int getCateId() {
		return cateId;
	}
	public void setCateId(int cateId) {
		this.cateId = cateId;
	}
	public String getCateType() {
		return cateType;
	}
	public void setCateType(String cateType) {
		this.cateType = cateType;
	}
	public String getCateAddedBy() {
		return cateAddedBy;
	}
	public void setCateAddedBy(String cateAddedBy) {
		this.cateAddedBy = cateAddedBy;
	}
	
	
}
