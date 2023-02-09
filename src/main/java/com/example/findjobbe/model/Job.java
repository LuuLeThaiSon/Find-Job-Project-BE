package com.example.findjobbe.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Data
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String title;
	private String code;
	@NotNull
	@Min(value = 0)
	private Double salaryMin;
	@NotNull
	@Min(value = 0)
	private Double salaryMax;
	@NotNull
	private String position;
	@NotNull
	@Min(value = 0)
	private int expYear;
	@NotNull
	private boolean type;
	@NotNull
	private Date expriredDate;
	@NotNull
	private String description;
	@NotNull
	private int quantity;
	@NotNull
	private boolean gender;
	@ManyToOne(targetEntity = Location.class)
	private Location location;
	@ManyToOne(targetEntity = Company.class)
	private Company company;
}
