<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/12/14
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>会议管理系统注册页面</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/confereeStyle1.css" >
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/confereeJquery-1.7.2.js"></script>
    <script type="text/javascript">
        // 页面加载完成之后

        function fun1() {
            // 给注册绑定单击事件
            $("#sub_btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为1到12位
                //1 获取用户名输入框里的内容
                var usernameText = $("#username").val();
                //2 创建正则表达式对象
                var usernamePatt = /^\w{1,12}$/;
                //3 使用test方法验证
                if (!usernamePatt.test(usernameText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("用户名不合法！");
                    return false;
                }

                // 验证密码：必须由字母，数字下划线组成，并且长度为1到12位
                //1 获取用户名输入框里的内容
                var passwordText = $("#password").val();
                //2 创建正则表达式对象
                var passwordPatt = /^\w{1,12}$/;
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

                // 邮箱验证：xxxxx@xxx.com
                //1 获取邮箱里的内容
                var emailText = $("#email").val();
                //2 创建正则表达式对象
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                //3 使用test方法验证是否合法
                if (!emailPatt.test(emailText)) {
                    //4 提示用户
                    $("span.errorMsg").text("邮箱格式不合法！");

                    return false;
                }

                // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
                var codeText = $("#code").val();

                去掉验证码前后空格
                 alert("去空格前：["+codeText+"]")
                codeText = $.trim(codeText);
                 alert("去空格后：["+codeText+"]")

                 if (codeText == null || codeText == "") {
                     //4 提示用户
                     $("span.errorMsg").text("验证码不能为空！");

                     return false;
                 }

                // 去掉错误信息
                $("span.errorMsg").text("");

            });

            return true;
        }


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

    <%
        Boolean flag=false;
        Object flag1=request.getAttribute("flag");
        if (flag1!=null){
            flag=(boolean)flag1;
        }
    %>
    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册会议管理系统会员</h1>
                    <span class="errorMsg"></span>
                </div>
                <div class="form">
                    <form action="${pageContext.request.contextPath}/conferee/registServlet" method="post" id="form1">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="1-12位字母，数字下划线"
                               autocomplete="off" tabindex="1" name="username" id="username"  style="height: 2px"/>
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="1-12位字母，数字下划线"
                               autocomplete="off" tabindex="1" name="password" id="password"  style="height: 2px"/>
                        <br />
                        <br />
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码"
                               autocomplete="off" tabindex="1" name="repwd" id="repwd"  style="height: 2px"/>
                        <br />
                        <br />
                        <label>电话：</label>
                        <input class="itxt" type="text" placeholder="输入1-10位的电话"
                               autocomplete="off" tabindex="1" name="tel" id="tel" id="tel" style="height: 2px"/>
                        <br />
                        <br />
                        <label>性别：</label>
                        <input type="radio" name="sex" value="M">男
                        <input type="radio" name="sex" value="F">女
                        <br />
                        <br />
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址 例：3485306666@qq.com"
                               autocomplete="off" tabindex="1" name="email" id="email" value="3485306666@qq.com" style="height: 2px"/>
                        <br />
                        <br />
                        <label>验证码：</label>
                        <input class="itxt" type="text" name="code" style="width: 150px;height: 3px" id="code" value="abcde"/>
<%--                        <img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px" style="height: 2px">--%>
                        <br />
                        <br />
                        <input type="button" value="注册" id="sub_btn" onclick="fun()"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<script>
    onload=function () {
        if (<%=flag%>){
            alert("用户名已存在！！！");
        }
    }
    function fun() {
        var errorMsg=document.getElementsByClassName("errorMsg")[0];
        var usernameText = $("#username").val();
        //2 创建正则表达式对象
        var usernamePatt = /^\w{1,12}$/;
        //3 使用test方法验证
        if (!usernamePatt.test(usernameText)) {
            //4 提示用户结果
            errorMsg.innerText="用户名不合法！";
            return ;
        }

        // 验证密码：必须由字母，数字下划线组成，并且长度为1到12位
        //1 获取用户名输入框里的内容
        var passwordText = document.getElementById("password").value;
        //2 创建正则表达式对象
        var passwordPatt = /^\w{1,12}$/;
        //3 使用test方法验证
        if (!passwordPatt.test(passwordText)) {
            //4 提示用户结果
            errorMsg.innerText="密码不合法！";

            return ;
        }

        // 验证确认密码：和密码相同
        //1 获取确认密码内容
        var repwdText = document.getElementById("repwd").value;
        //2 和密码相比较
        if (repwdText != passwordText) {
            //3 提示用户
            errorMsg.innerText="确认密码和密码不一致！";

            return ;
        }

        // 邮箱验证：xxxxx@xxx.com
        //1 获取邮箱里的内容
        var emailText =document.getElementById("email").value;
        //2 创建正则表达式对象
        var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
        //3 使用test方法验证是否合法
        if (!emailPatt.test(emailText)) {
            //4 提示用户
            errorMsg.innerText="邮箱格式不合法！";

            return ;
        }

        // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
        var codeText = document.getElementById("code").value;

        //去掉验证码前后空格
        codeText = $.trim(codeText);

        if (codeText == null || codeText == "") {
            //4 提示用户
            errorMsg.innerText="验证码不能为空！";
            return ;
        }
        // 去掉错误信息
        errorMsg.innerText="";

        var tel1=document.getElementById("tel").value.toString();
        if (tel1.length>10){
            alert("电话号码格式不符合！！！")
            return;
        }
        for (var i=0;i<tel1.length;i++){
            if (tel1.charAt(i)<'0'||tel1.charAt(i)>'9'){
                alert("电话号码格式不符合！！！")
                return ;
            }

        }
        document.getElementById("form1").submit();
    }
</script>
<div id="bottom">
			<span>
				swj.Copyright &copy;2020
			</span>
</div>
</body>
</html>
