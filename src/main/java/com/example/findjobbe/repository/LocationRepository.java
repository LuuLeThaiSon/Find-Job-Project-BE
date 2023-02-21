package com.example.findjobbe.repository;

import com.example.findjobbe.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query(value = "select l from Location l ORDER BY l.name")
    List<Location> findAllOrderByName();
}
