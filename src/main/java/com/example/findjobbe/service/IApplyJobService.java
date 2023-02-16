package com.example.findjobbe.service;

import com.example.findjobbe.model.ApplyJob;

import java.util.List;
import java.util.Optional;

public interface IApplyJobService extends ICoreCrud<ApplyJob, Long> {
	List<ApplyJob> findApplyJobByCandidate(Long id);
	Optional<ApplyJob> checkApplyJob(Long candidateId, Long jobId);

}
