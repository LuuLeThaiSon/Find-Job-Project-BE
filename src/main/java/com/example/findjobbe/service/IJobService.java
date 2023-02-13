package com.example.findjobbe.service;

import com.example.findjobbe.model.Job;
import org.springframework.http.ResponseEntity;


public interface IJobService extends ICoreCrud<Job, Long>{
    ResponseEntity<Job> setStatus(Long id);
}
