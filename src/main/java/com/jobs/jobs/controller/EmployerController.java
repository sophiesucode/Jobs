package com.jobs.jobs.controller;


import com.jobs.jobs.model.Employer;
import com.jobs.jobs.repository.EmployerRepository;
import com.jobs.jobs.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployerController {

    private EmployerService employerService;


    @Autowired
    public void setEmployerService(EmployerService employerService) {
        this.employerService = employerService;
    }

    public EmployerService getEmployerService() {
        return employerService;
    }


    @GetMapping(path = "/employers/")
    public List<Employer> getEmployer() {
        System.out.println("calling getEmployers ==>");
        return employerService.getAllEmployers();
    }

    @GetMapping("/employers/{companyId}")
    public Optional getEmployers(@PathVariable Long employerId){
        System.out.println(("calling getAgent ==>"));
        return employerService.getEmployer(employerId);
    }


    @PostMapping("/employers/")
    public Employer createEmployer(@RequestBody Employer employerObject) {
        System.out.println("calling createEmployer ==> ");
        return employerService.createEmployer(employerObject);

    }

    @DeleteMapping("/jobs/{companyId}")
    public Optional<Employer> deleteEmployer(@PathVariable(value = "companyId") Long companyId) {
        System.out.println("calling deleteEmployer ==>");
        return employerService.deleteEmployer(companyId);
    }
}
