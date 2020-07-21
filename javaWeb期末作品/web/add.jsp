<%--
  Created by IntelliJ IDEA.
  User: asusc
  Date: 2020/5/3
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        function check(){//return:true表单正常提交，false表单终止提交

            var no =$("#no").val();
            if(!(no>0 && no<100)){
                alert("编号有误，必须是1—100")
                return false;
            }
            return true;
        }
        $(document).ready(function(){
        });

    </script>
    <title>新增收藏</title>
</head>
<body>
            <form  action="AddFavoriteServlet" method="post" onsubmit="return check()">
                编号:<input type="text" name="no" id="no"/><br/>
                标题:<input type="text" name="title" id="title"/><br/>
                关于内容:<input type="text" name="about" id="about"/><br/>
                <input type="submit"  value="增加" /><br/>
            </form>
</body>
</html>
