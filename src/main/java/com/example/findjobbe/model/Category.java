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
	@ManyToMany(targetEntity = Job.class)
	@JoinTable(
		name = "category_job",
		joinColumns = {
			@JoinColumn(name = "category_id")
		},
		inverseJoinColumns = {
			@JoinColumn(name = "job_id")
		}
	)
	private Set<Company> companies = new HashSet<>();
}
