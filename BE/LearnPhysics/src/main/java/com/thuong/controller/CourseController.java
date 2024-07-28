package com.thuong.controller;

import com.thuong.dto.CourseDto;
import com.thuong.entity.Course;
import com.thuong.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/courses")
@CrossOrigin("*")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @GetMapping()
    public ResponseEntity<?> getAllCourses() {
        List<Course> entities = courseService.getAllCourses();

        List<CourseDto> dtos = new ArrayList<>();

        // convert entities --> dtos
        for (Course entity : entities) {
            CourseDto dto = new CourseDto(entity.getId(), entity.getName());
            dtos.add(dto);
        }

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
