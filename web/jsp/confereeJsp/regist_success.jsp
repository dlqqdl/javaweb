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
    <title>会议管理系统注册成功页面</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/confereeStyle1.css" >
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color:red;
        }
    </style>
</head>
<body>
<div id="header">
    <%--    <img class="logo_img" alt="" src="static/img/logo.gif" >--%>
    <div>
        <span>欢迎<span class="um_span"></span>光临本会议管理系统</span>
        <a href="${pageContext.request.contextPath}/jsp/confereeJsp/login.jsp">请您登录</a>
        <a href="">&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/jsp/confereeJsp/regist.jsp">返回</a>
    </div>
</div>

<div id="main">

    <h1>欢迎加入!</h1>

</div>

<div id="bottom">
			<span>
				swj.Copyright &copy;2020
			</span>
</div>
</body>
</html>