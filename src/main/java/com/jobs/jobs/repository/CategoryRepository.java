package com.jobs.jobs.repository;

import com.jobs.jobs.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
