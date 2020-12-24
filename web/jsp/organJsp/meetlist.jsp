<%@ page import="java.util.List" %>
<%@ page import="vo.organVo.Meeting" %><%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2020/12/17
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>会议详细</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/organPublic.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/organStyle1.css"/>

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/js.js"></script>
    <script src="${pageContext.request.contextPath}/js/time.js"></script>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>会议管理系统</h1>
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
                <li><a href="${pageContext.request.contextPath}/jsp/organJsp/index.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>会议管理页面</span>
        </div>
        <div class="search">
<%--            <span>商品名称：</span>--%>
<%--            <input type="text" placeholder="请输入商品的名称"/>--%>

<%--            <span>供应商：</span>--%>
<%--            <select name="tigong" >--%>
<%--                <option value="">--请选择--</option>--%>
<%--                <option value="">北京市粮油总公司</option>--%>
<%--                <option value="">邯郸市五得利面粉厂</option>--%>
<%--            </select>--%>

<%--            <span>是否付款：</span>--%>
<%--            <select name="fukuan">--%>
<%--                <option value="">--请选择--</option>--%>
<%--                <option value="">已付款</option>--%>
<%--                <option value="">未付款</option>--%>
<%--            </select>--%>

<%--            <input type="button" value="查询"/>--%>
            <a href="${pageContext.request.contextPath}/jsp/organJsp/meetAdd.jsp">创建会议</a>
        </div>
        <!--账单表格 样式和供应商公用-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">会议编号</th>
                <th width="20%">会议主题</th>
                <th width="10%">开始时间</th>
                <th width="10%">结束时间</th>
                <th width="10%">会议人数</th>
                <th width="10%">会议地址</th>
                <th width="30%">操作</th>
            </tr>
            <%
                List list= (List) session.getAttribute("list");
                for(int i=0;i<list.size();i++){
                    Meeting meeting=(Meeting) list.get(i);
            %>
            <tr>
                <td><%=meeting.getMeet_id()%></td>
                <td><%=meeting.getTopic()%></td>
                <td><%=meeting.getStart_time()%></td>
                <td><%=meeting.getEnd_time()%></td>
                <td><%=meeting.getNum_att()%></td>
                <td><%=meeting.getAddress()%></td>
                <td>
                    <a href="${pageContext.request.contextPath}/organ/mymeetingdetailsServlet?mtid=<%=meeting.getMeet_id()%>"><img src="${pageContext.request.contextPath}/image/read.png" alt="查看" title="查看"/></a>
<%--                    <a href="billUpdate.html"><img src="${pageContext.request.contextPath}/image/xiugai.png" alt="修改" title="修改"/></a>--%>
                    <a href="${pageContext.request.contextPath}/organ/removeMeetingServlet?mtid=<%=meeting.getMeet_id()%>" class="removeBill"><img src="${pageContext.request.contextPath}/image/schu.png" alt="删除" title="删除"/></a>
                </td>
                <td>
                    <%--     =<%=meeting.getMeet_id()%>？？？--%>
<%--                    <a class="clickbutton" href="mymeetingdetailsServlet?mtid=<%=meeting.getMeet_id()%>">详情</a>--%>
                </td>
            </tr>
            <%
                }
            %>

        </table>
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该会议吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<footer class="footer">
</footer>

</body>
</html>
