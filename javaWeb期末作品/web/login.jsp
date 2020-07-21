<%--
  Created by IntelliJ IDEA.
  org.TianYa.entity.User: asusc
  Date: 2020/4/27
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>天涯社区登录</title>
</head>
<body>
<form action="LoginServlet" method="post">
<table >
    <tr>
        <td>用户名:</td>
        <td><input type="text" name="uname"></td>
    </tr>
    <tr>
        <td>密码  :</td>
        <td><input type="password" name="upwd"></td>
    </tr></br>

</table>
<input type="submit" value="登录">
</form>
<a href="QueryFavoriteByPageServlet"><input type="submit" value="首页"></a>
<!-- 增加提示 -->
<%
    String AddUserError=(String)request.getAttribute("AddUserError");
    if(AddUserError=="error"){
        out.print("<script type='text/javascript'>alert('注册失败');</script>");
    }else if(AddUserError=="noerror"){
        out.print("<script type='text/javascript'>alert('注册成功');</script>");
    }else{//开始查询所有时，没有request域里没有error变量，所以不用执行操作

    }

%>
</body>
</html>
