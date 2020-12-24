<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/12/14
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>会议管理系统登录页面</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/confereeStyle1.css" >
</head>
<body>
<div id="login_header">
</div>

<%
    Boolean flag=false;
    Object flag1=request.getAttribute("flag1");
    if (flag1!=null){
        flag=(boolean)flag1;
    }
%>
<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>会议管理系统登录</h1>
                    <a href="${pageContext.request.contextPath}/jsp/confereeJsp/regist.jsp">立即注册</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">请输入用户名和密码</span>
                </div>
                <div class="form">
                    <form action="${pageContext.request.contextPath}/conferee/loginServlet" method="post">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               autocomplete="off" tabindex="1" name="username" />
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="password" />
                        <br />
                        <br />
                        <input type="submit" value="登录" id="sub_btn" />
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<script>
    onload=function () {
        if (<%=flag%>){
            alert("密码错误重新输入！！！");
        }
    }
</script>
<div id="bottom">
			<span>
				swj.Copyright &copy;2020
			</span>
</div>
</body>
</html>
