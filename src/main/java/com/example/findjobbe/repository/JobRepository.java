package com.example.findjobbe.repository;

import com.example.findjobbe.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findJobsByCompanyId(Long id);

    @Query(value = "select j from Job j where j.expiredDate > current_date and j.status = true")
    List<Job> findAllByStatusIsTrueAndAndExpiredDate();
}
