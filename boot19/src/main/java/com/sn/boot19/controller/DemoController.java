package com.sn.boot19.controller;

import com.sn.boot19.pojo.User;
import com.sn.boot19.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {
    @Autowired
    UserService userService;


    @RequestMapping("add")
    public int addUser(User user){
        return userService.addUser(user);
    }
    @RequestMapping("update")
    public int UpdateUser(User user){
        return userService.updateUserById(user);
    }
    @RequestMapping("delete")
    public int deleteUser(Integer id){
        return userService.deleteUserById(id);
    }
    @RequestMapping("showAll")
    public List<User> showAll(){
        return userService.findUserAll();
    }
    @RequestMapping("findOne")
    public List<User> findOne(Integer id){
        return userService.findUserById(id);
    }
}
