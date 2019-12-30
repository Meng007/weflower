package com.sdz.flower.web.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/** 文件上传
 * @author  🐖
 */
@WebServlet(name = "UploadServlet",urlPatterns = "/image/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建一个磁盘工厂对象
        DiskFileItemFactory factory=new DiskFileItemFactory();
        //通过磁盘工厂对象创建上传对象
        ServletFileUpload upload=new ServletFileUpload(factory);
        //通过上传对象解析请求
        List<FileItem> list=null;
        try {
            list = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        for (FileItem file:list){
            //不是文本
            if (!file.isFormField()){
                InputStream inputStream = file.getInputStream();
                ServletContext servletContext = getServletContext();
                String path=servletContext.getRealPath("images");
                //判断保存图片的路径是否存在，不存在则创建
                File pic =new File(path);
                if(!pic.exists()){
                    pic.mkdir();
                }
                //创建UUID对象
                UUID uuid =UUID.randomUUID();

                Date time = new Date();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
                String fileName=df.format(time).toString()+"_"+file.getName();

                FileOutputStream fos=new FileOutputStream(path+"/"+fileName);

                //进行图片的读写操作 -- 拷贝
                IOUtils.copy(inputStream,fos);

                fos.close();
                inputStream.close();

                //响应前端
                HashMap<String, String> map = new HashMap<>();
                map.put("img","/images/"+fileName);
                response.getWriter().write(JSON.toJSONString(map));
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
