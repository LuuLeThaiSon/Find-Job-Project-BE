package com.example.findjobbe.model;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String name;
	@NotNull
	@Email
	@Column(unique = true)
	private String email;
	@NotNull
	@Size(min = 8)
	private String password;
	private String tel;
	@ManyToOne(targetEntity = Role.class)
	private Role role;
}
