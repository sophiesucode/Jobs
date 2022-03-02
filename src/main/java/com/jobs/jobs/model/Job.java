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
   private String salary;

   @Column
    private String job_description;

   @Column
   private String company;

    @Column
    private String location;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    @Column
    private String url;

     @Column
     private String img_url;



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

    public Job(Long id, String title, String experience_level, String salary, String job_description, String company, String location) {
        this.id = id;
        this.title = title;
        this.experience_level = experience_level;
        this.salary = salary;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", experience_level='" + experience_level + '\'' +
                ", title='" + title + '\'' +
                ", salary='" + salary + '\'' +
                ", job_description='" + job_description + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", url='" + url + '\'' +
                ", img_url='" + img_url + '\'' +
                ", employer=" + employer +
                ", category=" + category +
                '}';
    }
}
