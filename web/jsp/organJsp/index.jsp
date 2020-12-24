<%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2020/12/17
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>会议系统注册页面</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/organPublic.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/organStyle1.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/organStyle2.css"/>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
  <script type="text/javascript">
    // 页面加载完成之后
    $(function () {
      // 给注册绑定单击事件
      $("#sub_btn").click(function () {
        // 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
        //1 获取用户名输入框里的内容
        var usernameText = $("#username").val();
        //2 创建正则表达式对象
        var usernamePatt = /^\w{5,12}$/;
        //3 使用test方法验证
        if (!usernamePatt.test(usernameText)) {
          //4 提示用户结果
          $("span.errorMsg").text("用户名不合法！");
          return false;
        }
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

        //去掉验证码前后空格
        // alert("去空格前：["+codeText+"]")
        codeText = $.trim(codeText);
        // alert("去空格后：["+codeText+"]")

        if (codeText == null || codeText == "") {
          //4 提示用户
          $("span.errorMsg").text("验证码不能为空！");
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
    <span class="login_word">欢迎登录</span>
  </div>

  <div id="content">
    <div class="login_form">
      <div class="login_box">
        <div class="tit">
          <h1>登录会议管理系统会员</h1>
          <span class="errorMsg"></span>
        </div>
        <div class="form">
          <form action="${pageContext.request.contextPath}/organ/loginServlet" method="post">
            <label>用户名称：</label>
            <input class="itxt" type="text" placeholder="请输入用户名"
                   autocomplete="off" tabindex="1" name="username" id="accountname" name="usename" />
            <br />
            <br />
            <label>用户密码：</label>
            <input class="itxt" type="password" placeholder="请输入密码"
                   autocomplete="off" tabindex="1" id="new" name="pwd" />
            <br />
            <br />
            <CENTER>
              <input type="submit" value="登录" id="sub_btn1">
              <input type="reset" value="重置" id="sub_btn2">
              <input type="button" value="注册" id="sub_btn3" onclick="window.location.href='register.jsp'"/>
            </CENTER>
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
