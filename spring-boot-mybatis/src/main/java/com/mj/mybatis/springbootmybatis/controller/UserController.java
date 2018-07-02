package com.mj.mybatis.springbootmybatis.controller;

import com.mj.mybatis.springbootmybatis.entity.UserEntity;
import com.mj.mybatis.springbootmybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    public List<UserEntity> getUsers() {
        List<UserEntity> userEntities = userMapper.getAll();
        return userEntities;
    }

    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
        UserEntity userEntity = userMapper.getOne(id);
        return userEntity;
    }

    @RequestMapping("/add")
    public void save(@RequestBody UserEntity userEntity) {
        userMapper.insert(userEntity);
    }

    @RequestMapping(value = "update")
    public void update(UserEntity userEntity) {
        userMapper.update(userEntity);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }
}
