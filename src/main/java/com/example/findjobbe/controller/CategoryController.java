package com.example.findjobbe.controller;

import com.example.findjobbe.model.Category;
import com.example.findjobbe.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		return new ResponseEntity<>(categoryService.findAllCategoriesOrderByNameAsc(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	private ResponseEntity<Category> findOne(@PathVariable Long id) {
		return new ResponseEntity<>(categoryService.findOne(id).get(), HttpStatus.OK);
	}

    @GetMapping("/job/{id}")
    public ResponseEntity<List<Category>> findCategoriesByCompanyId(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.findCategoriesByJobId(id), HttpStatus.OK);
    }

	@GetMapping("/company/{id}")
	public ResponseEntity<List<Category>> findCategoriesByCompany(@PathVariable Long id) {
		return new ResponseEntity<>(categoryService.findCategoriesByCompanyId(id), HttpStatus.OK);
	}


}
