package com.sdz.flower.web.controller;

import com.sdz.flower.bean.BaseResult;
import com.sdz.flower.pojo.Student;
import com.sdz.flower.service.StudentService;
import com.sdz.flower.service.impl.StudentServiceImpl;
import org.omg.PortableInterceptor.INACTIVE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author  xio zhu  zhu
 */
@WebServlet(name = "AdminServlet",urlPatterns = "/admin/info")
public class AdminServlet extends HttpServlet {

    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch(action){
            case "add":addStudent(request,response);
            break;
            case "edit":editStudentForm(request,response);
            break;
            default: response.getWriter().write("请求未处理");
                break;
        }
    }

    private void editStudentForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前端数据
        String password = request.getParameter("password");
        String sid = request.getParameter("sid");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        Student student = new Student();
        student.setPhone(phone);
        student.setAddress(address);
        student.setUsername(username);
        student.setPassword(password);
        student.setEmail(email);
        student.setUpdated(new Date());
        student.setSid(Integer.parseInt(sid));

        Integer integer = studentService.updateStudent(student);
        BaseResult baseResult = null;
        if (integer>0){
            baseResult= BaseResult.success("修改成功");
            request.setAttribute("baseResult",baseResult);
            request.getRequestDispatcher("/page/info?action=student_list").forward(request,response);
        }else {
            baseResult=BaseResult.fail("修改失败");
            request.setAttribute("baseResult",baseResult);
            request.getRequestDispatcher("/page/info?action=student_form").forward(request,response);

        }

    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前端数据
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        Student student = new Student();
        student.setPhone(phone);
        student.setAddress(address);
        student.setUsername(username);
        student.setPassword(password);
        student.setEmail(email);
        student.setUpdated(new Date());

        Integer i = studentService.register(student);
        BaseResult baseResult = null;
        if (i>0){
            baseResult = BaseResult.success("添加成功");
            request.setAttribute("baseResult",baseResult);
            request.getRequestDispatcher("/page/info?action=student_list").forward(request,response);
        }else {
            baseResult = BaseResult.fail("添加失败");
            request.setAttribute("baseResult",baseResult);
            request.getRequestDispatcher("/page/info?action=student_form").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "edit": editStudent(request,response);
        }
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student sid = studentService.selectStudentById(Integer.parseInt(request.getParameter("sid")));
        if (sid != null){
            request.setAttribute("student",sid);
            request.getRequestDispatcher("/page/info?action=student_form").forward(request,response);
        }
    }
}
