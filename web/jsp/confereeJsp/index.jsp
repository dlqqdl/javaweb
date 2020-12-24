<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>会议管理系统</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/confereePublic.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/confereeStyle.css"/>
</head>
<body>
<%@include file="head.jsp"%>
<!--主体内容-->
<section class="publicMian">
  <%@include file="adminleft.jsp"%>
  <div class="right">
    <img class="wColck" src="${pageContext.request.contextPath}/image/clock.jpg" alt=""/>
    <div class="wFont">
      <h2> ${sessionScope.username}</h2>
      <p>欢迎来到会议管理系统!</p>
      <span id="hours"></span>
    </div>
  </div>
</section>
<footer class="footer">
</footer>
<script src="${pageContext.request.contextPath}/js/confereeTime.js"></script>
</body>
</html>