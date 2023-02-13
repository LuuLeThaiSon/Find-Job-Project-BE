package com.example.findjobbe.service;

import com.example.findjobbe.model.Company;

import java.util.List;

public interface ICompanyService extends ICoreCrud<Company,Long> {
    List<Company> findTopCompaniesWithHighRecruitmentDemand();

    Long countAllJobsByCompanyId(Long id);
}
