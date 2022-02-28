package com.jobs.jobs.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="jobs")
public class Job {


   @Id
   @Column
   @GeneratedValue
    private Long id;

   @Column
    private String experience_level;

   @Column
    private String title;

   @Column
    private String job_description;

   @Column
   private String company;

    @Column
    private String location;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Employer employer;



    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Job() {

    }

    public Job(Long id, String title, String experience_level, String job_description, String company, String location) {
        this.id = id;
        this.title = title;
        this.experience_level = experience_level;
        this.job_description = job_description;
        this.company = company;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExperience_level() {
        return experience_level;
    }

    public void setExperience_level(String experience_level) {
        this.experience_level = experience_level;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String job_title) {
        this.title = job_title;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", experience_level='" + experience_level + '\'' +
                ", job_title='" + title + '\'' +
                ", job_description='" + job_description + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", employer=" + employer +
                ", category=" + category +
                '}';
    }
}
