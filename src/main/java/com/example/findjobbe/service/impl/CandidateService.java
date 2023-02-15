package com.example.findjobbe.service.impl;

import com.example.findjobbe.model.Candidate;
import com.example.findjobbe.repository.CandidateRepository;
import com.example.findjobbe.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CandidateService implements ICandidateService {
    @Autowired
    private CandidateRepository candidateRepository;
    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Optional<Candidate> findOne(Long id) {
        return candidateRepository.findById(id);
    }

    @Override
    public Candidate save(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public void delete(Long id) {
        candidateRepository.deleteById(id);
    }
}
