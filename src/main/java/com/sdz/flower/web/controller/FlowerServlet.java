package com.sdz.flower.web.controller;

import com.alibaba.fastjson.JSON;
import com.sdz.flower.bean.BaseResult;
import com.sdz.flower.bean.PageInfo;
import com.sdz.flower.bean.ResultBean;
import com.sdz.flower.pojo.Flower;
import com.sdz.flower.service.FlowerService;
import com.sdz.flower.service.impl.FlowerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author zhu
 */
@WebServlet(name = "FlowerServlet",urlPatterns = "/flower/info")
public class FlowerServlet extends HttpServlet {

    private FlowerService flowerService = new FlowerServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "add":addFlower(request,response);
            break;
            case "edit":editFlowerForm(request,response);
            break;
            default:
        }
    }

    private void editFlowerForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Flower flower = new Flower();
        flower.setName(request.getParameter("name"));
        flower.setPic(request.getParameter("pic"));
        flower.setBock(Integer.parseInt(request.getParameter("bock")));
        flower.setNum(Integer.parseInt(request.getParameter("num")));
        flower.setUpdated(new Date());
        flower.setTitle(request.getParameter("title"));
        flower.setPrice(Double.parseDouble(request.getParameter("price")));
        flower.setFid(Integer.parseInt(request.getParameter("fid")));
        flower.setUpdated(new Date());

        Integer integer = flowerService.updateFlower(flower);
        BaseResult baseResult =null;
        if (integer>0){
            baseResult = BaseResult.success("修改成功");
            request.setAttribute("baseResult",baseResult);
            request.getRequestDispatcher("/page/info?action=flower_list").forward(request,response);
        }else {
            baseResult = BaseResult.fail("修改失败");
            request.setAttribute("baseResult",baseResult);
            request.getRequestDispatcher("/page/info?action=flower_form").forward(request,response);
        }


    }

    /**
     *  添加 花卉
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void addFlower(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Flower flower = new Flower();
        flower.setName(request.getParameter("name"));
        flower.setPic(request.getParameter("pic"));
        flower.setNum(Integer.parseInt(request.getParameter("num")));
        flower.setUpdated(new Date());
        flower.setTitle(request.getParameter("title"));
        flower.setPrice(Double.parseDouble(request.getParameter("price")));

        Integer integer = flowerService.addFlower(flower);
        if (integer>0){
            request.setAttribute("baseResult", BaseResult.success("添加成功"));
            request.getRequestDispatcher("/page/info?action=flower_list").forward(request,response);
        }else {
            request.setAttribute("baseResult", BaseResult.fail("添加失败"));
            request.getRequestDispatcher("/page/info?action=flower_form").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "list":flowerList(request,response);
            break;
            case "edit":editFlower(request,response);
            break;
            case "pageFlower": pageFlower(request,response);
            break;
            case "flower":findOneFlower(request,response);
            break;
            default: response.getWriter().write("请求未处理");
        }
    }

    /**
     *  查找 单个
     * @param request
     * @param response
     */
    private void findOneFlower(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fid = request.getParameter("fid");
        Flower flower = flowerService.selectFlowerById(Integer.parseInt(fid));
        request.setAttribute("flower",flower);
        request.getRequestDispatcher("/page/info?action=flower_one").forward(request,response);
    }

    /**
     *  首页花卉 各个列表查询
     * @param request
     * @param response
     */
    private void pageFlower(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        switch (type){
            case "dr": dr(request,response);
            break;
            case "pz":pz(request,response);
            break;
            case "pj":pj(request,response);
            break;
            case "sp":sp(request,response);
            break;
            default:
                break;
        }
    }

    /**
     *  水培
     * @param request
     * @param response
     */
    private void sp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        String page1 = request.getParameter("page");
        String row1 = request.getParameter("row");

        Integer page2 = page1==null ? 1:Integer.parseInt(page1);
        Integer row2 = row1==null ? 5:Integer.parseInt(row1);
        ResultBean<Flower> dr = flowerService.pageList2(page2, row2, "%水植绿培%");

        //响应前端
        response.getWriter().write(JSON.toJSONString(dr));
    }

    /**
     *  盆景
     * @param request
     * @param response
     */
    private void pj(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        String page1 = request.getParameter("page");
        String row1 = request.getParameter("row");

        Integer page2 = page1==null ? 1:Integer.parseInt(page1);
        Integer row2 = row1==null ? 10:Integer.parseInt(row1);
        ResultBean<Flower> dr = flowerService.pageList2(page2, row2, "%盆景%");

        //响应前端
        response.getWriter().write(JSON.toJSONString(dr));
    }

    /**
     *  盆栽 列表
     * @param request
     * @param response
     */
    private void pz(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        String page1 = request.getParameter("page");
        String row1 = request.getParameter("row");

        Integer page2 = page1==null ? 1:Integer.parseInt(page1);
        Integer row2 = row1==null ? 10:Integer.parseInt(row1);
        ResultBean<Flower> dr = flowerService.pageList2(page2, row2, "%盆栽%");

        //响应前端
        response.getWriter().write(JSON.toJSONString(dr));
    }

    /**
     *  多肉植物查询
     * @param request
     * @param response
     */
    private void dr(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        String page1 = request.getParameter("page");
        String row1 = request.getParameter("row");

        Integer page2 = page1==null ? 1:Integer.parseInt(page1);
        Integer row2 = row1==null ? 5:Integer.parseInt(row1);
        ResultBean<Flower> dr = flowerService.pageList2(page2, row2, "%多肉%");

        System.out.println(dr);
        //响应前端
        response.getWriter().write(JSON.toJSONString(dr));

    }

    /**
     *  获取flower 信息
     * @param request
     * @param response
     */
    private void editFlower(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fid = request.getParameter("fid");
        Flower flower = flowerService.selectFlowerById(Integer.parseInt(fid));
        if ((flower !=null)){
            request.setAttribute("flower",flower);
            request.getRequestDispatcher("/page/info?action=flower_form").forward(request,response);
        }else {
            response.getWriter().write("系统错误");
        }
    }

    /**
     *  花卉列表
     * @param request
     * @param response
     * @throws IOException
     */
    private void flowerList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        PageInfo<Flower> flowers = null;
        try {
            flowers = flowerService.pageList(start, length);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.getWriter().write(JSON.toJSONString(flowers));
    }
}
