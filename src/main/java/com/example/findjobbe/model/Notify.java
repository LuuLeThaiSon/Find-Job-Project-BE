package com.example.findjobbe.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Notify {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private NotifyType notifyType;
	@ManyToOne
	private Candidate candidate;
	@ManyToOne
	private Company company;
	@ManyToOne
	private Job job;
	private LocalDateTime dateTime;
	private Boolean status;
}
