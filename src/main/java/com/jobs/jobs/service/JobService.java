package com.jobs.jobs.service;

import com.jobs.jobs.exceptions.InformationNotFoundException;

import com.jobs.jobs.model.Job;
import com.jobs.jobs.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class
JobService {
    private JobRepository jobRepository;
    @Autowired
    public void setJobRepository(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }

//    public Job createJob(Job jobObject){
//
//        Optional<Job> job = jobRepository.findById(jobObject.getId());
//        return jobRepository.save(jobObject);
//    }
public Job createJob(Job jobObject) {

    Job job = jobRepository.findJobByTitle(jobObject.getTitle());

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
            updateJob.setTitle(jobObject.getTitle());
            updateJob.setSalary(jobObject.getSalary());
            updateJob.setExperience_level(jobObject.getExperience_level());
            updateJob.setJob_description(jobObject.getJob_description());
            updateJob.setCompany(jobObject.getCompany());
            updateJob.setLocation(jobObject.getLocation());


            return jobRepository.save(updateJob);

        }else{
            throw new InformationNotFoundException("job with id " + jobId + " not found");
        }
    }


    public Optional<Job> deleteJob(Long jobId){

        Optional<Job> job = jobRepository.findById(jobId);
        if(job.isPresent()){
            jobRepository.deleteById(jobId);
            return job;

        }else{
            throw new InformationNotFoundException("Job with id " + jobId +" not found");
        }
    }

    ////new methods

    public void save(Job job) {
        jobRepository.save(job);
    }

    public Job get(long jobId) {
        return jobRepository.findById(jobId).get();
    }

    public List<Job> getJobByCategory(Long categoryId){
        return jobRepository.findAllByCategory_Id(categoryId);
    }

    public void delete(long jobId) {
        jobRepository.deleteById(jobId);
    }

    public List<Job> listAll() {
        return jobRepository.findAll();
    }
    //look up all jobs , return all jobs
//    public Iterable<Job> lookup(){
//        return jobRepository.findAll();
//    }
//
    public long total(){
        return jobRepository.count();
    }
}
