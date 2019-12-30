package com.sdz.flower.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author  zhu
 */
@WebServlet(name = "IndexServlet",urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "index": index(request,response);
                break;
            case "index2":index2(request,response);
            default:response.getWriter().write("请求未处理");
            break;
        }
    }

    /**
     *  管理员 首页
     * @param request
     * @param response
     */
    private void index2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getContextPath();
        request.getRequestDispatcher(path+"/views/admin/index.jsp").forward(request,response);

    }

    /**
     *  学生首页
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/student/index.jsp").forward(request,response);
    }
}
