package com.example.demo.service;

import com.example.demo.entity.Student;

public interface StudentService {
    public Student find(String id);
    public void insert(Student student);
    public void delete(String id);
}
