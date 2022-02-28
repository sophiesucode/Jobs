package com.jobs.jobs.service;

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




    public Employer createEmployer(Employer employerObject) {

        Employer employer = employerRepository.findEmployerByName(employerObject.getName());

            return employerRepository.save(employerObject);
        }


    public Optional<Employer> getEmployer(Long companyId){

        Optional<Employer> employer = employerRepository.findById(companyId);
        if(employer.isPresent()){
            return employer;
        } else{
            throw new InformationNotFoundException("employer with Id " + companyId + " not found");
        }

    }

    public Optional<Employer> deleteEmployer(Long companyId){

        Optional<Employer> employer = employerRepository.findById(companyId);
        if(employer.isPresent()){
            employerRepository.deleteById(companyId);
            return employer;

        }else {
            throw new InformationNotFoundException("employer with id " + companyId +" not found");
        }
    }
}
