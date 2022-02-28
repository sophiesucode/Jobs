package com.jobs.jobs.repository;

import com.jobs.jobs.model.Employer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployerRepository extends JpaRepository<Employer,Long> {
Employer findEmployerByName(String name);


}
