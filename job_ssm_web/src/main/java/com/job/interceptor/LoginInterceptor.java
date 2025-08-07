package com.job.interceptor;

import com.job.pojo.UserInfo;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        UserInfo user = (UserInfo) session.getAttribute("user");
        if (StringUtils.isEmpty(user)) {
            response.sendRedirect("/login.jsp");
            return false;
        }
        return true;
    }
}
