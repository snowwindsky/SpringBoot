package com.example.postgres.service;

import com.example.postgres.dao.StudentMapper;
import com.example.postgres.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuService {
    @Autowired
    StudentMapper studentMapper;
    public Student queryStudentInfo(Integer id){
        return studentMapper.queryStudentInfo(id);
    }
}
