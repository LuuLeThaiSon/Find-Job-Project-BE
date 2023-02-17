package com.example.findjobbe.controller;

import com.example.findjobbe.model.ApplyJob;
import com.example.findjobbe.model.Job;
import com.example.findjobbe.service.impl.ApplyJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/apply")
public class ApplyJobController {
	@Autowired
	private ApplyJobService applyJobService;

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
	public ResponseEntity<ApplyJob> applyAssess(@PathVariable Long id) {
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


	@PostMapping ("/test/{id}")
	public ResponseEntity<List<Boolean>> test(@PathVariable Long id, @RequestBody List<Job> jobs) {
		List<Boolean> booleans = new ArrayList<>();
		for (int i = 0; i < jobs.size(); i++) {
			if (applyJobService.checkApplyJob(id, jobs.get(i).getId()).isPresent()) {
				booleans.add(true);
			} else booleans.add(false);
		}
		return new ResponseEntity<>(booleans, HttpStatus.OK);
	}
}
