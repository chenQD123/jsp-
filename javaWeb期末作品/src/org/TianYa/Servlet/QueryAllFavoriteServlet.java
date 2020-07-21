package org.TianYa.Servlet;

import org.TianYa.entity.Favorite;
import org.TianYa.service.ITianYaService;
import org.TianYa.service.impl.TianYaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryAllFavoriteServlet", urlPatterns="/QueryAllFavoriteServlet")
public class QueryAllFavoriteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        TianYaServiceImpl service=new TianYaServiceImpl();
        List<Favorite> favorites=service.queryAllFavorite();
//        Content-Type标头告诉客户端实际返回的(服务器响应)内容的内容类型
        response.setContentType("text/html; charset=utf-8");
        //响应到客户端的编码，用于数据库的转码
        response.setCharacterEncoding("utf-8");

        request.setAttribute("favorites",favorites);
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }
}
