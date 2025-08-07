package com.job.dao;

import com.job.pojo.Role;
import com.job.pojo.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UsersDao {

    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users(email, username, password, phoneNum, status) values(#{email}, #{username}, #{password}, #{phoneNum}, #{status})")
    void save(UserInfo userInfo);

    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "id", property = "roles",
                    many = @Many(select = "com.job.dao.RoleDao.findByRoleId"))
    })
    @Select("select * from users where id=#{id}")
    UserInfo findById(Integer id);

    @Select("select * from role where id not in(select roleId from users_role where userId=#{userId})")
    List<Role> findUserByIdAndAllRole(Integer userId);

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") Integer userId, @Param("roleId") Integer id);

    @Select("select * from users where username=#{username} and password=#{password}")
    UserInfo findUser(@Param("username") String username, @Param("password") String password);
}
