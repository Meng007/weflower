package com.sdz.flower.web.controller;

import com.sdz.flower.pojo.Flower;
import com.sdz.flower.pojo.Order;
import com.sdz.flower.pojo.Student;
import com.sdz.flower.service.FlowerService;
import com.sdz.flower.service.OrderService;
import com.sdz.flower.service.impl.FlowerServiceImpl;
import com.sdz.flower.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 小猪猪
 */
@WebServlet(name = "OrderServlet",urlPatterns = "/order/info")
public class OrderServlet extends HttpServlet {
    private OrderService orderService = new OrderServiceImpl();
    private FlowerService flowerService = new FlowerServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "shop":shop(request,response);
            break;
            default:
                break;
        }
    }

    /**
     *  添加订单
     * @param request
     * @param response
     */
    private void shop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fid = request.getParameter("fid");
        Student student = (Student)request.getSession().getAttribute("student");

        Order order = new Order();
        order.setFid(Integer.parseInt(fid));
        order.setNumbers(UUID.randomUUID().toString());
        order.setSid(student.getSid());
        order.setStated("已付款");

        Integer integer = orderService.addOrder(order);
        if (integer>0){
            Flower flower = flowerService.selectFlowerById(Integer.parseInt(fid));
            request.setAttribute("msg","下单成功");
            request.setAttribute("flower",flower);
            request.getRequestDispatcher("/page/info?action=flower_one").forward(request,response);

        }else {
            response.getWriter().write("系统错误，下单失败");
        }

    }
}
