package com.jobs.jobs.repository;

import com.jobs.jobs.model.Employer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer,Long> {

}
