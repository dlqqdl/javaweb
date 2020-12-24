<%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2020/12/17
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/organPublic.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/organStyle1.css"/>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/organStyle2.css"/>--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        $(function () {
            $("#提交").click(function () {
                // $("#errorspan").html("失败");不能用val
                var meetid = $("#meetid").val();
                var meettopic = $("#meettopic").val();
                var meetnum = $("#meetnum").val();
                var stime = $("#stime").val();
                var etime = $("#etime").val();
                var meetaddress = $("#meetaddress").val();
                // alert(meetaddress);
                $.ajax({
                    url:"${pageContext.request.contextPath}/organ/addMeetingServlet",
                    data:{
                        action:"addMeet",
                        meetid2:meetid,
                        meettopic2:meettopic,
                        meetnum2:meetnum,
                        stime2:stime,
                        etime2:etime,
                        meetaddress2:meetaddress,
                    },
                    type:"POST",
                    dataType:"json",
                    success:function (result1) {
                        console.log(result1);
                        if (result1.result2 === 0) {
                            alert("添加失败！");
                            $("#errorspan").html("失败");
                        } else {
                            alert("添加成功！");
                            $("#errorspan").html("成功");
                        }
                    }
                    },
                )
            })

        })
    </script>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

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
            <span>会议管理页面 >> 会议添加页面</span>
        </div>
        <div class="providerAdd">
            <form>
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="meetid">会议编号：</label>
                    <input type="text" name="meetid" id="meetid" >
                    <span id="errorspan">*请输入会议编号</span>
                </div>
                <div>
<%--                    <span class="errorMsg"></span>--%>
                    <label for="meettopic">会议主题：</label>
                    <input type="text" name="meettopic" id="meettopic" >
                </div>
                <div>
                    <label for="stime">会议开始时间：</label>
                    <input type=date name="stime" id="stime" >
                </div>
                <div>
                    <label for="stime">会议结束时间：</label>
                    <input type=date name="etime" id="etime" >
                </div>
                <div>
                    <label for="meetnum">会议上限人数：</label>
                    <input type="text" name="meetnum" id="meetnum" >
                </div>
                <div>
                    <label for="money">会议地址：</label>
                    <input type="text" name="meetaddress" id="money" >
                </div>
                <div class="providerAddBtn">
                    <input type="button" id="提交" value="提交">
                    <input type="reset" value="重置"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
</body>
</html>
