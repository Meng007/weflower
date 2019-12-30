package com.sdz.flower.web.controller;

import com.sdz.flower.pojo.Cart;
import com.sdz.flower.pojo.Flower;
import com.sdz.flower.pojo.Student;
import com.sdz.flower.service.Cartservice;
import com.sdz.flower.service.FlowerService;
import com.sdz.flower.service.impl.CartServiceImpl;
import com.sdz.flower.service.impl.FlowerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 史德竹 小猪猪
 */
@WebServlet(name = "CartServlet",urlPatterns = "/cart/info")
public class CartServlet extends HttpServlet {
    private Cartservice cartservice = new CartServiceImpl();
    private FlowerService flowerService = new FlowerServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "flower_cart":addCart(request,response);
                break;
            default:
                break;
        }
    }

    /**
     *  添加购物车
     * @param request
     * @param response
     */
    private void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fid = request.getParameter("fid");
        Flower flower = flowerService.selectFlowerById(Integer.parseInt(fid));
        Student student = (Student)request.getSession().getAttribute("student");
        Cart cart = new Cart();
        cart.setCount(1);
        cart.setFid(Integer.parseInt(fid));
        cart.setPrice(flower.getPrice());
        cart.setSid(student.getSid());

        Integer i = cartservice.addCart(cart);
        if (i>0){
            request.setAttribute("msg","加入购物车成功");
            request.setAttribute("flower",flower);
            request.getRequestDispatcher("/page/info?action=flower_one").forward(request,response);
        }else {
            response.getWriter().write("系统错误，失败");
        }


    }
}
