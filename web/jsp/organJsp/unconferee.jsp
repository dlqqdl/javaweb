<%@ page import="java.util.List" %>
<%@ page import="vo.organVo.Driver" %>
<%@ page import="vo.organVo.DriverPick" %>
<%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2020/12/21
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>未安排司机</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/organPublic.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/organStyle1.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        $(function () {
            $("#派车").click(function () {
                var arr=new Array();
                var a=$("#driver_name").val();
                 var conferees = $("input:checkbox[name='选择未参会人员']:checked");
                 for(var i=0;i<conferees.length;i++){
                     arr[i]=conferees[i].value;
                 }

                 $.ajax({
                     url:"driverPickServlet",
                     data:{
                         a:a,
                         arr:arr,
                         method:"disputeConferee"
                     },
                     type:"POST",
                     traditional:true,
                     dataType:"json",
                     success:function (result) {
                         if(result.result1===1){
                             alert("派车成功！"+arr.length+"人");
                                 for(var i=0;i<arr.length;i++){
                                     document.getElementById(arr[i]).remove();
                                 }

                        }else {
                             alert("派车失败！")
                         }
                      }
                 })
            })
        })

    </script>
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
            <span>派车管理页面>未分配司机的会务参与者页面</span>
        </div>

        <div class="search">
            <span>司机：</span>
            <select name="driver_name" id="driver_name">
                <option value="">--请选择--</option>
                <%   List list1= (List) session.getAttribute("list2");
                    for(int i=0;i<list1.size();i++){
                        Driver dp = (Driver) list1.get(i);
                %>
                <option value="<%=dp.getDriverid()%>" name="dispatching" id="dispatching">姓名：<%=dp.getName()%>，编号<%=dp.getDriverid()%></option>
                <%
                    }
                %>
            </select>

<%--            <span>是否派车：</span>--%>
<%--            <select name="fukuan">--%>
<%--                <option value="">--请选择--</option>--%>
<%--                <option value=""></option>--%>
<%--                <option value=""></option>--%>
<%--            </select>--%>

            <input type="button" value="派车" id="派车"/>

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
            <tr id="<%=dp.getConf_id()%>">
                <td>
                    <input type="checkbox" value="<%=dp.getConf_id()%>" name="选择未参会人员">
                </td>
                <td><%=dp.getConf_id()%></td>
                <td><%=dp.getName()%></td>
                <td><%=dp.getTel()%></td>
                <td><%=dp.getSex()%></td>
                <td><%=dp.getId()%></td>
                <td><%=dp.getPtime()%></td>
                <td><%=dp.getLtime()%></td>

                <%--                <td>--%>
                <%--                    <a href="mymeetingdetailsServlet?mtid=<%=meeting.getMeet_id()%>"><img src="img/read.png" alt="查看" title="查看"/></a>--%>
                <%--                    <a href="billUpdate.html"><img src="img/xiugai.png" alt="修改" title="修改"/></a>--%>
                <%--                    <a href="removeMeetingServlet?mtid=<%=meeting.getMeet_id()%>" class="removeBill"><img src="img/schu.png" alt="删除" title="删除"/></a>--%>
                <%--                </td>--%>

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
