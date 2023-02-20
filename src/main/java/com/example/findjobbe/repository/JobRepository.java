package com.example.findjobbe.repository;

import com.example.findjobbe.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Query(value = "select * from job j " +
            "join category c on c.id = j.category_id " +
            "join location l on l.id = j.location_id " +
            "where j.title like ?1 and c.id= ?2 and l.id= ?3", nativeQuery = true)
    List<Job> findJobsByTitleContainingOrCompanyNameAndLocationIdAndCAndCategoryId(String text, Long locationId, Long categoryId);

    @Query(value = "select * from job j " +
            "join company c on c.id = j.company_id " +
            "where j.title like ?1 or c.name like ?1", nativeQuery = true)
    List<Job> findJobsByTitleContainingOrCompanyName(String text);

    @Query(value = "select * from job j " +
            "where j.location_id = ?1", nativeQuery = true)
    List<Job> findJobsByLocationId(Long id);

    @Query(value = "select * from job j " +
            "join company c on c.id = j.company_id " +
            "where (j.title like ?1 or c.name like ?1) and  j.category_id = ?2",nativeQuery = true)
    List<Job> findJobsByTitleContainingAndCategoryId(String text, Long id);

    @Query(value = "select * from job j " +
            "join company c on c.id = j.company_id " +
            "where (j.title like ?1 or c.name like ?1) and  j.location_id = ?2",nativeQuery = true)
    List<Job>findJobsByTitleContainingAndLocationId(String text, Long id);

    @Query(value = "select * from job j " +
            "where j.location_id = ?1 and j.category_id = ?2", nativeQuery = true)
    List<Job>findJobsByLocationIdAndCategoryId(Long locationId, Long categoryId);
}
