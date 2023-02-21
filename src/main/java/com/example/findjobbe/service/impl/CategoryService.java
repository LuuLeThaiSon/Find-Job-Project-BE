package com.example.findjobbe.service.impl;

import com.example.findjobbe.model.Category;
import com.example.findjobbe.repository.CategoryRepository;
import com.example.findjobbe.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> findOne(Long id) {
		return categoryRepository.findById(id);
	}

	@Override
	public Category save(Category category) {
		return null;
	}

	@Override
	public void delete(Long id) {

	}

	@Override
	public List<Category> findCategoriesByJobId(Long id) {
		return categoryRepository.findCategoriesByJobId(id);
	}

	@Override
	public List<Category> findCategoriesByCompanyId(Long id) {
		return categoryRepository.findCategoriesByCompanyId(id);
	}

	@Override
	public List<Category> findAllCategoriesOrderByNameAsc() {
		return categoryRepository.findAllCategoriesOrderByNameAsc();
	}
}
