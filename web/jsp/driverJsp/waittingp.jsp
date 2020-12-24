<%@ page import="vo.driverVo.Pick" %>
<%@ page import="java.util.List" %>
<%@ page import="vo.driverVo.Driver" %>
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
                <li id="active"><a href="${pageContext.request.contextPath}/jsp/driverJsp/waittingp.jsp">待接乘客</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/driverJsp/driverconf.jsp">接送确认</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/driverJsp/changepassword.jsp">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/driverLogout">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>待接乘客页面</span>
        </div>
            <form action="${pageContext.request.contextPath}/driverPickController" method="post">
                <fieldset>
                    <legend>选择接送类型</legend>
                    接送类型:
                    <%
                        String cho= String.valueOf(request.getAttribute("type"));
                    %>
                    <select id="sel" name="sel">
                        <%if(cho.equals("special")){%>
                        <option value="special" <%="selected"%>>专车接送</option>
                        <option value="coach">大巴接送</option>
                        <option value="other">其他</option>
                        <%}else if(cho.equals("coach")){%>
                        <option value="special">专车接送</option>
                        <option value="coach" <%="selected"%>>大巴接送</option>
                        <option value="other">其他</option>
                        <%}else if(cho.equals("other")){%>
                        <option value="special">专车接送</option>
                        <option value="coach">大巴接送</option>
                        <option value="other" <%="selected"%>>其他</option>
                        <%}else{%>
                        <option value="special">专车接送</option>
                        <option value="coach">大巴接送</option>
                        <option value="other">其他</option><%}%>
                    </select>
                    <input type="submit" style="width: 80px;height: 30px" value="提交">
                </fieldset>
            </form>
            <form action="${pageContext.request.contextPath}/driverChoPassController" method="post">
            <table class="providerTable" cellpadding="0" cellspacing="0" id="tab">
                <tr class="firstTr">
                    <th width="20%">选择</th>
                    <th width="20%">ID</th>
                    <th width="30%">离开时间</th>
                    <th width="30%">要求</th>
                </tr>
                <%
                    Object picks = request.getAttribute("list");
                    String choice= String.valueOf(request.getAttribute("type"));
                    List<Pick> listPick = null;
                    if (picks instanceof List) {
                        listPick =(List<Pick>)picks;
                    }
                    if(listPick!=null) {
                        for(int i=0;i<listPick.size();i++) {%>
                <tr>
                    <td>
                        <%if(choice.equals("special")){%>
                        <input type="radio" value=<%=i%> name="special"><%}
                    else if(choice.equals("coach")){%>
                        <input type="checkbox" value=<%=i%> name="multi" onclick="onCheckBox(this)"><%}
                    else if(choice.equals("other")){}%>
                    </td>
                    <td><%=listPick.get(i).getConf_id()%></td>
                    <td><%=listPick.get(i).getLeave_time()%></td>
                    <td><%=listPick.get(i).getDescription()%></td>
                </tr>
                <%}}%>
            </table>
                <center>
                    <input type="submit" name="subForm" style="width: 80px;height: 30px" value="确定">
                    <input type="reset" style="width: 80px;height: 30px" value="重置">
                </center>
            </form>
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