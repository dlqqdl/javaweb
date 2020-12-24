<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 司机管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Driverstyle.css"/>
</head>
<body class="login_bg">
<section class="loginBox">
    <header class="loginHeader">
        <h1>司机管理系统</h1>
    </header>
    <section class="loginCont">
        <form class="loginForm" action="${pageContext.request.contextPath}/driverLoginServlet" method="post">
            <div class="inputbox">
                <label for="accountname">用户名：</label>
                <input id="accountname" name="usename" type="text" placeholder="请输入账号" required />
            </div>
            <div class="inputbox">
                <label for="new">密码：</label>
                <input id="new" name="pwd" type="password" placeholder="请输入密码" required />
            </div>
            <div class="subBtn">
                <input type="button" value="登录" onclick="checkLog()" />
                <input type="button" value="注册" onclick="Log()" />
            </div>
        </form>
    </section>
</section>
</body>
<%
    boolean res=true;
    Object re=request.getAttribute("loginResult");
    if(re!=null)
        res=false;
%>
</html>
<script>
    window.onload=function (){
        if(<%=!res%>){
            alert("密码错误！");
        }
    }
    function checkLog(){
        var id=document.getElementById("accountname").value;
        if(id===''){
            alert("账号只能为数字！");
            return ;
        }
        for(var i=0;i<id.length;i++){
            if(id.charAt(i)<'0'||id.charAt(i)>'9'){
                alert("账号只能为数字！");
                return ;
            }
        }
        document.getElementsByClassName("loginForm")[0].submit();
    }
    function Log() {
        window.location.href="${pageContext.request.contextPath}/jsp/driverJsp/signup.jsp";
    }
</script>
