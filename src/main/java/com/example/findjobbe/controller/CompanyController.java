package com.example.findjobbe.controller;


import com.example.findjobbe.model.Category;
import com.example.findjobbe.model.Company;
import com.example.findjobbe.model.CompanyWithCategories;
import com.example.findjobbe.model.Role;
import com.example.findjobbe.service.ICategoryService;
import com.example.findjobbe.service.ICompanyService;
import com.example.findjobbe.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@CrossOrigin("*")
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;
    @Autowired
    private ICategoryService categoryService;

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

    @GetMapping("/quantity-desc")
    public ResponseEntity<List<Company>> findTopCompanies() {
        return new ResponseEntity<>(companyService.findTopCompaniesWithHighRecruitmentDemand(),HttpStatus.OK);
    }

    @GetMapping("/count/{id}")
    public ResponseEntity<Long> countAllJobsByCompanyId(@PathVariable Long id) {
        Long count = companyService.countAllJobsByCompanyId(id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/with_categories/{id}")
    public ResponseEntity<CompanyWithCategories> findCompanyWithCategories(@PathVariable Long id) {
        CompanyWithCategories companyWithCategories = new CompanyWithCategories();
        Company company = companyService.findOne(id).get();
        List<Category> categories = categoryService.findCategoriesByCompanyId(id);
        companyWithCategories.setCompany(company);
        companyWithCategories.setCategories(categories);
        return new ResponseEntity<>(companyWithCategories, HttpStatus.OK);
    }

}
