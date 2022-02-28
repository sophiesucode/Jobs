package com.jobs.jobs.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employers")
public class Employer {

        @Id
        @Column
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        private String name;

    @OneToMany(mappedBy = "employer", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Job> jobList;

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;

    }
        public Employer() {

        }

        public Employer(Long id, String name) {
            this.id = id;
            this.name = name;
        }


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }



        @Override
        public String toString() {
            return "Employer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

