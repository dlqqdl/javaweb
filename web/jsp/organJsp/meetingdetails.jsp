<%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2020/12/17
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>会议详细</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/organPublic.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/organStyle1.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/js.js"></script>
    <script src="${pageContext.request.contextPath}/js/time.js"></script>

</head>
<%@ page import="java.util.List" %>
<%@ page import="vo.organVo.Conferee" %>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>会议详细</h1>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath}/jsp/organJsp/index.jsp">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
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
<%--                <option value=""></option>--%>
<%--            </select>--%>

<%--            <span>是否付款：</span>--%>
<%--            <select name="fukuan">--%>
<%--                <option value="">--请选择--</option>--%>
<%--                <option value="">已付款</option>--%>
<%--            </select>--%>

<%--            <input type="button" value="查询"/>--%>
<%--            <a href="billAdd.html">添加订单</a>--%>
        </div>
        <!--账单表格 样式和供应商公用-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
<%--            <tr class="firstTr">--%>
<%--                <th width="10%">会议编号</th>--%>
<%--                <th width="20%">会议主题</th>--%>
<%--                <th width="10%">开始时间</th>--%>
<%--                <th width="10%">结束时间</th>--%>
<%--                <th width="10%">会议人数</th>--%>
<%--                <th width="10%">会议地址</th>--%>
<%--                <th width="30%">操作</th>--%>
<%--            </tr>--%>
            <tr class="firstTr">
                <th >编号</th>
                <th>姓名</th>
                <th>联系电话</th>
                <th>电子邮箱</th>
                <th>操作</th>
            </tr>
            <%
                List<Conferee> attconf = (List<Conferee>) request.getAttribute("attconf");
                int mtid2 = (int) request.getAttribute("mtid2");
                for(int i=0;i<attconf.size();i++){
            %>
            <tr>
                <td><%=attconf.get(i).getConf_id()%></td>
                <td><%=attconf.get(i).getName()%></td>
                <td><%=attconf.get(i).getTel()%></td>
                <td><%=attconf.get(i).getEmail()%></td>
                <td>
<%--                    <a href="billView.html"><img src="img/read.png" alt="查看" title="查看"/></a>--%>
<%--                    <a href="billUpdate.html"><img src="img/xiugai.png" alt="修改" title="修改"/></a>--%>
                    <a href="${pageContext.request.contextPath}/organ/removeConfereeServlet?conf_id=<%=attconf.get(i).getConf_id()%>&mt_id2=<%=mtid2%>" class="removeBill"><img src="${pageContext.request.contextPath}/image/schu.png" alt="删除" title="删除"/></a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<%--<div class="zhezhao"></div>--%>
<%--<div class="remove" id="removeBi">--%>
<%--    <div class="removerChid">--%>
<%--        <h2>提示</h2>--%>
<%--        <div class="removeMain">--%>
<%--            <p>你确定要删除该人员吗？</p>--%>
<%--            <a href="#" id="yes">确定</a>--%>
<%--            <a href="#" id="no">取消</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<footer class="footer">
</footer>
</body>
</html>
