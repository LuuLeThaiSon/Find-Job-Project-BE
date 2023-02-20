package com.example.findjobbe.repository;

import com.example.findjobbe.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findJobsByCompanyId(Long id);
    List<Job> findJobsByCompanyIdOrderByIdDesc(Long id);

    @Query(value = "select j from Job j where j.expiredDate >= current_date and j.status = true")
    List<Job> findAllByStatusIsTrueAndAndExpiredDate();

    @Query(value = "select * from job join category_job cj on job.id = cj.job_id join category c on c.id = cj.category_id where c.id = ?1",nativeQuery = true)
    List<Job> findJobsByCategoryId(Long id);

    @Query(value = "SELECT j from Job j where j.status = true and j.expiredDate >= current_date and j.company.id = ?1")
    List<Job> findCurrentOpeningJobsByCompany(Long id);

    @Query(value = "select * from job join apply_job aj on job.id = aj.job_id join candidate c on aj.candidate_id = c.id where c.id = ?1",nativeQuery = true)
    List<Job> findJobsByCandidateId(Long id);
}
