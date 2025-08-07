package com.job.service;

import com.job.pojo.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll();

    void save(Permission permission);
}
