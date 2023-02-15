package com.example.findjobbe.service;

import com.example.findjobbe.model.Job;
import org.springframework.http.ResponseEntity;

import java.util.List;
@Repository
public interface IJobService extends ICoreCrud<Job, Long>{
    ResponseEntity<Job> setStatus(Long id);
}
