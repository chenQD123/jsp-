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

@WebServlet(name = "UpdateFavoriteServlet",urlPatterns ="/UpdateFavoriteServlet" )
public class UpdateFavoriteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int no = Integer.parseInt(request.getParameter("no"));
        String title = request.getParameter("title");
        String about = request.getParameter("about");

        // 将上面的变量封装到javabean里
        Favorite favorite = new Favorite(no, title, about);

        ITianYaService service = new TianYaServiceImpl();

        // 设置out响应对象的格式，要在对象响应之前去设置编码格式
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        boolean result = service.updateFavoriteByNo(no, favorite);
        // result为真执行else，假执行第一个
        if (!result) {
            request.setAttribute("Updateerror", "error");
        } else {
            request.setAttribute("Updateerror", "noerror");
        }
        // 跳转到QueryAllStudentServlet页面
        request.getRequestDispatcher("QueryFavoriteByPageServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request,response);
    }
}
