package com.example.findjobbe.controller;

import com.example.findjobbe.model.ApplyJob;
import com.example.findjobbe.model.Candidate;
import com.example.findjobbe.model.Job;
import com.example.findjobbe.service.impl.ApplyJobService;
import com.example.findjobbe.service.impl.JobService;
import com.example.findjobbe.service.impl.CandidateService;
import com.example.findjobbe.service.impl.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/apply")
public class ApplyJobController {
	@Autowired
	private ApplyJobService applyJobService;
	@Autowired
	private JobService jobService;


	@Autowired
	private CandidateService candidateService;

	@GetMapping("/{id}")
	public ResponseEntity<ApplyJob> findOne(@PathVariable Long id) {
		if (!applyJobService.findOne(id).isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(applyJobService.findOne(id).get(), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<ApplyJob>> findAll() {
		return new ResponseEntity<>(applyJobService.findAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ApplyJob> create(@RequestBody ApplyJob applyJob) {
		return new ResponseEntity<>(applyJobService.save(applyJob), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApplyJob> delete(@PathVariable Long id) {
		if (!applyJobService.findOne(id).isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		applyJobService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


	@PutMapping("/{id}")
	public ResponseEntity<ApplyJob> acceptJob(@PathVariable Long id) {
		if (!applyJobService.findOne(id).isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ApplyJob applyJob = applyJobService.findOne(id).get();
		applyJob.setStatus(true);
		return new ResponseEntity<>(applyJobService.save(applyJob), HttpStatus.OK);
	}

	@GetMapping("/candidate/{id}")
	public ResponseEntity<List<ApplyJob>> findApplyJobByCandidate(@PathVariable Long id) {
		return new ResponseEntity<>(applyJobService.findApplyJobByCandidate(id), HttpStatus.OK);
	}

	@PostMapping ("/checkApply/{id}")
	public ResponseEntity<List<Boolean>> checkApply(@PathVariable Long id, @RequestBody List<Job> jobs) {
		List<Boolean> booleans = new ArrayList<>();
		for (int i = 0; i < jobs.size(); i++) {
			if (applyJobService.checkApplyJob(id, jobs.get(i).getId()).isPresent()) {
				booleans.add(true);
			} else booleans.add(false);
		}
		return new ResponseEntity<>(booleans, HttpStatus.OK);
	}

	@PostMapping ("/checkApplyAccept/{id}")
	public ResponseEntity<List<Boolean>> checkApplyAccept(@PathVariable Long id, @RequestBody List<Job> jobs) {
		List<Boolean> booleans = new ArrayList<>();
		for (int i = 0; i < jobs.size(); i++) {
			if (applyJobService.checkApplyJob(id, jobs.get(i).getId()).isPresent() && applyJobService.checkApplyJob(id, jobs.get(i).getId()).get().isStatus()) {
				booleans.add(true);
			} else booleans.add(false);
		}
		return new ResponseEntity<>(booleans, HttpStatus.OK);
	}

	@GetMapping("/candidate/job/{id}")
	public ResponseEntity<List<ApplyJob>> findAllApplyJob(@PathVariable Long id) {
		Job job = jobService.findOne(id).get();
		return new ResponseEntity<>(applyJobService.findApplyJobByJob(job), HttpStatus.OK);
	}

	@DeleteMapping ("/delete/{candidateId}&{jobId}")
	public ResponseEntity<ApplyJob> deleteJobCandidate(@PathVariable Long candidateId, @PathVariable Long jobId) {
		applyJobService.deleteApplyJobs(candidateId, jobId);
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
