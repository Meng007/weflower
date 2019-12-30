package com.sdz.flower.web.controller;

import com.sdz.flower.pojo.Admin;
import com.sdz.flower.pojo.Student;
import com.sdz.flower.service.AdminService;
import com.sdz.flower.service.StudentService;
import com.sdz.flower.service.impl.AdminServiceImpl;
import com.sdz.flower.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**  登录注册功能实现
 * @author zhu
 */
@WebServlet(name = "StudentServlet",urlPatterns = "/common/info")
public class CommonServlet extends HttpServlet {

    private StudentService service = new StudentServiceImpl();
    private AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch(action){
            case "add": addStudent(request,response);
            break;
            case "login":login(request,response);
            break;
            default: response.getWriter().write("请求找不到处理");
            break;
        }
    }



    /**
     *  登录操作
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String checked = request.getParameter("checked");
        switch(checked){
            case "student":studentLogin(request,response);
            break;
            case "admin":adminLogin(request,response);
            break;
            default:response.getWriter().write("请求未处理");
            break;
        }
    }

    /**
     *   管理员登录
     * @param request 请求
     * @param response 响应
     * @throws ServletException
     * @throws IOException
     */
    private void adminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Admin admin = adminService.selectAdminByName(username);
        if (admin!=null){
            if (admin.getPassword().equals(password)){
                request.getSession().setAttribute("admin",admin);
                response.sendRedirect("/index?action=index2");
            }else {
                request.setAttribute("msg","密码错误");
                request.getRequestDispatcher("/views/login.jsp").forward(request,response);
            }
        }else {
            request.setAttribute("msg","用户不存在！");
            request.getRequestDispatcher("/views/login.jsp").forward(request,response);
        }

    }

    /**
     *  学生登录
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void studentLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Student student = service.selectStudentByName(username);
        if (student!=null){
            if (student.getPassword().equals(password)){
                request.getSession().setAttribute("student",student);
                response.sendRedirect("/index?action=index");
            }else {
                request.setAttribute("msg","密码错误！");
                request.getRequestDispatcher("/views/login.jsp").forward(request,response);
            }
        }else {
            request.setAttribute("msg","用户不存在！");
            request.getRequestDispatcher("/views/login.jsp").forward(request,response);

        }
        Student student1 = (Student)request.getSession().getAttribute("student");
        System.out.println(student1);
    }

    /**
     *  学生注册操作
     * @param request
     * @param response
     */
    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前端数据
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");

        // 判断用户名是否存在
        Student name = service.selectStudentByName(username);
        if(name !=null){
            request.setAttribute("msg","用户名已经存在");
            request.getRequestDispatcher("/views/student/register.jsp").forward(request,response);
        }else if(!password.equals(password2)){
            //密码不一致则 跳转注册页
                request.setAttribute("msg","密码不一至");
                request.getRequestDispatcher("/views/student/register.jsp").forward(request,response);
        }else {
            //创建一个学生类
            Student student = new Student();
            student.setUsername(username);
            student.setPassword(password);
            student.setAddress(address);
            student.setPhone(phone);
            //插入数据库
            Integer integer = service.register(student);
            if (integer > 0) {
                System.out.println("注册成功");
                response.sendRedirect("/views/login.jsp");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "stu":logoutStu(request,response);
            break;
            case "adm":logoutAdm(request,response);
            break;
            default: response.getWriter().write("请求未处理");
                break;
        }
    }

    /**
     * 管理员退出登录
     * @param request
     * @param response
     */
    private void logoutAdm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("admin");
        response.sendRedirect("/views/login.jsp");
    }

    /**
     *  学生退出登录
     * @param request
     * @param response
     */
    private void logoutStu(HttpServletRequest request, HttpServletResponse response) throws IOException {
         request.getSession().removeAttribute("student");
         response.sendRedirect("/views/student/index.jsp");
    }
}
