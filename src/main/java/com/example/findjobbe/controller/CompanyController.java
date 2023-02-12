package com.example.findjobbe.controller;


import com.example.findjobbe.model.Company;
import com.example.findjobbe.model.Role;
import com.example.findjobbe.service.ICompanyService;
import com.example.findjobbe.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    @Autowired
    private IRoleService roleService;

    @GetMapping
    public ResponseEntity<Iterable<Company>> findAllCompany() {
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/role")
    public ResponseEntity<Iterable<Role>> findAllRole() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Company>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(companyService.findOne(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Company> create(@RequestBody Company company) {
        return new ResponseEntity<>(companyService.save(company), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> update(@RequestBody Company company,
                                          @PathVariable Long id) {
        Optional<Company> companyUpdated = companyService.findOne(id);
        if (companyUpdated.isPresent()) {
            return new ResponseEntity<>(companyService.save(company), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        companyService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
