<%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2020/12/17
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>会议系统注册页面</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/organStyle2.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        // 页面加载完成之后
        $(function () {
            // 给注册绑定单击事件
            $("#sub_btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                // var usernameText = $("#username").val();
                // //2 创建正则表达式对象
                // var usernamePatt = /^\w{5,12}$/;
                // //3 使用test方法验证
                // if (!usernamePatt.test(usernameText)) {
                //     //4 提示用户结果
                //     $("span.errorMsg").text("用户名不合法！");
                //
                //     return false;
                // }

                // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var passwordText = $("#password").val();
                //2 创建正则表达式对象
                var passwordPatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!passwordPatt.test(passwordText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("密码不合法！");
                    return false;
                }

                // 验证确认密码：和密码相同
                //1 获取确认密码内容
                var repwdText = $("#repwd").val();
                //2 和密码相比较
                if (repwdText != passwordText) {
                    //3 提示用户
                    $("span.errorMsg").text("确认密码和密码不一致！");
                    return false;
                }
                // 去掉错误信息
                $("span.errorMsg").text("");

            });

        });

    </script>
    <style type="text/css">
        .login_form{
            height:420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <%--    <img class="logo_img" alt="" src="static/img/logo.gif" >--%>
</div>
<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>
    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册会议管理系统会员</h1>
                    <span class="errorMsg"></span>
                </div>
                <div class="form">
                    <form action="${pageContext.request.contextPath}/organ/registerServlet" >
<%--                        method=existOrganid--%>
                        <label>用户账号：</label>
                        <input class="itxt" type="text" placeholder="请输入用户账号"
                               autocomplete="off" tabindex="1" name="userid" id="userid" >
                        <br />
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               autocomplete="off" tabindex="1" name="username" id="username" >
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="password" id="password" >
                        <br />
                        <br />
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码"
                               autocomplete="off" tabindex="1" name="repwd" id="repwd" >
                        <br />
                        <br />
                        <label>电话：</label>
                        <input class="itxt" type="text" placeholder="请输入电话"
                               autocomplete="off" tabindex="1" name="tel" id="tel" >
                        <br />
                        <br />
                        <input type="submit" value="注册" id="sub_btn" />
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<div id="bottom">
			<span>
				xjt.Copyright &copy;2015
			</span>
</div>
</body>
</html>
