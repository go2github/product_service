package com.product.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.controller.CategoryController;
import com.product.entity.Categories;
import com.product.repo.CategoryRepo;
import com.product.service.CategoryService;
import com.product.util.RedisUtil;

@Service

public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepo repo;
	
	private RedisUtil<Categories> redis;
	
	Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	public CategoryServiceImpl(RedisUtil<Categories> redis) {
		this.redis=redis;
		
	}

	@Override
	public Categories getCategory(String id) {
		Categories cat=redis.getValue(id);
		if(cat!=null) {
			logger.info("value from cache");
			return cat;
		}
		cat=repo.getCategoryById(Integer.valueOf(id));
		if(cat!=null) {
			logger.info("value from db");
			redis.putValue(id, cat);
			return cat;
		}
		return cat;
	}

}
