package com.ncepu.bigdata.mapper;


import com.ncepu.bigdata.entity.SysUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper  //使用注解完成SQL语句
@Repository  //将当前的mapper添加到容器当中并且是持久层的功能
public interface TuserMapper {

    @Select("select * from t_user where username = #{uname} and password = #{pwd}")//selece可以识别查询语句
    public SysUser login(@Param("uname") String uname, @Param("pwd") String pwd);//param:将参数改为mybatis可识别的参数

    @Select("select * from t_user")
    @Results({
            @Result(column="uid",property="uid"),
            @Result(column="username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column="rid",property = "role",one=@One(select = "com.ncepu.bigdata.mapper.TuserMapper.byId"))
    })
    List<SysUser> getAll();

    @Select("select * from t_user where username = #{uname}")
    @Results({
            @Result(column="uid",property = "uid"),
            @Result(column="username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column="rid",property = "role",one=@One(select = "com.ncepu.bigdata.mapper.TuserMapper.byId"))
    })
    List<SysUser> getUser(@Param("uname") String uname);
//
//    @Select("select * from t_role")
////    @Results({
////            @Result(column="rid",property="rid"),
////            @Result(column="rname",property = "rname"),
////            @Result(column = "rdesc",property = "rdesc")
////    })
//    List<Role> getRoles();
//
//    @Select("select * from t_role where rname= #{rname}")
//    @Results({
//            @Result(column="rid",property="rid"),
//            @Result(column="rname",property = "rname"),
//            @Result(column = "rdesc",property = "rdesc")
//    })
//    List<Role> getRoleByName(@Param("rname") String rname);

    @Select("select * from t_user where uid = #{uid}")
    @Results({
            @Result(column="uid",property = "uid"),
            @Result(column="username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column="rid",property = "role",
                    one=@One(select = "com.ncepu.bigdata.mapper.TuserMapper.byId"))
    })
    SysUser getOne(@Param("uid") int uid);


//    @Results({
//            @Result(column="dateId",property="dateId"),
//            @Result(column="username",property = "username"),
//            @Result(column = "password",property = "password"),
//            @Result(column="rid",property = "role",one=@One(select = "com.ncepu.bigdata.mapper.TuserMapper.byId"))
//    })

    @Update("update t_user set username=#{username} ,password = #{password} ,rid=#{role.rid} where uid = #{uid}")
    void update(SysUser sysUser);

    @Insert("insert into t_user(username,password,rid)"+
        "values(#{username},#{password},#{role.rid})")
    void insertUser(SysUser sysUser);

    @Delete("delete from t_user where uid = #{uid}")
    void dele(@Param("uid") int uid);

    @Delete("<script> delete from t_user where uid in <foreach collection= \"ids\" open=\"(\" close=\")\" separator=\",\"  item=\"i\" >  #{i}   </foreach> </script>")
    void deleSome(@Param("ids") String[] uids );

}
