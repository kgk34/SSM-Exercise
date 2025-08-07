package com.job.dao;

import com.job.pojo.Permission;
import com.job.pojo.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {

    @Results(value = {
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(column = "id", property = "permissions",
                    many = @Many(select = "com.job.dao.PermissionDao.findById")),
    })
    @Select("select * from role where id in(select roleId from users_role where userId=#{userId})")
    List<Role> findByRoleId(Integer userId);

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from permission where id not in(select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findRoleByIdAndPermission(Integer roleId);

    @Insert("insert into role_permission(permissionId, roleId) values(#{permissionId}, #{roleId})")
    void addPermissionToRole(@Param("roleId") Integer roleId, @Param("permissionId") Integer permissionId);
}
