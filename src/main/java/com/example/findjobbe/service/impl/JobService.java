package com.example.findjobbe.service.impl;

import com.example.findjobbe.model.Job;
import com.example.findjobbe.repository.JobRepository;
import com.example.findjobbe.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService implements IJobService {
    @Autowired
    private JobRepository jobRepository;
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Optional<Job> findOne(Long id) {
        return jobRepository.findById(id);
    }

    @Override
    public Job save(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public void delete(Long id) {
        jobRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<Job> setStatus(Long id) {
        Optional<Job> job = jobRepository.findById(id);
        if (!job.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (job.get().isStatus()) {
            job.get().setStatus(false);
        } else {
            job.get().setStatus(true);
        }
        jobRepository.save(job.get());
        return new ResponseEntity<>(job.get(), HttpStatus.OK);
    }

    public List<Job> findAllJobsInCompany(Long id) {
        return jobRepository.findJobsByCompanyId(id);
    }


    public List<Job> findAllJobsInCompanyId(Long id) {
        return jobRepository.findJobsByCompanyId(id);
    }
}
