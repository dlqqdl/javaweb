<%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2020/12/21
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>派车管理</title>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>会议管理系统</h1>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath}/jsp/organJsp/index.jsp">退出</a>
    </div>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/organPublic.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/organStyle1.css"/>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time"></span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li ><a href="${pageContext.request.contextPath}/organ/myMeetingServlet">我的会议</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/organJsp/meetAdd.jsp">创建会议</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/organJsp/password.jsp">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/organJsp/dispatching.jsp">派车管理</a></li>
                <li><a href="${pageContext.request.contextPath}/organ/driverServlet?method=undispatchingDriver&dflag=0">空闲司机</a></li>
                <li><a href="${pageContext.request.contextPath}/organ/driverServlet?method=undispatchingDriver&dflag=1">繁忙司机</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/organJsp/index.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">

    </div>
</section>
<footer class="footer">
</footer>
<script src="${pageContext.request.contextPath}/js/time.js"></script>

</body>
</html>

