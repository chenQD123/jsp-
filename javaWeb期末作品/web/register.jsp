<%--
  Created by IntelliJ IDEA.
  org.TianYa.entity.User: asusc
  Date: 2020/4/27
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/register.css" type="text/css" rel="stylesheet">
    <script src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="js/register.js"></script>
    <title>天涯社区注册</title>
</head>
<body>
<div id="center">



<div id="left">
    <div id="up">
        <p align="left" style="font-size: 50px">For</p>
        <p id="animate1">JSP</p>
    </div>
    <div id="down"></div>
</div>

<div id="right">
    <h1 align="center">天涯社区用户注册</h1>
<form action="AddUserServlet" method="post">
    <%--用户注册表单--%>
    <table align="center">
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="uname" placeholder="请输入用户名"></td>
        </tr>
        <tr>
            <td>密码  :</td>
            <td><input type="password" name="upwd" placeholder="请输入密码"></td>
        </tr>
        <tr>
            <td>邮箱  :</td>
            <td><input type="text" name="umail" placeholder="请输入邮箱"><br/></td>
        </tr>
    </table></br>

    <%--性别--%>
    性别：
    <label>
        <input type="radio" name="radio" id="uSex" value="男" checked="checked"/> 男
    </label>
    <label>
        <input type="radio" name="radio" id="uSex2" value="女"/> 女
    </label><br/>

    <%--用户擅长的领域--%>
    <br/> 擅长领域：
    <lable>    <%--lable是多选标签--%>
        <input type="checkbox" name="zq" id="zq" value="jsp"/> jsp
    </lable>

    <lable>
        <input type="checkbox" name="yy" id="yy" value="js"/> js
    </lable>
    <lable>
        <input type="checkbox" name="ly" id="ly" value="html5"/> html5
    </lable>
    <lable>
        <input type="checkbox" name="yx" id="yx" value="游戏"/> 游戏
    </lable>
    <lable>
        <input type="checkbox" name="qt" id="qt" value="其他"/> 其他
    </lable><br/><br/><br/>

    <%--提交信息--%>
    <input type="submit" value="注册">
        <a href="login.jsp"><input type="button" value="其他登录"></a>
        <a href="QueryFavoriteByPageServlet"><input type="button" value="首页"></a>
</form>

</div>
</div>
</body>
</html>
