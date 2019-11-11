package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teacher {
    @Id
    public Integer id;
    @Column
    public String name;
    @Column
    public Integer age;
    @OneToMany
    @JoinTable(name="teacher_to_student",
            joinColumns = {@JoinColumn(name="teacher_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="student_id",referencedColumnName = "id")})
    public List<Student> students;
}
