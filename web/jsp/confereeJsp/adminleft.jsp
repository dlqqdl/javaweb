
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="left">
    <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
    <nav>
        <ul class="list">
            <li><a href="${pageContext.request.contextPath}/jsp/confereeJsp/bookmeeting.jsp" methods="post">会议预定</a></li>
            <li><a href="${pageContext.request.contextPath}/jsp/confereeJsp/bookhotel.jsp" methods="post">酒店预定</a></li>
            <li><a href="${pageContext.request.contextPath}/conferee/showMeetingServlet">会议信息</a></li>
            <li><a href="${pageContext.request.contextPath}/conferee/showHotelServlet">住宿信息</a></li>
            <li><a href="${pageContext.request.contextPath}/conferee/showUserServlet">个人信息</a></li>
            <li><a href="${pageContext.request.contextPath}/conferee/showDriverServlet">接送信息</a></li>
            <li><a href="${pageContext.request.contextPath}/jsp/confereeJsp/password.jsp">密码修改</a></li>
        </ul>
    </nav>
</div>
