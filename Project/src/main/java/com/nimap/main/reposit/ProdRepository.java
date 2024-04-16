package com.nimap.main.reposit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimap.main.model.ProductInfo;

@Repository
public interface ProdRepository extends JpaRepository<ProductInfo, Integer>{

}
