<%@ page import="vo.confereeVo.Hotel" %>
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
<section class="publicMian ">
    <%@include file="adminleft.jsp"%>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>酒店信息页面 >> 信息查看</span>
        </div>
        <div class="providerView">
            <%
                Hotel hotel=new Hotel();
                hotel =(Hotel)session.getAttribute("Hotel");
            %>
            <p><strong>酒店名：</strong><span><%=hotel.getName()%></span></p>
            <p><strong>酒店地址：</strong><span><%=hotel.getAddress()%></span></p>
            <p><strong>酒店电话：</strong><span><%=hotel.getTel()%></span></p>
            <p><strong>入住房间：</strong><span><%=hotel.getRoom_id()%></span></p>
            <p><strong>入住要求：</strong><span><%=hotel.getDescription()%></span></p>
            <p><strong>入住时间：</strong><span><%=hotel.getStarttime()%></span></p>
            <p><strong>离开时间：</strong><span><%=hotel.getEndtime()%></span></p>
            <a href="${pageContext.request.contextPath}/conferee/showHotelServlet">返回</a>
        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="${pageContext.request.contextPath}/js/confereeTime.js"></script>

</body>
</html>
