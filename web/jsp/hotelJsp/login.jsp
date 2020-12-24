<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/hotelstyle.css"/>
    <title>系统登录 - 酒店</title>
    <script type="text/javascript">
	/* if(top.location!=self.location){
	      top.location=self.location;
	 } */
    </script>
</head>
<body class="login_bg">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>会议管理系统-酒店管理</h1>
        </header>
        <section class="loginCont">
	        <form class="loginForm" action="${pageContext.request.contextPath}/login.do"  name="actionForm" id="actionForm"  method="post" >
				<div class="info">${error}</div>
<%--                <div class="choice">--%>
<%--                    <label for="role">角色：</label>--%>
<%--                    <select id="role" name="role" onchange="changeRole(value)" >--%>
<%--                        <option value="conferee" selected>请选择</option>--%>
<%--                        <option value="conferee">与会者</option>--%>
<%--                        <option value="organ">组织者</option>--%>
<%--                        <option value="admin">管理者</option>--%>
<%--                        <option value="hotel">酒店</option>--%>
<%--                        <option value="driver">司机</option>--%>
<%--                    </select>--%>
<%--                </div>--%>
				<div class="inputbox">
                    <label for="name">用户名：</label>
					<input type="text" class="input-text" id="name" name="name" placeholder="请输入用户名" required/>
				</div>	
				<div class="inputbox">
                    <label for="password">密码：</label>
                    <input type="password" id="password" name="password" placeholder="请输入密码" required/>
                </div>	
				<div class="subBtn">
                    <input type="submit" value="登录"/>
                    <input type="reset" value="重置"/>
                </div>	
			</form>
        </section>
    </section>
<%--    <script type="text/javascript" src="${pageContext.request.contextPath}/js/hotelJs/login.js"></script>--%>
</body>
</html>
