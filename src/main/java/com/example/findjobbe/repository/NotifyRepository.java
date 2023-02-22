package com.example.findjobbe.repository;

import com.example.findjobbe.model.Notify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotifyRepository extends JpaRepository<Notify, Long> {
	@Query(value = "select * from notify where candidate_id = ?1 and (notify_type_id = 3 or notify_type_id = 4)", nativeQuery = true)
	List<Notify> findAllNotifyOfCandidate(Long id);

	@Query(value = "select * from notify where company_id = ?1 and (notify_type_id = 1 or notify_type_id = 2)", nativeQuery = true)
	List<Notify> findAllNotifyOfCompany(Long id);

	@Query(value = "select count(*) from notify where candidate_id = ?1 and status = false and (notify_type_id = 3 or notify_type_id = 4)", nativeQuery = true)
	Integer countUnreadCandidateNotify(Long id);
	@Query(value = "select count(*) from notify where company_id = ?1 and status = false and (notify_type_id = 1 or notify_type_id = 2)", nativeQuery = true)
	Integer countUnreadCompanyNotify(Long id);

	@Modifying
	@Query(value = "delete from notify where job_id = ?1", nativeQuery = true)
	void deleteNotifyByJob(Long id);
}
