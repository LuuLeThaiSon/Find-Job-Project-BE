package com.example.findjobbe.controller;

import com.example.findjobbe.model.Notify;
import com.example.findjobbe.model.NotifyType;
import com.example.findjobbe.service.impl.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/notify")
public class NotifyController {
	@Autowired
	private NotifyService notifyService;

	@GetMapping("/company/{id}")
	public ResponseEntity<List<Notify>> findAllCompanyNotify(@PathVariable Long id) {
		return new ResponseEntity<>(notifyService.findAllNotifyOfCompany(id), HttpStatus.OK);
	}

	@GetMapping("/candidate/{id}")
	public ResponseEntity<List<Notify>> findAllCandidateNotify(@PathVariable Long id) {
		return new ResponseEntity<>(notifyService.findAllNotifyOfCandidate(id), HttpStatus.OK);
	}

	@GetMapping("/count-unread/candidate/{id}")
	public ResponseEntity<Integer> countUnreadCandidateNotify(@PathVariable Long id) {
		return new ResponseEntity<>(notifyService.countUnreadCandidateNotify(id), HttpStatus.OK);
	}

	@GetMapping("/count-unread/company/{id}")
	public ResponseEntity<Integer> countUnreadCompanyNotify(@PathVariable Long id) {
		return new ResponseEntity<>(notifyService.countUnreadCompanyNotify(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Notify> readNotify(@PathVariable Long id) {
		Notify notify = notifyService.findOne(id).get();
		notify.setStatus(true);
		return new ResponseEntity<>(notifyService.save(notify), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Notify> sendNotify(@RequestBody Notify notify) {
		notify.setStatus(false);
		notify.setDateTime(LocalDateTime.now());
		return new ResponseEntity<>(notifyService.save(notify), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Notify> findOne(@PathVariable Long id) {
		return new ResponseEntity<>(notifyService.findOne(id).get(), HttpStatus.OK);
	}
	@GetMapping("/type")
	public ResponseEntity<List<NotifyType>> findAllNotifyType() {
		return new ResponseEntity<>(notifyService.findAllType(), HttpStatus.OK);
	}

}
