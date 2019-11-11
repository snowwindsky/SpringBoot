package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentMapper {
    public Student findById(String id);

    @Update("UPDATE student SET name=#{name} where id=#{id}")
    public boolean updateNameById(@Param("name")String name,@Param("id")String id);
}
