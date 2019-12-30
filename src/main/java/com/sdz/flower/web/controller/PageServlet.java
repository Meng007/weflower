package com.sdz.flower.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PageServlet",urlPatterns = "/page/info")
public class PageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "flower_form":request.getRequestDispatcher("/views/admin/flower_form.jsp").forward(request,response);
            break;
            case "flower_list":request.getRequestDispatcher("/views/admin/flower_list.jsp").forward(request,response);
                break;
            case "student_list":request.getRequestDispatcher("/views/admin/student_list.jsp").forward(request,response);
                break;
            case "student_form":request.getRequestDispatcher("/views/admin/student_form.jsp").forward(request,response);
                break;
            case "flower_one":request.getRequestDispatcher("/views/student/flower_one.jsp").forward(request,response);
            break;
            case "flower_cart":request.getRequestDispatcher("/views/student/flower_cart.jsp").forward(request,response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
