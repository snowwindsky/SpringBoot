package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.Impl.StudentServiceImpl;
import com.example.demo.service.StuServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
   @Autowired
    public StudentServiceImpl studentService;

   @Autowired
   public StuServie stuServie;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @ResponseBody
    @GetMapping("find")
    public String getStudent(@RequestParam("id") String id){
        Student student=studentService.find(id);
        return "该同学是 "+student.getName()+",性别为"+student.getSex();
    }
    @ResponseBody
    @PostMapping("save")
    public String insert(Student student){
        studentService.insert(student);
        return "新增成功";
    }
    @ResponseBody
    @GetMapping("/mapper/student")
    public Student getMapperStudent(@RequestParam("id")String id){
        Student student=stuServie.findById(id);
        return student;
    }

    @ResponseBody
    @PutMapping("/update")
    public String UpdateStudentName(@RequestParam("name")String name,@RequestParam("id")String id){
        System.out.println(stuServie.updateName(name,id));
        return "success";
    }
}
