package com.example.findjobbe.service;

import com.example.findjobbe.model.Job;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface IJobService extends ICoreCrud<Job, Long>{
    ResponseEntity<Job> setStatus(Long id);

    List<Job> findAllByStatusIsTrueAndAndExpiredDate();

    List<Job> findCurrentOpeningJobsByCompany(Long id);
    List<Job> findAllJobsByCompanySortByIdDesc(Long id);

}
