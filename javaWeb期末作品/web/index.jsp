<%@ page import="org.TianYa.entity.Favorite" %>
<%@ page import="java.util.List" %>
<%@ page import="org.TianYa.entity.Page" %><%--
  Created by IntelliJ IDEA.
  org.TianYa.entity.User: asusc
  Date: 2020/4/27
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link href="css/index.css" type="text/css" rel="stylesheet">
    <script src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <title>天涯社区</title>
  </head>
  <body>
  <%--图标-搜索--%>
  <div class="logo-search">
    <div class="logo">
      <%--嵌入图标--%>
    </div>
    <div class="search">
      <input type="text" placeholder="搜索...">
    </div>
  </div>
  <%--导航栏--%>
      <ul class="navigation">
        <li><a href="#">首页</a></li>
        <li><a href="#">热门博客</a>

          <%--下拉菜单--%>
           <div class="dropdown-content">
             <a herf="#">jsp</a>
             <a herf="#">css3</a>
             <a herf="#">html5</a>
           </div>
        </li>
        <li><a href="#">天涯名人</a></li>
        <li><a href="#">网上学习</a>
          <div class="dropdown-content">
            <a herf="#">JavaScript</a>
            <a herf="#">CSS/HTML</a>
            <a herf="#">数据库</a>
            <a herf="#">XML</a>
          </div>
        </li>
        <li><a href="#">实用工具</a>
          <div class="dropdown-content">
            <a herf="#">idea</a>
            <a herf="#">eclipse</a>
            <a herf="#">PhotoShop</a>
          </div>
        </li>

        <%--登录-注册--%>
        <div class="login-register">
        <li>
          <a href="login.jsp">登录</a>
        </li>
        <li>
          <a href="register.jsp">注册</a>
        </li>
        </div>
      </ul>

  <%--主要内容--%>
  <div class="main">
    <div class="col">
      <div>HTML/css</div>
      <div>JavaScript</div>
      <div>JSP</div>
      <div>BootStrap</div>
      <div>XML</div>
      <div>数据库</div>
      <div>移动端</div>
      <div>网站建设</div>
    </div>
    <div class="right">

      <%--第一行--%>
      <div class="row1">
        <h1>HTML/CSS</h1><hr>
          <a class="study" href="#">
            <h2>【HTML5】</h2>
            <img src="images/html5.jpg">
            <strong>学习HTML5</strong>
          </a>
          <a class="study" href="#">
            <h2>【HTML5】</h2>
            <img src="images/html5.jpg">
            <strong>学习HTML5</strong>
          </a>
          <a class="study" href="#">
            <h2>【HTML5】</h2>
            <img src="images/html5.jpg">
            <strong>学习HTML5</strong>
          </a><br/>
          <a class="study" href="#">
            <h2>【HTML5】</h2>
            <img src="images/html5.jpg">
            <strong>学习HTML5</strong>
          </a>
          <a class="study" href="#">
            <h2>【HTML5】</h2>
            <img src="images/html5.jpg">
            <strong>学习HTML5</strong>
          </a>
      </div>


        <%--第二行--%>
      <div class="row1">
        <h1>JavaScript</h1><hr>
        <a class="study" href="#">
          <h2>【JavaScript】</h2>
          <img src="images/JavaScript.jpg">
          <strong>学习JavaScript</strong>
        </a>
        <a class="study" href="#">
          <h2>【JavaScript】</h2>
          <img src="images/JavaScript.jpg"">
          <strong>学习JavaScript</strong>
        </a>
        <a class="study" href="#">
          <h2>【JavaScript】</h2>
          <img src="images/JavaScript.jpg"">
          <strong>学习JavaScript</strong>
        </a><br/>
        <a class="study" href="#">
          <h2>【JavaScript】</h2>
          <img src="images/JavaScript.jpg"">
          <strong>学习JavaScript</strong>
        </a>
        <a class="study" href="#">
          <h2>【JavaScript】</h2>
          <img src="images/JavaScript.jpg"">
          <strong>学习JavaScript</strong>
        </a>
      </div>

        <%--第三行--%>
      <div class="row1">
        <h1>JQuery</h1><hr>
        <a class="study" href="#">
          <h2>【JQuery】</h2>
          <img src="images/jQuery.jpg">
          <strong>学习JQuery</strong>
        </a>
        <a class="study" href="#">
          <h2>【JQuery】</h2>
          <img src="images/jQuery.jpg">
          <strong>学习JQuery</strong>
        </a>
        <a class="study" href="#">
          <h2>【JQuery】</h2>
          <img src="images/jQuery.jpg">
          <strong>学习JQuery</strong>
        </a><br/>
        <a class="study" href="#">
          <h2>【JQuery】</h2>
          <img src="images/jQuery.jpg">
          <strong>学习JQuery</strong>
        </a>
        <a class="study" href="#">
          <h2>【JQuery】</h2>
          <img src="images/jQuery.jpg">
          <strong>JQuery</strong>
        </a>
      </div>
        <div class="personal">
        <%--收藏博客--%>
            <table class="favorite"  style="border: 1px solid black">
              <h2  style="margin-left: 30px">我的收藏</h2><hr>
              <tr class="row1">
                <td width="10%" align="center"><b>编号</b></td>
                <td width="10%" align="center"><b>操作</b></td>
                <td width="40%" align="center"><b>收藏标题</b></td>
                <td width="35%" align="center"><b>关于方向</b></td>
              </tr>

                <%
                  Page p=(Page) request.getAttribute("p");
                  for (Favorite favorite1:p.getFavorites()
                       ) {
                %>
              <tr class="likeRow">
                <td align="center"><%=favorite1.getNo() %></td>
                  <td align="center"><a href="DeleteFavoriteServlet?no=<%=favorite1.getNo()%>" style="text-decoration: none; color: black">删除</a></td>
                  <td style="padding-left:10px "><a href="QueryFavoriteByNoServlet?no=<%=favorite1.getNo() %>"><%=favorite1.getTitle() %></a></td>
                  <td style="padding-left:10px "><%=favorite1.getAbout()%></td>
              </tr>
                  <%
                    }
                  %>
            </table>
              <a href="add.jsp" style="display: block;float: left"><input type="button" value="新增" style="margin-left: 50px"></a>
          <div class="filpOver" style="float: left; margin-left:200px">
            <%
              if(p.getCurrentPage()==0){
            %>
            <a href ="QueryFavoriteByPageServlet?currentPage=<%=p.getCurrentPage()+1%>">下一页</a>
            <a href ="QueryFavoriteByPageServlet?currentPage=<%=p.getTotalPage()-1%>">尾页</a>

            <%
            }else if(p.getCurrentPage()==p.getTotalPage()-1){
            %>
            <a href ="QueryFavoriteByPageServlet?currentPage=0">首页</a>
            <a href ="QueryFavoriteByPageServlet?currentPage=<%=p.getCurrentPage()-1%>">上一页</a>
            <%
            }else{
            %>
            <a href ="QueryFavoriteByPageServlet?currentPage=0">首页</a>
            <a href ="QueryFavoriteByPageServlet?currentPage=<%=p.getCurrentPage()-1%>">上一页</a>
            <a href ="QueryFavoriteByPageServlet?currentPage=<%=p.getCurrentPage()+1%>">下一页</a>
            <a href ="QueryFavoriteByPageServlet?currentPage=<%=p.getTotalPage()-1%>">尾页</a>
            <%
              }
            %>
          </div>
            <form style="float: right; margin-right: 100px">
              每页显示
              <select name="c">
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
              </select>
              条
              <input type="submit" value="确认">
            </form>
        </div>

    </div>

  </div>
  <!-- 增加提示 -->
  <%
    String Adderror=(String)request.getAttribute("Adderror");
    if(Adderror=="error"){
      out.print("<script type='text/javascript'>alert('增加失败');</script>");
    }else if(Adderror=="noerror"){
      out.print("<script type='text/javascript'>alert('增加成功');</script>");
    }else{//开始查询所有时，没有request域里没有error变量，所以不用执行操作

    }

  %>
  <!-- 删除提示 -->
  <%
    String Deleteerror=(String)request.getAttribute("Deleteerror");
    if(Deleteerror=="error"){
      out.print("<script type='text/javascript'>alert('删除失败');</script>");
    }else if(Deleteerror=="noerror"){
      out.print("<script type='text/javascript'>alert('删除成功');</script>");
    }else{//开始查询所有时，没有request域里没有error变量，所以不用执行操作

    }

  %>

  <!-- 更改提示 -->
  <%
    String Updateerror=(String)request.getAttribute("Updateerror");
    if(Updateerror=="error"){
      out.print("<script type='text/javascript'>alert('更改失败');</script>");
    }else if(Updateerror=="noerror"){
      out.print("<script type='text/javascript'>alert('更改成功');</script>");
    }else{//开始查询所有时，没有request域里没有error变量，所以不用执行操作

    }

  %>

  <!-- 登录 -->
  <%
    String LoginError=(String)request.getAttribute("LoginError");
    if(LoginError=="error"){
      out.print("<script type='text/javascript'>alert('登录失败');</script>");
    }else if(LoginError=="noerror"){
      out.print("<script type='text/javascript'>alert('登录成功');</script>");
    }else{//开始查询所有时，没有request域里没有error变量，所以不用执行操作

    }

  %>
  </body>
</html>
