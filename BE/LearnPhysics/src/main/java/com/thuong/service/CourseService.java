package com.thuong.service;

import com.thuong.entity.Course;
import com.thuong.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {
    @Autowired
    private ICourseRepository courseRepository;
    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
