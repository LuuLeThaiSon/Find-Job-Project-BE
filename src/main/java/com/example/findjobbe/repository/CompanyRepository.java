package com.example.findjobbe.repository;

import com.example.findjobbe.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query(value = "select *,sum(quantity) from company c join job j on c.id = j.company_id " +
            "group by c.name order by sum(quantity) desc",nativeQuery = true)
    List<Company> findTopCompaniesWithHighRecruitmentDemand();

}
