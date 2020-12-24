<%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2020/12/18
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/organPublic.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/organStyle1.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>

        $(function () {
            $("#reNewPassword").blur( function f1() {
                var reNewPassword = $("#reNewPassword").val();
                var newPassword = $("#newPassword").val();

                if (reNewPassword == newPassword) {
                    $("#respan").text("密码一致！")
                    return true;
                } else {
                    $("#respan").text("两次密码不一致！")
                    return false;
                }
            })

            $("#savePwd").click(function () {

                var newPassword = $("#newPassword").val();

                if(function () {
                    var reNewPassword = $("#reNewPassword").val();
                    var newPassword = $("#newPassword").val();
                    if (reNewPassword == newPassword) {
                        return true;
                    } else {
                        return false;
                    }
                }){
                    $.ajax({
                        url: "/organ/organServlet",
                        data: {
                            method: "modifyPassword",
                            // action: "addMeet"
                            newPassword: newPassword,
                        },
                        type: "POST",
                        dataType: "json",
                        success: function (result) {
                            console.log(result);
                            //result=0,说明不存在
                            if (result.result == 0) {
                                // alert("fuwuyi"+result1.result2);
                                alert("修改失败！");
                                $("#respan").html("失败");
                            } else {
                                // alert("fuwuyi"+parseInt(result1.result2));
                                // alert("fuwuyi"+result1.result2);
                                alert("修改成功！");
                                $("#respan").html("成功");
                            }
                        }
                    })
                }


            })
        })
    </script>
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
            <span>密码修改页面</span>
        </div>
        <div class="providerAdd">
            <%--            毒瘤注意--%>
            <form>
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="oldPassword">旧密码：</label>
                    <input type="password" name="oldPassword" id="oldPassword" required/>
                    <span>*请输入原密码</span>
                </div>
                <div>
                    <label for="newPassword">新密码：</label>
                    <input type="password" name="newPassword" id="newPassword" required/>
                    <span>*请输入新密码</span>
                </div>
                <div>
                    <label for="reNewPassword">确认新密码：</label>
                    <input type="password" id="reNewPassword" required/>
                    <span id="respan">*请输入新确认密码，保证和新密码一致</span>
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->

                    <input type="button" value="保存" id="savePwd">
                    <%--                    onclick="history.back(-1)--%>
                </div>
            </form>
        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="${pageContext.request.contextPath}/js/time.js"></script>

</body>
</html>
