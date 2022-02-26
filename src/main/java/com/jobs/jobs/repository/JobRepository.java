package com.jobs.jobs.repository;

import com.jobs.jobs.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    Job findByJob_title(String name);

    Job getById(Long jobId);


    Job findByLocation(String location);
}



