package com.job.service;

import com.job.pojo.Role;
import com.job.pojo.UserInfo;

import java.util.List;

public interface UsersService {

    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(Integer id);

    List<Role> findUserByIdAndAllRole(Integer id);

    void addRoleToUser(Integer userId, Integer[] ids);

    UserInfo findUser(String username, String password);
}
