package com.example.findjobbe.repository;

import com.example.findjobbe.model.ApplyJob;
import com.example.findjobbe.model.Candidate;
import com.example.findjobbe.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplyJobRepository extends JpaRepository<ApplyJob, Long> {
	List<ApplyJob> findApplyJobByCandidate_Id(Long id);

	@Query(value = "select * from apply_job where candidate_id = ?1 and job_id = ?2", nativeQuery = true)
	Optional<ApplyJob> checkApplyJob(Long candidateId, Long jobId);

	@Modifying
	@Query(value = "delete from apply_job where candidate_id = ?1 and job_id = ?2", nativeQuery = true)
	void deleteApplyJobs(Long candidate, Long jobId);

	List<ApplyJob> findApplyJobByCandidateId(Long id);

	@Query(value = "select * from candidate join apply_job aj on candidate.id = aj.candidate_id where job_id = ?1", nativeQuery = true)
	List<Candidate> findAllCandidateApplyJobOfCompany(Long id);
	List<ApplyJob> findApplyJobByJob(Job job);
	@Query(value = "select * from apply_job where candidate_id = ?1 and job_id = ?2", nativeQuery = true)
	ApplyJob findApplyJob(Long candidateId, Long jobId);

	@Modifying
	@Query(value = "delete from apply_job where job_id = ?1", nativeQuery = true)
	void deleteApplyJobByJob(Long id);
}
