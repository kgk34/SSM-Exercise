package com.job.service;

import com.job.pojo.Permission;
import com.job.pojo.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    void save(Role role);

    List<Permission> findRoleByIdAndPermission(Integer id);

    void addPermissionToRole(Integer roleId, Integer[] ids);

}
