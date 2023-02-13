package com.example.findjobbe.service.impl;

import com.example.findjobbe.model.Company;
import com.example.findjobbe.repository.CompanyRepository;
import com.example.findjobbe.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> findOne(Long aLong) {
        return companyRepository.findById(aLong);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void delete(Long aLong) {
        companyRepository.deleteById(aLong);
    }

    @Override
    public List<Company> findTopCompaniesWithHighRecruitmentDemand() {
        return companyRepository.findTopCompaniesWithHighRecruitmentDemand();
    }

    @Override
    public Long countAllJobsByCompanyId(Long id) {
        return companyRepository.countAllJobsByCompanyId(id);
    }
}
