<%@ page import="org.TianYa.entity.Favorite" %><%--
  Created by IntelliJ IDEA.
  User: asusc
  Date: 2020/5/5
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收藏博客</title>
</head>
<body>
        <!--查询个人提示 -->
        <%
            String Queryerror=(String)request.getAttribute("Queryerror");
            if(Queryerror=="error"){
                out.print("查询失败");
            }else if(Queryerror=="noerror"){
                out.print("查询成功");
            }else{//开始查询所有时，没有request域里没有error变量，所以不用执行操作

            }

        %>
        <%
            Favorite favorite=(Favorite) request.getAttribute("favorite");

        %>
        <!-- 通过表单显示此人信息,查询单个人的信息 -->
        <form action="UpdateFavoriteServlet">
            编号:<input type="text" name="no" value="<%= favorite.getNo()%>"><br/>
            标题:<input type="text" name="title" value="<%= favorite.getTitle()%>"><br/>
            内容:<input type="text" name="about" value="<%= favorite.getAbout()%>"><br/>
            <input type="submit" value="修改">
            <a href="QueryFavoriteByPageServlet">返回</a>

        </form>
</body>
</html>
