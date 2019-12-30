package com.sdz.flower.web.filter;

import com.sdz.flower.pojo.Admin;
import com.sdz.flower.pojo.Student;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 过滤未登录学生  过滤路径 /index/student
 * @author xiao zhu
 */
@WebFilter(filterName = "LoginFilter",urlPatterns = {"/admin/*","/cart/*","/order/*"})
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        Student student = (Student)request.getSession().getAttribute("student");

        Admin admin = (Admin)request.getSession().getAttribute("admin");
        if (student!=null ||admin !=null){
            chain.doFilter(request,response);
        }
        String requestURI = request.getRequestURI();
        request.setAttribute("url",requestURI);
        request.getRequestDispatcher("/views/login.jsp").forward(request,response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
