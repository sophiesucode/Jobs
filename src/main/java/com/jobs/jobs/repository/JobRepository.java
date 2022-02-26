package com.jobs.jobs.repository;

import com.jobs.jobs.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
