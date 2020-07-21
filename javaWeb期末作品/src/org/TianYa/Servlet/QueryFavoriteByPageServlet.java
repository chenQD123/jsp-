package org.TianYa.Servlet;

import org.TianYa.entity.Favorite;
import org.TianYa.entity.Page;
import org.TianYa.service.ITianYaService;
import org.TianYa.service.impl.TianYaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryFavoriteByPageServlet", urlPatterns="/QueryFavoriteByPageServlet")
public class QueryFavoriteByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ITianYaService Service = new TianYaServiceImpl();
        Page page = new Page();

        Long a = Service.getTotalCount();
        int count = Integer.parseInt(String.valueOf(a));// 数据总数
        page.setTotalCount(count); // set数据总数

        String cPage = request.getParameter("currentPage");

        if ( cPage== null) {
            cPage = "0";
        }
        int currentPage = Integer.parseInt(cPage);
        page.setCurrentPage(currentPage);// set当前页数

        String size = request.getParameter("c"); // 每页最多能装多少条数据

        if (size == null) {
            size = "2";
        }
        int pageSize = Integer.parseInt(size);
        page.setPageSize(pageSize); //set页面大小

        int cao=page.getTotalPage();
        List<Favorite> favorites = Service.queryFavoriteByPage(currentPage, pageSize);// 查询当前页数据集合
        page.setFavorites(favorites); // set当前页面的数据集

        request.setAttribute("p", page);// 将查询到的学生放入request域中
        // 跳转到QueryAllStudentServlet页面
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
