
<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="dao.confereeDao.impl.HotelDaoImpl" %>
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
            <span>酒店预定页面</span>
        </div>

        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">所有酒店</th>
                <th width="10%">酒店地址</th>
                <th width="20%">酒店电话</th>
                <th width="20%">房间剩余状态</th>
                <th width="40%">操作</th>
            </tr>

            <%
                HotelDaoImpl hotelDao=new HotelDaoImpl();
                List<Hotel> hotelList=new LinkedList<>();
                hotelList=hotelDao.ShowAllHotels();
                System.out.println("hotellist长度为："+hotelList.size());
//                    for (int i=0;i<hotelList.size();i++){
                for (Hotel hotel:hotelList){
            %>
            <tr>
                <td><%= hotel.getName()%></td>
                <td><%= hotel.getAddress()%></td>
                <td><%= hotel.getTel()%></td>
                <td><%= hotel.getRooms()%></td>
                <td>
                    <a href="${pageContext.request.contextPath}/jsp/confereeJsp/bookhotel1.jsp?hotelId=<%=hotel.getHotel_id()%>"><img src="${pageContext.request.contextPath}/image/xiugai.png" alt="进入预定" title="进入预定"/></a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</section>

<footer class="footer">
</footer>

<script src="${pageContext.request.contextPath}/js/confereeJquery.js"></script>
<script src="${pageContext.request.contextPath}/js/confereeJs.js"></script>
<script src="${pageContext.request.contextPath}/js/confereeTime.js"></script>

</body>
</html>