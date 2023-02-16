package com.example.findjobbe.repository;

import com.example.findjobbe.model.ApplyJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplyJobRepository extends JpaRepository<ApplyJob, Long> {
	List<ApplyJob> findApplyJobByCandidate_Id(Long id);
	@Query(value = "select * from apply_job where candidate_id = ?1 and job_id = ?2 and status = false", nativeQuery = true)
	Optional<ApplyJob> checkApplyJob(Long candidateId, Long jobId);
}
