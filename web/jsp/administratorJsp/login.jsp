<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body{
            width:100%;
            background-image: url("${pageContext.request.contextPath }/image/login_bg.jpg");
            background-repeat: no-repeat;
            background-size: 100% auto;
        }
        #login-box {
            border: 1px solid blue;
            width: 30%;
            text-align: center;
            margin: 15% auto 0;
            background: #00000080;
            padding: 20px 50px;
        }
        #login-box h1 {
            color: white;
        }
        #login-box .form .item input {
            width: 200px; /* 设置合适的宽度 */
            border: 0; /* 首先将边界取消，方便下面修改下部边界宽度 */
            border-bottom: 5px solid white; /* 将下边界进行修改，显示出横线效果 */
            font-size: 18px; /* 将字体适当的变大加粗 */
            background: #ffffff00; /* 将输入框设置为透明 */
            color: white; /* 上面的文本颜色设置为白色，但是placeholder的颜色要单独设置 */
            padding: 5px 10px; /* 为了placeholder的内容不是顶格显示，增加内部边界 */
        }
        #login-box .form .item i {
            color: white;
            font-size: 18px;
        }
        #login-box input[type="button"] {
            border: 0; /* 取消按钮的边界 */
            width: 150px; /* 设置合适的按钮的长和宽 */
            height: 30px;
            margin-top: 18px; /* 设置合适的上部外框的宽度，增加与上面的password框的距离 */
            font-size: 18px; /* 修改按钮文字的大小 */
            color: white; /* 修改按钮上文字的颜色 */
            border-radius: 25px; /* 将按钮的左右边框设置为圆弧 */
            background-image: linear-gradient(to right, #00dbde 0%, #fc00ff 100%); /* 为按钮增加渐变颜色 */
        }
        a{text-decoration: none;}
        input[type="text"]:hover{transform: scale(1.2);}
        input[type="password"]:hover{transform: scale(1.2);}
    </style>
</head>
<body>
<div>
    <%
        Object result= session.getAttribute("loginResult");
        boolean res=true;
        if(result!=null&&!((boolean)result))
            res=false;
    %>
    <form name="logForm" action="${pageContext.request.contextPath}/administrator/login" method="POST">
        <div id="login-box">
            <h1>Login</h1> <!-- Login的大标题 -->
            <div class="form">
                <div class="item"> <!-- username部分 -->
                    <i class="fa fa-user-circle" aria-hidden="true"></i>
                    <i class="fa fa-key" aria-hidden="true"></i>
                    <input type="text" placeholder="account" name="account" required> <!-- 用文本框实现的username的输入 -->
                </div>
                <div class="item"> <!-- password部分 -->
                    <i class="fa fa-user-circle" aria-hidden="true"></i>
                    <i class="fa fa-key" aria-hidden="true"></i>
                    <input type="password" placeholder="password" name="password" required> <!-- 用password文本框实现的密码输入 -->
                </div>
            </div>
            <input type="button" value="Login" onclick="checkLogin()"><!-- 用button实现的Login登陆按钮 -->
            <a href="#">忘记密码？联系管理员</a>
        </div>
    </form>
</div>
</body>
</html>
<script>
    onload=function(){
        if(<%=!res%>){
            alert("登录失败！");
        }
    }
    function checkLogin(){
        var form=document.getElementsByName("logForm")[0];
        var account=document.getElementsByName("account")[0].value.toString();
        if(account<'0'||account>'9'){
            alert("账号不符合规范！只能是数字！");
            return;
        }
        form.submit();
    }
</script>


