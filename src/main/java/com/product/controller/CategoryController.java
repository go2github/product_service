package com.product.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Categories;
import com.product.repo.CategoryRepo;
import com.product.serviceImpl.CategoryServiceImpl;


@RestController
public class CategoryController {
	
	 
	@Autowired
	CategoryRepo repo;
	
	@Autowired
	CategoryServiceImpl service;
	
	
	@RequestMapping(value = "/category",method =RequestMethod.POST)
	private String addCategory(@RequestBody Categories categories) {
		repo.save(categories);
		return "category added";
	}
	
	@RequestMapping(value="/category/{id}",method=RequestMethod.GET)
	private Categories getCategory(@PathVariable String id) {
		Categories cat= service.getCategory(id);
		return cat;
		
	}

}
