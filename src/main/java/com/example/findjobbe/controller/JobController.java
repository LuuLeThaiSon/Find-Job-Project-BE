package com.example.findjobbe.controller;

import com.example.findjobbe.model.Company;
import com.example.findjobbe.model.Job;
import com.example.findjobbe.service.impl.ApplyJobService;
import com.example.findjobbe.service.impl.CompanyService;
import com.example.findjobbe.service.impl.JobService;
import com.example.findjobbe.service.impl.NotifyService;
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
	@Autowired
	private CompanyService companyService;
    @Autowired
    private ApplyJobService applyJobService;
    @Autowired
    private NotifyService notifyService;

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
	public ResponseEntity<Job> creatJob(@RequestBody Job job) {
		jobService.save(job);
		Company company = companyService.findOne(job.getCompany().getId()).get();
		String code = company.getCode();
		job.setCode("CODE" + code + job.getId());
		jobService.save(job);
		return new ResponseEntity<>(job, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Job> findOne(@PathVariable Long id) {
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
        applyJobService.deleteApplyJobByJob(id);
        notifyService.deleteNotifyByJob(id);
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

	@GetMapping("/quantity/{idCompany}")
	public ResponseEntity<Iterable<Job>> findAllJobsInCompany(@PathVariable Long idCompany) {
		return new ResponseEntity<>(jobService.findAllJobsInCompanyId(idCompany), HttpStatus.OK);

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

	@GetMapping("/search/category")
	public ResponseEntity<List<Job>> findJobsByCategoryId(@RequestParam(name = "categoryId") Long id) {
		return new ResponseEntity<>(jobService.findJobsByCategoryId(id), HttpStatus.OK);
	}

	@GetMapping("/company/{id}")
	public ResponseEntity<List<Job>> findAllJobsByCompany(@PathVariable Long id) {
		List<Job> jobs = jobService.findAllJobsByCompanySortByIdDesc(id);
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Job>> findJobsByTitleAndLocationAndCompany(@RequestParam(name = "text") String text,
																		  @RequestParam(name = "locationId") Long locationId,
																		  @RequestParam(name = "categoryId") Long categoryId) {
		List<Job> jobs = jobService.findJobsByTitleContainingOrCompanyNameAndLocationIdAndCAndCategoryId('%' + text + '%', locationId, categoryId);
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}

	@GetMapping("/search/input")
	public ResponseEntity<List<Job>> findJobsByTitleContainingOrCompanyName(@RequestParam(name = "text") String text) {
		List<Job> jobs = jobService.findJobsByTitleContainingOrCompanyName('%' + text + '%');
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}

	@GetMapping("/search/location")
	public ResponseEntity<List<Job>> findJobsByLocationId(@RequestParam(name = "locationId") Long id) {
		List<Job> jobs = jobService.findJobsByLocationId(id);
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}

	@GetMapping("/search/text/location")
	public ResponseEntity<List<Job>> findJobsByTitleContainingAndLocationId(@RequestParam(name = "text") String text,
																			@RequestParam(name = "locationId") Long locationId) {
		List<Job> jobs = jobService.findJobsByTitleContainingAndLocationId('%' + text + '%', locationId);
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}

	@GetMapping("/search/text/category")
	public ResponseEntity<List<Job>> findJobsByTitleContainingAndCategoryId(@RequestParam(name = "text") String text,
																			@RequestParam(name = "categoryId") Long categoryId) {
		List<Job> jobs = jobService.findJobsByTitleContainingAndCategoryId('%' + text + '%', categoryId);
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}

	@GetMapping("/search/location/category")
	public ResponseEntity<List<Job>> findJobsByLocationIdAndCategoryId(@RequestParam(name = "locationId") Long locationId, @RequestParam(name = "categoryId") Long categoryId) {
		List<Job> jobs = jobService.findJobsByLocationIdAndCategoryId(locationId, categoryId);
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}


	@GetMapping("/candidate/{id}")
	public ResponseEntity<List<Job>> findAllJobsByCandidate(@PathVariable Long id) {
		List<Job> jobs = jobService.findJobsByCandidateId(id);
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}
}