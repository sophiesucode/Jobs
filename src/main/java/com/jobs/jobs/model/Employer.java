package com.jobs.jobs.model;

import javax.persistence.Entity;


public class Employer {

        private Long id;

        private String company_name;


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

