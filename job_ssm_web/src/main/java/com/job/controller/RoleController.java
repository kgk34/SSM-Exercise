package com.job.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.job.pojo.Permission;
import com.job.pojo.Role;
import com.job.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("role")
@Controller
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("findAll.do")
    public String findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "4") Integer size,
                          Model model) {
        PageHelper.startPage(page, size);
        List<Role> roleList = roleService.findAll();
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        model.addAttribute("pageInfo", pageInfo);
        return "role-list";
    }

    @RequestMapping("save.do")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("findRoleByIdAndPermission.do")
    public String findRoleByIdAndPermission(@RequestParam("id") Integer id, Model model) {
        List<Permission> permissionList = roleService.findRoleByIdAndPermission(id);
        model.addAttribute("roleId", id);
        model.addAttribute("permissionList", permissionList);
        return "role-permission-add";
    }

    @RequestMapping("addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam("roleId") Integer roleId, @RequestParam("ids") Integer[] ids) {
        roleService.addPermissionToRole(roleId, ids);
        return "redirect:findAll.do";
    }
}
