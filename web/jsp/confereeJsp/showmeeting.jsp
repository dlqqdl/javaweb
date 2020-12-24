
<%@ page import="vo.confereeVo.Meeting" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="service.confereeService.MeetingService" %>
<%@ page import="service.confereeService.impl.MeetingServiceImpl" %>
<%@ page import="vo.confereeVo.User" %>
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
            <stronga>你现在所在的位置是:</stronga>
            <span>会议信息页面</span>
        </div>
        <!--账单表格 样式和供应商公用-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">已选会议</th>
                <th width="10%">预计参加人数</th>
                <th width="20%">预计开始时间</th>
                <th width="20%">预计结束时间</th>
                <th width="20%">会议地址</th>
            </tr>

            <%
                List<Meeting> meetingList=new LinkedList<>();
                MeetingService meetingService=new MeetingServiceImpl();
                User user=(User)request.getAttribute("user");
                meetingList=meetingService.viewMyBookingInfo(user);
                for (Meeting meeting:meetingList){
            %>
            <tr>
                <td><%= meeting.getTopic()%></td>
                <td><%= meeting.getNum_att()%></td>
                <td><%= meeting.getStart_time()%></td>
                <td><%= meeting.getEnd_time()%></td>
                <td><%= meeting.getAddress()%></td>
            </tr>
            <%
                }
            %>
        </table>
        <h2 style="text-align: center">如需取消已预订会议请联系会议管理员！！！</h2>
    </div>
</section>

<footer class="footer">
</footer>

<script src="${pageContext.request.contextPath}/js/confereeJquery.js"></script>
<script src="${pageContext.request.contextPath}/js/confereeJs.js"></script>
<script src="${pageContext.request.contextPath}/js/confereeTime.js"></script>

</body>
</html>