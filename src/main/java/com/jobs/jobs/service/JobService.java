package com.jobs.jobs.service;

import com.jobs.jobs.exceptions.InformationNotFoundException;

import com.jobs.jobs.model.Job;
import com.jobs.jobs.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private JobRepository jobRepository;

    @Autowired
    public void setJobRepository(JobRepository JobRepository){
        this.jobRepository = jobRepository;
    }


    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }
//
    public Job createJob(Job jobObject){

        Job job = jobRepository.findByLocation(jobObject.getLocation());


        return jobRepository.save(jobObject);
    }


    public Optional<Job> getJob(Long jobId) {

        Optional<Job> job = jobRepository.findById(jobId);
        if(job.isPresent()){
            return job;
        }else{
            throw new InformationNotFoundException("job with Id " + jobId + " not found");
        }
    }

    public Job updateJob(Long jobId, Job jobObject){

        Optional<Job> job = jobRepository.findById(jobId);
        if(job.isPresent()){
            Job updateJob = jobRepository.findById(jobId).get();
            updateJob.setJob_title(jobObject.getJob_title());
            updateJob.setExperience_level(jobObject.getExperience_level());
            updateJob.setJob_description(jobObject.getJob_description());
            updateJob.setLocation(jobObject.getLocation());
            updateJob.setId(jobObject.getId());
            return jobRepository.save(updateJob);

        }else{
            throw new InformationNotFoundException("job with id " + jobId + " not found");
        }
    }

    //delete job





    //look up all jobs , return all jobs
    public Iterable<Job> lookup(){
        return jobRepository.findAll();
    }

    public long total(){
        return jobRepository.count();
    }
}
