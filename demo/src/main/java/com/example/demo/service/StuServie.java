package com.example.demo.service;

import com.example.demo.dao.StudentMapper;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuServie {
    @Autowired
    StudentMapper studentMapper;
    public Student findById(String id){
        return studentMapper.findById(id);
    }
    public boolean updateName(String name,String id){
        return  studentMapper.updateNameById(name,id);
    }
}
