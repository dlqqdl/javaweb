<%@ page import="service.driverService.PickService" %>
<%@ page import="java.util.List" %>
<%@ page import="vo.driverVo.Pick" %>
<%@ page import="vo.driverVo.Driver" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
<%--                <li><a href="signup.jsp">司机注册</a></li>&lt;%&ndash;待修改，注册&ndash;%&gt;--%>
    <li><a href="${pageContext.request.contextPath}/jsp/driverJsp/changestatus.jsp">司机状态修改</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/driverJsp/waittingp.jsp">待接乘客</a></li>
                <li id="active"><a href="${pageContext.request.contextPath}/jsp/driverJsp/driverconf.jsp">接送确认</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/driverJsp/changepassword.jsp">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/driverLogout">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>司机确认页面</span>
        </div>
        <%if(session.getAttribute("driveronline")!=null){%>
        <form action="${pageContext.request.contextPath}/driverDriverConfController" method="post">
            <table class="providerTable" cellpadding="0" cellspacing="0" id="tab">
                <tr class="firstTr">
                    <th width="20%">选择</th>
                    <th width="20%">已确认乘客</th>
                    <th width="30%">离开时间</th>
                    <th width="30%">要求</th>
                </tr>
                <%
                    PickService service=new PickService();
                    List<Pick> picks;
                    Driver driver=(Driver)session.getAttribute("driveronline");
                    System.out.println("wwwww");
                    System.out.println(driver.getDriver_id());
                    picks=service.findPassConfirm(driver.getDriver_id());
                    if(picks!=null) {
                        for(int i=0;i<picks.size();i++) {%>
                <tr>
                    <td>
                        <input type="checkbox" value=<%=i%> name="inputpc">
                    </td>
                    <td><%=picks.get(i).getConf_id()%></td>
                    <td><%=picks.get(i).getLeave_time()%></td>
                    <td><%=picks.get(i).getDescription()%></td>
                </tr>
                <%}}%>
            </table>
            <center>
                <input type="submit" name="subForm" style="width: 80px;height: 30px" value="确定">
                <input type="reset" style="width: 80px;height: 30px" value="重置">
            </center>
        </form>
        <%}
        else{%>
        <center>
            <h1 style="color: red">你没有查看的权限，请先登录</h1>
        </center><%}%>
    </div>
</section>
<footer class="footer">
</footer>
<script src="${pageContext.request.contextPath}/js/drivertime.js"></script>
<script language="JavaScript">
    function onCheckBox(checkbox)
    {
        var items = document.getElementsByName("multi");
        var maxChoices = 2;
        var flag = 0;

        for(var i=0; i<items.length; i++)
        {
            if(items[i].checked)
            {
                flag ++;
            }
        }
        if(flag >= maxChoices)
        {
            for(var k=0; k<items.length; k++)
            {
                if(!items[k].checked)
                {
                    items[k].disabled = true;
                }
            }
        }
        else
        {
            for(var p=0; p<items.length; p++)
            {
                if(!items[p].checked)
                {
                    items[p].disabled = false;
                }
            }
        }
    }//限制选择的数量
</script>
</body>
</html>
