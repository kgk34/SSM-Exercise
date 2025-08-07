package com.job.service.impl;

import com.job.dao.RoleDao;
import com.job.pojo.Permission;
import com.job.pojo.Role;
import com.job.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Permission> findRoleByIdAndPermission(Integer id) {
        return roleDao.findRoleByIdAndPermission(id);
    }

    @Override
    public void addPermissionToRole(Integer roleId, Integer[] ids) {
        for(Integer permissionId: ids){
            roleDao.addPermissionToRole(roleId, permissionId);
        }
    }
}
