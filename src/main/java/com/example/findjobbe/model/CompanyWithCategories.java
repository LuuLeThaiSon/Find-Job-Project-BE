package com.example.findjobbe.model;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class CompanyWithCategories {
    private Company company;
    private List<Category> categories;
}
