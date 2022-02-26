package com.jobs.jobs.service;

import com.jobs.jobs.repository.CategoryRepository;
import com.jobs.jobs.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerService {
    private EmployerRepository employerRepository;

    @Autowired
    public void setEmployerRepository(EmployerRepository employerRepository){
        this.employerRepository = employerRepository;
    }

    
}
