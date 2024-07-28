package com.thuong.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseDto {
    private short id;

    private String name;

    public CourseDto(short id, String name) {
        this.id = id;
        this.name = name;
    }
}
