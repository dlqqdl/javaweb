
<%@ page import="dao.confereeDao.impl.MeetingDaoImpl" %>
<%@ page import="vo.confereeVo.Meeting" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
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
            <span>会议预定页面</span>
        </div>
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">所有会议</th>
                <th width="10%">预计参加人数</th>
                <th width="20%">预计开始时间</th>
                <th width="20%">预计结束时间</th>
                <th width="20%">会议地址</th>
                <th width="40%">操作</th>
            </tr>

            <%
                MeetingDaoImpl meetingDao=new MeetingDaoImpl();
                List<Meeting> meetingList=new LinkedList<>();
                meetingList=meetingDao.ShowAllMeetings();
                for (int i=0;i<meetingList.size();i++){
            %>
            <tr>
                <td><%= meetingList.get(i).getTopic()%></td>
                <td><%= meetingList.get(i).getNum_att()%></td>
                <td><%= meetingList.get(i).getStart_time()%></td>
                <td><%= meetingList.get(i).getEnd_time()%></td>
                <td><%= meetingList.get(i).getAddress()%></td>
                <td>
                    <a href="${pageContext.request.contextPath}/conferee/bookMeetingServlet?meet_id=<%=meetingList.get(i).getMeet_id()%>"><img src="${pageContext.request.contextPath}/image/xiugai.png" alt="预定" title="预定"/></a>
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