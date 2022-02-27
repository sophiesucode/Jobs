package com.jobs.jobs.service;

import com.jobs.jobs.exceptions.InformationExistException;
import com.jobs.jobs.exceptions.InformationNotFoundException;

import com.jobs.jobs.model.Employer;

import com.jobs.jobs.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerService {
    private EmployerRepository employerRepository;

    @Autowired
    public void setEmployerRepository(EmployerRepository employerRepository){
        this.employerRepository = employerRepository;
    }

    public List<Employer> getAllEmployers(){
        return employerRepository.findAll();
    }


    public Employer createEmployer(Employer employerObject){

        Optional<Employer> employer = employerRepository.findById(employerObject.getId());
        if(employer != null){
            throw new InformationExistException("Company" + employer.get().getId() + " already exists");
        } else{
            return employerRepository.save(employerObject);
        }
    }

    public Optional<Employer> getEmployer(Long employerId){

        Optional<Employer> employer = employerRepository.findById(employerId);
        if(employer.isPresent()){
            return employer;
        } else{
            throw new InformationNotFoundException("employer with Id " + employerId + " not found");
        }

    }

    public Optional<Employer> deleteEmployer(Long employerId){

        Optional<Employer> employer = employerRepository.findById(employerId);
        if(employer.isPresent()){
            employerRepository.deleteById(employerId);
            return employer;

        }else {
            throw new InformationNotFoundException("employer with id " + employerId +" not found");
        }
    }
}
