package com.example.demo.service.Impl;

import com.example.demo.dao.StudentRepository;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    public StudentRepository studentRepository;
    @Override
    public Student find(String id){
        Optional<Student> optional=studentRepository.findById(id);
        Student student=optional.get();
        return  student;
    }

    @Override
    public void insert(Student student){
        studentRepository.save(student);
    }

    @Override
    public void delete(String id){
        studentRepository.deleteById(id);
    }
}
