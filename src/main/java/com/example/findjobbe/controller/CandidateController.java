package com.example.findjobbe.controller;

import com.example.findjobbe.model.Candidate;
import com.example.findjobbe.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/candidates")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @GetMapping
    public ResponseEntity<List<Candidate>> showAll() {
        List<Candidate> candidates = candidateService.findAll();
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Candidate> creatCandidate(@RequestBody Candidate candidate){
        return new ResponseEntity<>(candidateService.save(candidate), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> findOne(@PathVariable Long id){
        Optional<Candidate> candidateOptional = candidateService.findOne(id);
        if (!candidateOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(candidateOptional.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Candidate> deleteCandidate(@PathVariable Long id) {
        Optional<Candidate> candidateOptional = candidateService.findOne(id);
        if (!candidateOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        candidateService.delete(id);
        return new ResponseEntity<>(candidateOptional.get(), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidate> updateJob(@PathVariable Long id, @RequestBody Candidate candidate) {
        Optional<Candidate> candidateOptional = candidateService.findOne(id);
        if (!candidateOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        candidate.setId(candidateOptional.get().getId());
        return new ResponseEntity<>(candidateService.save(candidate), HttpStatus.OK);
    }
}
