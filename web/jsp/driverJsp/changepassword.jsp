<%@ page import="java.sql.Timestamp" %>
<%@ page import="vo.driverVo.Driver" %>
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
<%--                <li><a href="signup.jsp">司机注册</a></li>--%>
    <li><a href="${pageContext.request.contextPath}/jsp/driverJsp/changestatus.jsp">司机状态修改</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/driverJsp/waittingp.jsp">待接乘客</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/driverJsp/driverconf.jsp">接送确认</a></li>
                <li id="active"><a href="${pageContext.request.contextPath}/jsp/driverJsp/changepassword.jsp">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/driverLogout">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>密码修改页面</span>
        </div>
        <%if(session.getAttribute("driveronline")!=null){%>
        <div class="providerAdd">
            <form action="${pageContext.request.contextPath}/driverChangePwdController" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="oldPassword">旧密码：</label>
                    <input type="password" name="oldPassword" id="oldPassword" required/>
                    <span>*请输入原密码</span>
                </div>
                <div>
                    <label for="newPassword">新密码：</label>
                    <input type="password" name="newPassword" id="newPassword" required/>
                    <span >*请输入新密码</span>
                </div>
                <div>
                    <label for="reNewPassword">确认新密码：</label>
                    <input type="password" name="reNewPassword" id="reNewPassword" required/>
                    <span >*请输入新确认密码，保证和新密码一致</span>
                </div>
                <div class="subBtn" style="padding: 0 0 0 200px">
                    <input type="submit" value="确认" style="width: 60px;height: 40px" />
                    <input type="reset" value="重置" style="width: 60px;height: 40px;"/>
                </div>
            </form>
        </div><%}else {%>
        <center>
            <h1 style="color: red">请先登录</h1>
        </center>
        <%}%>
    </div>
</section>
<footer class="footer">
</footer>
<script src="${pageContext.request.contextPath}/js/drivertime.js"></script>
</body>
</html>
