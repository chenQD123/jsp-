package org.TianYa.Servlet;

import org.TianYa.entity.Favorite;
import org.TianYa.entity.User;
import org.TianYa.service.impl.TianYaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddUserServlet",urlPatterns = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");

        String uname=request.getParameter("uname");
        String upwd=request.getParameter("upwd");
        String usex=request.getParameter("radio");
        String umail=request.getParameter("umail");

        // 设置out响应对象的格式，要在对象响应之前去设置编码格式
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        TianYaServiceImpl service=new TianYaServiceImpl();

        User user=new User(uname,upwd,usex,umail);
        boolean result =service.addUser(user);
        // result为真执行else，假执行第一个
        if (!result) {
            request.setAttribute("AddUserError", "error");
        } else {
            request.setAttribute("AddUserError", "noerror");
        }
        // 跳转到QueryAllStudentServlet页面
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request,response);
    }
}
