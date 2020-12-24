<%@ page import="vo.confereeVo.Hotel" %>
<%@ page import="dao.confereeDao.impl.HotelDaoImpl" %>
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
        <div class="providerAdd">
            <form method="post" action="${pageContext.request.contextPath}/conferee/bookHotelServlet?hotelId=<%=request.getParameter("hotelId")%>" style="text-align: center">
                <%
                    Hotel hotel=new Hotel();
                    HotelDaoImpl hotelDao=new HotelDaoImpl();
                    hotel=hotelDao.GetHotel(Integer.parseInt(request.getParameter("hotelId")));
                %>
                <table border="1" >
                    <tr>
                        <th>酒店名:</th>
                        <th><%=hotel.getName()%></th>
                    </tr>
                    <tr>
                        <th>酒店地址:</th>
                        <th><%=hotel.getAddress()%></th>
                    </tr>
                    <tr>
                        <th>酒店电话:</th>
                        <th><%=hotel.getTel()%></th>
                    </tr>
                    <tr>
                        <th>入住时间:</th>
                        <th><input type="date" name="starttime" ></th>
                    </tr>
                    <tr>
                        <th>离开时间:</th>
                        <th><input type="date" name="endtime"></th>
                    </tr>
                    <tr>
                        <th>入住要求:</th>
                        <th><input type="textarea" name="description"></th>
                    </tr>

                </table>

                <div>
                    <input type="submit" value="提交" >

                </div>
                <h2 style="text-align: center">注：一次仅可申请一个酒店!!</h2>

            </form>
        </div>
    </div>
</section>

<footer class="footer">
</footer>

<script src="${pageContext.request.contextPath}/js/confereeJquery.js"></script>
<script src="${pageContext.request.contextPath}/js/confereeJs.js"></script>
<script src="${pageContext.request.contextPath}/js/confereeTime.js"></script>

</body>
</html>