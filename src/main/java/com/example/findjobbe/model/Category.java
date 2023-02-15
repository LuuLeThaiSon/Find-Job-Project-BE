package com.example.findjobbe.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ManyToMany(targetEntity = Company.class)
	@JoinTable(
		name = "category_company",
		joinColumns = {
			@JoinColumn(name = "category_id")
		},
		inverseJoinColumns = {
			@JoinColumn(name = "company_id")
		}
	)
	private Set<Company> companies = new HashSet<>();
}
