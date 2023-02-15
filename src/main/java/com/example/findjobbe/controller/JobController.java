package com.example.findjobbe.controller;

import com.example.findjobbe.model.Job;
import com.example.findjobbe.service.impl.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> showAll() {
        List<Job> jobs = jobService.findAll();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<List<Job>> findAllByStatusIsTrueAndAndExpiredDate() {
        List<Job> jobs = jobService.findAllByStatusIsTrueAndAndExpiredDate();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Job> creatJob(@RequestBody Job job){
        return new ResponseEntity<>(jobService.save(job), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findOne(@PathVariable Long id){
        Optional<Job> jobOptional = jobService.findOne(id);
        if (!jobOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jobOptional.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Job> deleteJob(@PathVariable Long id) {
        Optional<Job> jobOptional = jobService.findOne(id);
        if (!jobOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        jobService.delete(id);
        return new ResponseEntity<>(jobOptional.get(), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job job) {
        Optional<Job> jobOptional = jobService.findOne(id);
        if (!jobOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        job.setId(jobOptional.get().getId());
        return new ResponseEntity<>(jobService.save(job), HttpStatus.OK);
    }

    @PutMapping("/set/{id}")
    public ResponseEntity<Job> setStatus(@PathVariable Long id) {
        return jobService.setStatus(id);
    }

    @GetMapping("/current/opening/{id}")
    public ResponseEntity<List<Job>> findCurrentOpeningJobsByCompany(@PathVariable Long id) {
        List<Job> jobs = jobService.findCurrentOpeningJobsByCompany(id);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Job>> findJobsByCategoryId(@PathVariable Long id) {
        return new ResponseEntity<>(jobService.findJobsByCategoryId(id), HttpStatus.OK);
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<List<Job>> findAllJobsByCompany(@PathVariable Long id) {
        List<Job> jobs = jobService.findAllJobsByCompanySortByIdDesc(id);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }
}