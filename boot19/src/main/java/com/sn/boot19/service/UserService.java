package com.sn.boot19.service;

import com.sn.boot19.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public int addUser(User user){
        return jdbcTemplate.update("INSERT INTO user(name,address) values(?,?)",user.getName(),user.getAddress());
    }
    public int deleteUserById(Integer id){
        return jdbcTemplate.update("DELETE FROM user where id=?",id);
    }
    public int updateUserById(User user){
        return jdbcTemplate.update("UPDATE user set name=?,address=? WHERE id=?",user.getName(),user.getAddress(),user.getId());
    }
    public List<User> findUserAll(){
        return jdbcTemplate.query("SELECT * FROM user",new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException{
                String name=resultSet.getString("name");
                String address=resultSet.getString("address");
                Integer id=resultSet.getInt("id");
                User user=new User();
                user.setId(id);
                user.setAddress(address);
                user.setName(name);
                return user;
            }
        });
    }
    public List<User> findUserById(Integer id){
        return jdbcTemplate.query("SELECT * FROM user WHERE id=?",new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException{
                String name=resultSet.getString("name");
                String address=resultSet.getString("address");
                Integer id=resultSet.getInt("id");
                User user=new User();
                user.setId(id);
                user.setAddress(address);
                user.setName(name);
                return user;
            }
        },id);
    }
}
