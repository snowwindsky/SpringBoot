package com.example.postgres.controller;


import com.example.postgres.config.DBContextHolder;
import com.example.postgres.entity.Student;
import com.example.postgres.service.DataSourceService;
import com.example.postgres.service.StuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataController {

    private static Logger logger= LoggerFactory.getLogger(DataController.class);
    @Autowired
    StuService studentService;

    @Autowired
    DataSourceService dataSourceService;

    @ResponseBody
    @GetMapping("/findStudent")
    public  String test(@RequestParam("id")Integer id) throws Exception {
        dataSourceService.changeDB("testdb1");
        Student student = studentService.queryStudentInfo(id);
        DBContextHolder.clearDataSource();
        if(student!=null){
            return student.toString();
        }
        else {
            return "该学生不存在";
        }
    }

}
