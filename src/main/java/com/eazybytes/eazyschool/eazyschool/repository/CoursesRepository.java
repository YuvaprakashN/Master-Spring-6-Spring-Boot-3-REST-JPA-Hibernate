package com.eazybytes.eazyschool.eazyschool.repository;

import com.eazybytes.eazyschool.eazyschool.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses,Integer> {
}
