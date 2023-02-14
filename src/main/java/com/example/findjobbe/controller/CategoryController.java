package com.example.findjobbe.controller;

import com.example.findjobbe.model.Category;
import com.example.findjobbe.repository.CategoryRepository;
import com.example.findjobbe.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	private ResponseEntity<Category> findOne(@PathVariable Long id) {
		return new ResponseEntity<>(categoryService.findOne(id).get(), HttpStatus.OK);
	}
}
