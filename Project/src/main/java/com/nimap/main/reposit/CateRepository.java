package com.nimap.main.reposit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimap.main.model.CategoryInfo;

@Repository
public interface CateRepository extends JpaRepository<CategoryInfo, Integer>{

		public CategoryInfo findBycateId(int cateid);
		
}
