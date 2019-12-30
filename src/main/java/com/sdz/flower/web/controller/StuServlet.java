package com.sdz.flower.web.controller;

import com.alibaba.fastjson.JSON;
import com.sdz.flower.bean.BaseResult;
import com.sdz.flower.bean.PageInfo;
import com.sdz.flower.pojo.Student;
import com.sdz.flower.service.StudentService;
import com.sdz.flower.service.impl.StudentServiceImpl;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * @author zhu
 */
@WebServlet(name = "StuServlet",urlPatterns = "/student/info")
public class StuServlet extends HttpServlet {

    private StudentService studentService= new StudentServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* Enumeration<String> parameterNames = request.getParameterNames();
        String ids = request.getParameter("ids");
        String action = request.getParameter("action");*/
       /* System.out.println(action);
        System.out.println(ids);
        while (parameterNames.hasMoreElements()){
            System.out.println(parameterNames.nextElement());
        }*/
        String action = request.getParameter("action");
        String flag = action==null ? "del":action;
        switch(flag){
            case "del":deleteStudent(request,response);
            break;
            default: response.getWriter().write("请求未处理");
        }
    }

    /**
     * 删除学生操作
     * @param request
     * @param response
     */
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ids = request.getParameter("ids");
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            for (int i = 0; i <idArray.length ; i++) {
                Integer integer = studentService.deleteStudent(Integer.parseInt(idArray[i]));
            }

            baseResult = BaseResult.success("删除用户成功");
        } else {
            baseResult = BaseResult.fail("删除用户失败");
        }
      response.getWriter().write(JSON.toJSONString(baseResult));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "list":studentList(request,response);
            break;
            default:response.getWriter().write("请求未处理");
        }
    }

    /**
     *  查询学生列表
     * @param request
     * @param response
     * @throws IOException
     */
    private void studentList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);
        PageInfo<Student> studentPageInfo=null;
        try {
             studentPageInfo = studentService.pageList(start, length);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.getWriter().write(JSON.toJSONString(studentPageInfo));
    }
}
