<%@ page import="vo.confereeVo.Driver" %>
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
<%@include file="head.jsp"%>>
<!--主体内容-->
<section class="publicMian ">
    <%@include file="adminleft.jsp"%>>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>接送信息页面</span>
        </div>
        <!--用户-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="20%">司机姓名</th>
                <th width="20%">司机电话</th>
                <th width="20%">预计接送时间</th>
                <th width="20%">预计离开时间</th>
                <th width="20%">其他</th>
            </tr>
            <%
                Driver driver=new Driver();

                driver =(Driver)request.getAttribute("driver");
            %>
            <tr>
                <td>${driver.name}</td>
                <td>${driver.telephone}</td>
                <td>${driver.pick_time}</td>
                <td>${driver.leave_time}</td>
                <td>${driver.description}</td>

            </tr>
        </table>

    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<footer class="footer">
</footer>

<script src="${pageContext.request.contextPath}/js/confereeJquery.js"></script>
<script src="${pageContext.request.contextPath}/js/confereeJs.js"></script>
<script src="${pageContext.request.contextPath}/js/confereeTime.js"></script>

</body>
</html>