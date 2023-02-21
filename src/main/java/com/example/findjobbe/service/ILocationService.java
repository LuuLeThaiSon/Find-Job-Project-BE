package com.example.findjobbe.service;

import com.example.findjobbe.model.Location;

import java.util.List;

public interface ILocationService extends ICoreCrud<Location, Long> {
    List<Location> findAllOrderByName();
}
