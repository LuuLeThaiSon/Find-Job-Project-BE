package com.example.findjobbe.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ApplyJob {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Job job;
	@ManyToOne
	private Candidate candidate;
	private boolean status;
	private String message;
	private String cv;
}
