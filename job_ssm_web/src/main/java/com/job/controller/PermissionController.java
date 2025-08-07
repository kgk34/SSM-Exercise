package com.job.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.job.pojo.Permission;
import com.job.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("permission")
@Controller
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @RequestMapping("findAll.do")
    public String findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                          @RequestParam(value = "size", defaultValue = "4") Integer size,
                          Model model) {
        PageHelper.startPage(page, size);
        List<Permission> permissionList = permissionService.findAll();
        PageInfo<Permission> pageInfo = new PageInfo<>(permissionList);
        model.addAttribute("pageInfo", pageInfo);
        return "permission-list";
    }

    @RequestMapping("save.do")
    public String save(Permission permission) {
        permissionService.save(permission);
        return "redirect:findAll.do";
    }
}
