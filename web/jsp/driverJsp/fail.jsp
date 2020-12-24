<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>司机管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Driverpublic.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Driverstyle.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>司机管理系统</h1>

    <div class="publicHeaderR">
        <p><span>你好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath}/driverLogout">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time"></span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
<!--                <li><a href="signup.jsp">司机注册</a></li>-->
                <li><a href="${pageContext.request.contextPath}/jsp/driverJsp/changestatus.jsp">司机状态修改</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/driverJsp/waittingp.jsp">待接乘客</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/driverJsp/driverconf.jsp">接送确认</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/driverJsp/changepassword.jsp">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/driverJsp/login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <center>
            <h1 style="color: #3278b3">操作失败</h1>
        </center>
    </div>
</section>
<footer class="footer">
</footer>
<script src="${pageContext.request.contextPath}/js/drivertime.js"></script>
</body>
</html>