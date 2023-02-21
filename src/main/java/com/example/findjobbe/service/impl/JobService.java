package com.example.findjobbe.service.impl;

import com.example.findjobbe.model.Job;
import com.example.findjobbe.repository.JobRepository;
import com.example.findjobbe.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Override
    public List<Job> findAllByStatusIsTrueAndAndExpiredDate() {
        return jobRepository.findAllByStatusIsTrueAndAndExpiredDate();
    }

    @Override
    public List<Job> findJobsByCategoryId(Long id) {
        return jobRepository.findJobsByCategoryId(id);
    }

    @Override
    public List<Job> findJobsByTitleContainingOrCompanyNameAndLocationIdAndCAndCategoryId(String text, Long locationId, Long categoryId) {
        return jobRepository.findJobsByTitleContainingOrCompanyNameAndLocationIdAndCAndCategoryId(text, locationId, categoryId);
    }

    @Override
    public List<Job> findJobsByCandidateId(Long id) {
        return jobRepository.findJobsByCandidateId(id);
    }

    public List<Job> findAllJobsInCompany(Long id) {
        return jobRepository.findJobsByCompanyId(id);
    }

    @Override
    public List<Job> findCurrentOpeningJobsByCompany(Long id) {
        return jobRepository.findCurrentOpeningJobsByCompany(id);
    }

    @Override
    public List<Job> findAllJobsByCompanySortByIdDesc(Long id) {
        return jobRepository.findJobsByCompanyIdOrderByIdDesc(id);
    }


    public List<Job> findAllJobsInCompanyId(Long id) {
        return jobRepository.findJobsByCompanyId(id);
    }

    @Override
    public List<Job> findJobsByTitleContainingOrCompanyName(String text) {
        return jobRepository.findJobsByTitleContainingOrCompanyName(text);
    }

    @Override
    public List<Job> findJobsByLocationId(Long id) {
        return jobRepository.findJobsByLocationId(id);
    }

    @Override
    public List<Job> findJobsByTitleContainingAndCategoryId(String text, Long id) {
        return jobRepository.findJobsByTitleContainingAndCategoryId(text, id);
    }

    @Override
    public List<Job> findJobsByTitleContainingAndLocationId(String text, Long id) {
        return jobRepository.findJobsByTitleContainingAndLocationId(text,id);
    }

    @Override
    public List<Job> findJobsByLocationIdAndCategoryId(Long locationId, Long categoryId) {
        return jobRepository.findJobsByLocationIdAndCategoryId(locationId,categoryId);
    }

}