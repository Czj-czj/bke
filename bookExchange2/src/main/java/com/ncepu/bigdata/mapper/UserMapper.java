package com.ncepu.bigdata.mapper;


import com.ncepu.bigdata.entity.SysUser;
import com.ncepu.bigdata.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper  //使用注解完成SQL语句
@Repository  //将当前的mapper添加到容器当中并且是持久层的功能
public interface UserMapper {

    @Select("select * from user where username = #{id} and password = #{pwd}")//selece可以识别查询语句
    public User login(@Param("id") String id, @Param("pwd") String pwd);//param:将参数改为mybatis可识别的参数
    @Update("update user set username=#{username} ,password = #{password} ,rid=#{role.rid} where uid = #{uid}")
    void update(User user);
    @Insert("insert into user(username,password,email)"+
            "values(#{username},#{password},#{email})")
    void insertUser(User user);


}
