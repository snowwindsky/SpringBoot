package com.example.postgres.dao;

import com.example.postgres.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {
    public Student queryStudentInfo(Integer id);
}
