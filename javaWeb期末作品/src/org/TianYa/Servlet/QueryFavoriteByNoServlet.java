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

@WebServlet(name = "QueryFavoriteByNoServlet",urlPatterns = "/QueryFavoriteByNoServlet")
public class QueryFavoriteByNoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int no = Integer.parseInt(request.getParameter("no"));

        ITianYaService service = new TianYaServiceImpl();
        Favorite favorite = service.queryFavoriteByNo(no);

        // 将此人的数据通过jsp显示：studentInfo.jsp

        request.setAttribute("favorite", favorite);// 将查询到的学生放入request域中

        // 如果request域中没有数据，使用重定向跳转到response。sendRedirect（）
        // 如果request域中有数据，就是用请求转发跳转
        if (favorite == null) {
            request.setAttribute("Queryerror", "error");
        } else {
            request.setAttribute("Queryerror", "noerror");
        }
        // 跳转到QueryAllStudentServlet页面
        request.getRequestDispatcher("FavoriteInfo.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request,response);
    }
}
