package com.mj.mybatis.springbootmybatis.mapper;

import com.mj.mybatis.springbootmybatis.entity.UserEntity;
import com.mj.mybatis.springbootmybatis.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<UserEntity> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    UserEntity getOne(Long id);

    @Insert("INSERT INTO users(userName,password,user_sex,nick_name) VALUES(#{userName},#{passWord},#{userSex},#{nickName})")
    void insert(UserEntity userEntity);

    @Update("UPDATE users SET userName=#{userName},nickName=#{nickName} WHERE id = #{id}")
    void update(UserEntity userEntity);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void delete(Long id);
}
