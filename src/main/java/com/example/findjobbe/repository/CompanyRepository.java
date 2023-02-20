package com.example.findjobbe.repository;

import com.example.findjobbe.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query(value = "select *,sum(quantity) from company c join job j on c.id = j.company_id " +
            "group by c.id order by sum(quantity) desc",nativeQuery = true)
    List<Company> findTopCompaniesWithHighRecruitmentDemand();

    @Query(value = "select count(j) from Job j join Company c on j.company.id = c.id where j.company.id = ?1")
    Long countAllJobsByCompanyId(Long id);
}
