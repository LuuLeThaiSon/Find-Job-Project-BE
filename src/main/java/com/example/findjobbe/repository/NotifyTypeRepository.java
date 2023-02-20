package com.example.findjobbe.repository;

import com.example.findjobbe.model.NotifyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotifyTypeRepository extends JpaRepository<NotifyType, Long> {
}
