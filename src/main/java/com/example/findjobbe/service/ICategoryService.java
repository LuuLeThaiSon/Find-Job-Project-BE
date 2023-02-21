package com.example.findjobbe.service;

import com.example.findjobbe.model.Category;

import java.util.List;

public interface ICategoryService extends ICoreCrud<Category, Long> {

    List<Category> findCategoriesByJobId(Long id);
    List<Category>findCategoriesByCompanyId(Long id);

    List<Category>findAllCategoriesOrderByNameAsc();
}
