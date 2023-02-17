package com.example.findjobbe.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	private String tel;
	@ManyToOne(targetEntity = Role.class)
	private Role role;
	private String avatar;

	private Boolean status;

	private String address;

	private String description;

}
