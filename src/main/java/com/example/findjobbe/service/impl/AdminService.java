package com.example.findjobbe.service.impl;

import com.example.findjobbe.model.Admin;
import com.example.findjobbe.repository.AdminRepository;
import com.example.findjobbe.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> findOne(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Admin save(Admin admin) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
