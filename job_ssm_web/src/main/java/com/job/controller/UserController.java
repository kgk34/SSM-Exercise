package com.job.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.job.pojo.Role;
import com.job.pojo.UserInfo;
import com.job.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UsersService usersService;

    @RequestMapping("findAll.do")
    public String findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "4") Integer size,
                          Model model) {
        PageHelper.startPage(page, size);
        List<UserInfo> userList = usersService.findAll();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userList);
        model.addAttribute("pageInfo", pageInfo);
        return "user-list";
    }

    @RequestMapping("save.do")
    public String save(UserInfo userInfo) {
        usersService.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("findById.do")
    public String findById(@RequestParam(name = "id") Integer id, Model model) {
        UserInfo userInfo = usersService.findById(id);
        model.addAttribute("user", userInfo);
        return "user-show";
    }

    @RequestMapping("findUserByIdAndAllRole.do")
    public String findUserByIdAndAllRole(@RequestParam("id") Integer id, Model model) {
        List<Role> roleList = usersService.findUserByIdAndAllRole(id);
        model.addAttribute("userId", id);
        model.addAttribute("roleList", roleList);
        return "user-role-add";
    }

    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(@RequestParam("userId") Integer userId, Integer[] ids) {
        usersService.addRoleToUser(userId, ids);
        return "redirect:findAll.do";
    }
}
