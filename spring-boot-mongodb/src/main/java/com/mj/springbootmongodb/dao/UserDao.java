package com.mj.springbootmongodb.dao;

import com.mj.springbootmongodb.entity.UserEntity;

public interface UserDao {
    public void saveUser(UserEntity user);

    public UserEntity findUserByUserName(String userName);

    public void updateUser(UserEntity user);

    public void deleteUserById(Long id);
}
