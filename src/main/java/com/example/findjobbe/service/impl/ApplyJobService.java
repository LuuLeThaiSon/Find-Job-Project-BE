package com.example.findjobbe.service.impl;

import com.example.findjobbe.model.ApplyJob;
import com.example.findjobbe.repository.ApplyJobRepository;
import com.example.findjobbe.service.IApplyJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ApplyJobService implements IApplyJobService {
	@Autowired
	private ApplyJobRepository applyJobRepository;
	@Override
	public List<ApplyJob> findAll() {
		return applyJobRepository.findAll();
	}

	@Override
	public Optional<ApplyJob> findOne(Long id) {
		return applyJobRepository.findById(id);
	}

	@Override
	public ApplyJob save(ApplyJob applyJob) {
		return applyJobRepository.save(applyJob);
	}

	@Override
	public void delete(Long id) {
		applyJobRepository.deleteById(id);
	}

	@Override
	public List<ApplyJob> findApplyJobByCandidate(Long id) {
		return applyJobRepository.findApplyJobByCandidate_Id(id);
	}

	@Override
	public Optional<ApplyJob> checkApplyJob(Long candidateId, Long jobId) {
		return applyJobRepository.checkApplyJob(candidateId, jobId);
	}

	@Override
	@Transactional
	public void deleteApplyJobs(Long candidateId, Long jobId) {
		applyJobRepository.deleteApplyJobs(candidateId, jobId);
	}

	@Override
	public List<ApplyJob> findApplyJobByCandidateId(Long id) {
		return null;
	}


}
