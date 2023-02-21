package com.example.findjobbe.controller;

import com.example.findjobbe.model.Location;
import com.example.findjobbe.service.impl.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/locations")
public class LocationController {
	@Autowired
	private LocationService locationService;

	@GetMapping
	public ResponseEntity<List<Location>> findAll() {
		return new ResponseEntity<>(locationService.findAllOrderByName(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Location> findOne(@PathVariable Long id) {
		return new ResponseEntity<>(locationService.findOne(id).get(), HttpStatus.OK);
	}
}
