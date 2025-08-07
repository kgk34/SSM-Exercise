package com.job.controller;

import com.job.pojo.UserInfo;
import com.job.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    UsersService usersService;

    @RequestMapping("login.do")
    public String login(String username, String password, HttpServletRequest request) {
        UserInfo user = usersService.findUser(username, password);
        if(!StringUtils.isEmpty(user)){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "redirect:/index.jsp";
        }
        else {
            return "redirect:/login.jsp";
        }
    }
}
