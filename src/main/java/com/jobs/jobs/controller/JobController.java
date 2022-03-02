package com.jobs.jobs.controller;




import com.jobs.jobs.model.Job;

import com.jobs.jobs.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class JobController {

    private JobService jobService;

    @Autowired
    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }


    @GetMapping(path = "/jobs/")
    public List<Job> getJobs() {
        System.out.println("calling getJobs ==>");
        return jobService.getAllJobs();
    }

    @GetMapping("/jobs/{jobId}")
    public Optional getJobs(@PathVariable Long jobId){
        System.out.println(("calling getJobs ==>"));
        return jobService.getJob(jobId);
    }


    @PostMapping("/jobs/")
    public Job createJob(@RequestBody Job jobObject) {
        System.out.println("calling createJob ==> ");
        return jobService.createJob(jobObject);

    }

    @PutMapping("/jobs/{jobId}")
    public Job updateJob(@PathVariable(value = "jobId") Long jobId, @RequestBody Job jobObject) {
        System.out.println("calling updateJob ==>");
        return jobService.updateJob(jobId, jobObject);
    }

    @DeleteMapping("/jobs/{jobId}")
    public Optional<Job> deleteJob(@PathVariable(value = "jobId") Long jobId) {
        System.out.println("calling deleteJob ==>");
        return jobService.deleteJob(jobId);
    }

    //post a job

}

//how to make this endpoint---> jobs?experience_level=junior (filtering) or jobs location=remote;
//jobs ? category=software-engineering for search filtering
//post job by filling out form, job from form appears on jobs list