package com.example.findjobbe.service.impl;

import com.example.findjobbe.model.Location;
import com.example.findjobbe.repository.LocationRepository;
import com.example.findjobbe.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LocationService implements ILocationService {
	@Autowired
	private LocationRepository locationRepository;
	@Override
	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	@Override
	public Optional<Location> findOne(Long id) {
		return locationRepository.findById(id);
	}

	@Override
	public Location save(Location location) {
		return null;
	}

	@Override
	public void delete(Long aLong) {

	}

	@Override
	public List<Location> findAllOrderByName() {
		return locationRepository.findAllOrderByName();
	}
}
