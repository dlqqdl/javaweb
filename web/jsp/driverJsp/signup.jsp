<%@ page import="java.sql.Timestamp" %>
<%@ page import="vo.driverVo.Driver" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        <p><span>你好！</span><span style="color: #fff21b">游客</span> , 欢迎你！正在注册</p>
        <a href="${pageContext.request.contextPath}/jsp/driverJsp/login.jsp">返回</a>
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
                <li id="active"><a href="${pageContext.request.contextPath}/jsp/driverJsp/signup.jsp">司机注册</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>司机注册页面</span>
        </div>
        <div class="providerAdd">
            <form id="signup" action="${pageContext.request.contextPath}/driverSignupController" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label>司机id：</label>
                    <input type="text" name="driverid" id="oldPassword" required />
                    <span>*请输入司机id</span>
                </div>
                <div>
                    <label>电话:</label>
                    <input type="text" name="tel" id="tel" required />
                    <span >*请输入电话</span>
                </div>
                <div>
                    <label>名字:</label>
                    <input type="text" name="dname" required />
                    <span >*请输入名字</span>
                </div>
                <div>
                    <label for="newPassword">密码：</label>
                    <input type="password" name="newPassword" id="newPassword" required />
                    <span >*请输入密码</span>
                </div>
                <div>
                    <label for="reNewPassword">确认密码：</label>
                    <input type="password" name="reNewPassword" id="reNewPassword" required />
                    <span >*请确认密码，保证和密码一致</span>
                </div>
                <div class="subBtn" style="padding: 0 0 0 200px">
                    <input type="button" value="确认" style="width: 60px;height: 40px" onclick="checkLog()" />
                    <input type="reset" value="重置" style="width: 60px;height: 40px;" />
                </div>
            </form>
        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="${pageContext.request.contextPath}/js/drivertime.js"></script>
</body>
</html>
<%
    boolean res=true;
    Object re=request.getAttribute("signupResult");
    if(re!=null){
        res=false;
    }
%>
<script>
    window.onload=function(){
        if(<%=!res%>){
            alert("注册失败！");
        }
    }
    function checkLog(){
        var form=document.getElementById("signup");
        var id=document.getElementById("oldPassword").value;
        if(id===''){
            alert("ID只能为数字！");
            return ;
        }
        for(var i=0;i<id.length;i++){
            if(id.charAt(i)>'9'||id.charAt(i)<'0'){
                alert("ID只能为数字！");
                return ;
            }
        }
        var tel=document.getElementById("tel").value;
        if(tel===''){
            alert("电话只能为数字！");
            return ;
        }
        for(var i=0;i<tel.length;i++){
            if(tel.charAt(i)>'9'||tel.charAt(i)<'0'){
                alert("电话号码只能为数字！");
                return ;
            }
        }
        var pwd=document.getElementById("newPassword").value;
        var repwd=document.getElementById("reNewPassword").value;
        if(pwd===''||repwd===''){
            alert("密码不能为空！");
            return ;
        }
        if(pwd!==repwd){
            alert("两次密码不同！");
            return ;
        }
        form.submit();
    }
</script>
