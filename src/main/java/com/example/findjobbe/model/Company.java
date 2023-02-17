package com.example.findjobbe.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Column(unique = true)
	private String name;
	@NotNull
	private String shortName;
	private String code;
	@Email
	@NotNull
	@Column(unique = true)
	private String email;
	private String password;
	@NotNull
	private String avatar;
	@NotNull
	private String description;
	private String address;
	private int numberOfEmployees;
	private String googleMap;
	private String tel;
	private String website;
	@ManyToOne(targetEntity = Role.class)
	private Role role;
	private boolean status;
	private String banner;

}
