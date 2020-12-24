<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>酒店住宿管理</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/hotelstyle.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/hotelpublic.css" />
</head>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>酒店住宿管理</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b"> ${hotelSession.name}</span> , 欢迎你！</p>
            <a href="${pageContext.request.contextPath }/jsp/logout.do">退出</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">2020年1月1日 11:11  星期一</span>
        <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
 <!--主体内容-->
 <section class="publicMian ">
     <div class="left">
         <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
         <nav>
             <ul class="list">
                <li><a href="${pageContext.request.contextPath}/jsp/user.do?method=query">住宿管理</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/user.do?method=query2">分配管理</a></li>
<%--                <li><a href="${pageContext.request.contextPath}/jsp/...">酒店详情</a></li>--%>
                <li><a href="${pageContext.request.contextPath}/jsp/hotelJsp/jsp/pwdmodify.jsp">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/logout.do">退出系统</a></li>
             </ul>
         </nav>
     </div>
     <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath}"/>
     <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>