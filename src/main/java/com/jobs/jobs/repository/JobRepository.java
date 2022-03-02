package com.jobs.jobs.repository;

import com.jobs.jobs.model.Employer;
import com.jobs.jobs.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    Job findJobByTitle(String title);

List<Job> findAllByCategory_Id(Long categoryId);

}



