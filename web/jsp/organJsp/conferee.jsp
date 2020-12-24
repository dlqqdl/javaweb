<%@ page import="java.util.List" %>
<%@ page import="vo.organVo.DriverPick" %>
<%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2020/12/22
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>未安排司机</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/organPublic.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/organStyle1.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>派车管理系统</h1>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath}/jsp/organJsp/index.jsp">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time"></span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">

                <li ><a href="${pageContext.request.contextPath}/organ/myMeetingServlet">我的会议</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/organJsp/meetAdd.jsp">创建会议</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/organJsp/password.jsp">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/organJsp/dispatching.jsp">派车管理</a></li>
                <li><a href="${pageContext.request.contextPath}/organ/driverServlet?method=undispatchingDriver&dflag=0">空闲司机</a></li>
                <li><a href="${pageContext.request.contextPath}/organ/driverServlet?method=undispatchingDriver&dflag=1">繁忙司机</a></li>
                <li><a href="${pageContext.request.contextPath}/organ/confereeServlet?method=undispatchingConferee&cflag=0">未安排人员</a></li>
                <li><a href="${pageContext.request.contextPath}/organ/confereeServlet?method=undispatchingConferee&cflag=1">已安排人员</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/organJsp/index.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>派车管理页面</span>
        </div>

        <!--账单表格 样式和供应商公用-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">选择分配</th>
                <th width="10%">参会者编号</th>
                <th width="20%">参会者姓名</th>
                <th width="10%">参会者电话</th>
                <th width="10%">参会者性别</th>
                <th width="10%">接送司机编号</th>
                <th width="20%">接人时间</th>
                <th width="10%">离开时间</th>

                <th width="30%">操作</th>
            </tr>
            <%
                List list= (List) request.getAttribute("list");
                for(int i=0;i<list.size();i++){
                    DriverPick dp = (DriverPick) list.get(i);
            %>
            <tr>
                <td>
                    <checkbox name="选择" ></checkbox>
                </td>
                <td><%=dp.getConf_id()%></td>
                <td><%=dp.getName()%></td>
                <td><%=dp.getTel()%></td>
                <td><%=dp.getSex()%></td>
                <td><%=dp.getId()%></td>
                <td><%=dp.getPtime()%></td>
                <td><%=dp.getLtime()%></td>
            </tr>
            <%
                }
            %>

        </table>
    </div>
</section>

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/js.js"></script>
<script src="${pageContext.request.contextPath}/js/time.js"></script>
</body>
</html>
