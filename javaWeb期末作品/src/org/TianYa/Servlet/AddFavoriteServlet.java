package org.TianYa.Servlet;

import org.TianYa.entity.Favorite;
import org.TianYa.service.impl.TianYaServiceImpl;

import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "AddFavoriteServlet",urlPatterns = "/AddFavoriteServlet")
public class AddFavoriteServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");

        int no=Integer.parseInt(request.getParameter("no"));
        String title=request.getParameter("title");
        String about=request.getParameter("about");

        // 设置out响应对象的格式，要在对象响应之前去设置编码格式
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        TianYaServiceImpl service=new TianYaServiceImpl();

        Favorite favorite=new Favorite(no,title,about);
        boolean result =service.addFavorite(favorite);
        // result为真执行else，假执行第一个
        if (!result) {
            request.setAttribute("Adderror", "error");
        } else {
            request.setAttribute("Adderror", "noerror");
        }
        // 跳转到QueryAllStudentServlet页面
        request.getRequestDispatcher("QueryFavoriteByPageServlet").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
