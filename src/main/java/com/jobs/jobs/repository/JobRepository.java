package com.jobs.jobs.repository;

import com.jobs.jobs.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

    Job findByJob_title(String name);


}



//    Properties findByCity(String city);
//
//    Properties findByStreet(String street);
//
//    Properties getPropertiesByIdAndAgent_Id(Long propertiesId , Long agentId);
//
//    Properties getPropertiesByRealEstateOfficeId(Long officeId);
//
//    Properties getPropertiesById(Long propertiesId);
//
//    Properties findByNeighborhood(String neighborhood);