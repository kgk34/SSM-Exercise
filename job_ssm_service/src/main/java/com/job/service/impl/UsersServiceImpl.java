package com.job.service.impl;

import com.job.dao.UsersDao;
import com.job.pojo.Role;
import com.job.pojo.UserInfo;
import com.job.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersDao usersDao;

    @Override
    public List<UserInfo> findAll() {
        return usersDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        usersDao.save(userInfo);
    }

    @Override
    public UserInfo findById(Integer id) {
        return usersDao.findById(id);
    }

    @Override
    public List<Role> findUserByIdAndAllRole(Integer id) {
        return usersDao.findUserByIdAndAllRole(id);
    }

    @Override
    public void addRoleToUser(Integer userId, Integer[] ids) {
        for(Integer id: ids) {
            usersDao.addRoleToUser(userId, id);
        }
    }

    @Override
    public UserInfo findUser(String username, String password) {
        return usersDao.findUser(username, password);
    }
}
