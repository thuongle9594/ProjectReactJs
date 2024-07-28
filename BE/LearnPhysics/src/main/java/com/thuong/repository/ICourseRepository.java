package com.thuong.repository;

import com.thuong.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Short> {
public Course findByName (String name);
public boolean existsByName(String name);
}
