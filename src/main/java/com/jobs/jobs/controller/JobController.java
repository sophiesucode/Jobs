package com.jobs.jobs.controller;



import com.jobs.jobs.model.Job;
import com.jobs.jobs.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
public class JobController {

    private JobRepository jobRepository;

    @Autowired
    public void setJobRepository(JobRepository JobRepository){
        this.jobRepository = jobRepository;
    }

}