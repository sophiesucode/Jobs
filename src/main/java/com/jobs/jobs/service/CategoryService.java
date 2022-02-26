package com.jobs.jobs.service;

import com.jobs.jobs.repository.CategoryRepository;
import com.jobs.jobs.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }


    private JobRepository jobRepository;

    @Autowired
    public void setJobRepository(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }
}
