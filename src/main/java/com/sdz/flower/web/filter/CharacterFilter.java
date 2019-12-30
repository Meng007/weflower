package com.sdz.flower.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 字符编码过滤
 *   /* 表示根目录下的都过滤掉 记住了
 * @author zhu
 */
@WebFilter(filterName = "CharacterFilter",urlPatterns = "/*")
public class CharacterFilter implements Filter {
    @Override
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //response.setContentType("text/html;charset=utf-8")
        response.setCharacterEncoding("utf-8");
        chain.doFilter(request, response);
    }
    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
