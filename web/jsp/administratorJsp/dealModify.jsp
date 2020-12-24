<%@ page import="vo.administratorVo.Admin" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@include file="management.jsp"%>
<%
    Admin admin1=null;
    String msg="";
    String url="#";
    if(admin!=null) {
        admin1 = (Admin) admin;
    }
    else{
        out.write("<h1 id='notFound' style=\"margin-left:40%;\">this page is not found!</h1>");
        return;
    }
%>
<div class="mid-right>" id="mid-right-modifyPassword">
    <span>您的位置为：<a href="${pageContext.request.contextPath}/jsp/administratorJsp/management.jsp">首页<img src="${pageContext.request.contextPath }/image/navigate-outline.svg" width="30" height="30"></a>>>修改密码</span>
    <center id="center-form">
        <div>
            <form id="modForm"action="${pageContext.request.contextPath}/administrator/modifyPassword" method="post">
                <input name="account" type="hidden" value="<%=admin1!=null?admin1.getAdmin_id():null%>"><br/>
                请输入旧密码&nbsp;<input name="oldPassword" type="password" required/>*<br/>
                请输入新密码:<input name="newPassword" type="password" required />*<br/>
                <input type="submit" value="确认提交" onclick="checkPass()" />&nbsp;&nbsp;&nbsp;<input type="reset" value="清空"/><br/>
            </form>
            <%
                Object resultMsg=request.getAttribute("resultMsg");
                if(resultMsg!=null){
                    if((boolean)resultMsg){
                        msg="修改成功！";
                        session.removeAttribute("admin");//删掉，重新登录
                    }
                    else
                        msg="抱歉，修改失败！";
                }
            %>
            <a id="gotoMainJsp" href="<%=url%>" onchange="disappear()" onclick="show();closeSelf()"><%=msg%></a>
        </div>
    </center>
</div>
<script>
    function checkPass(){
        var checkForm=document.getElementById("modForm");
        if(checkForm.account.value===null){
            alert("请先登录！");
        }
    }
    function disappear(){
        document.getElementById("modForm").style.display="none";
        document.getElementById("gotoMainJsp").innerText=" ";
    }
    function show(){
        document.getElementById("modForm").style.display="block";
        document.getElementById("gotoMainJsp").innerText=" ";
    }
    function closeSelf(){
        if(<%=msg=="修改成功！"%>){
            document.getElementById("gotoMainJsp").href="${pageContext.request.contextPath }/jsp/administratorJsp/management.jsp";
        }
    }
</script>
</html>
