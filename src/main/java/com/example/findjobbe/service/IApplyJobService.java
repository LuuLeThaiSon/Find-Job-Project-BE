package com.example.findjobbe.service;

import com.example.findjobbe.model.ApplyJob;
import com.example.findjobbe.model.Candidate;
import com.example.findjobbe.model.Job;

import java.util.List;
import java.util.Optional;

public interface IApplyJobService extends ICoreCrud<ApplyJob, Long> {
	List<ApplyJob> findApplyJobByCandidate(Long id);
	Optional<ApplyJob> checkApplyJob(Long candidateId, Long jobId);
	List<Candidate> findAllCandidateApplyJobOfCompany(Long id);
	List<ApplyJob> findApplyJobByJob(Job job);

	ApplyJob findApplyJob(Long candidateId, Long jobId);

	void deleteApplyJobs(Long candidateId, Long jobId);

	List<ApplyJob> findApplyJobByCandidateId(Long id);
	void deleteApplyJobByJob(Long id);

}
