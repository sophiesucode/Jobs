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
        private String company_name;



    @OneToMany(mappedBy = "Employer", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Job> jobList;

        public Employer() {

        }

        public Employer(Long id, String company_name) {
            this.id = id;
            this.company_name = company_name;
        }


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        @Override
        public String toString() {
            return "Employer{" +
                    "id=" + id +
                    ", company_name='" + company_name + '\'' +
                    '}';
        }
    }

