package com.thuong.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Column(name = "CourseID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "CourseName", length = 30, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private List<Account> accounts;


}
