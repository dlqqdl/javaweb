<%@ page import="java.sql.Timestamp" %>
<%@ page import="vo.driverVo.Driver" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/12/8
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
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
    <%
      String name="您未登录";
      if(session.getAttribute("driveronline")!=null){
      Driver driver=(Driver)session.getAttribute("driveronline");
      name=driver.getName();}
    %>
    <p><span>你好！</span><span style="color: #fff21b"><%=name%></span> , 欢迎你！</p>
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
        <li><a href="${pageContext.request.contextPath}/jsp/driverJsp/changestatus.jsp">司机状态</a></li>
        <li><a href="${pageContext.request.contextPath}/jsp/driverJsp/waittingp.jsp">待接乘客</a></li>
        <li><a href="${pageContext.request.contextPath}/jsp/driverJsp/driverconf.jsp">接送确认</a></li>
        <li><a href="${pageContext.request.contextPath}/jsp/driverJsp/changepassword.jsp">密码修改</a></li>
        <li><a href="${pageContext.request.contextPath}/driverLogout">退出系统</a></li>
      </ul>
    </nav>
  </div>
  <div class="right">
    <img class="wColck" src="${pageContext.request.contextPath}/image/clock.jpg" alt=""/>
    <div class="wFont">
      <h2>Admin</h2>
      <p>欢迎来到司机管理系统!</p>
      <span id="hours"></span>
    </div>
  </div>
</section>
<footer class="footer">
</footer>
<script src="${pageContext.request.contextPath}/js/drivertime.js"></script>
</body>
</html>