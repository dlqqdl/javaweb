<%@ page import="vo.administratorVo.Admin" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@include file="management.jsp"%>
<%
    Admin admin1=null;
    if(admin!=null) {
        admin1 = (Admin) admin;
    }
    else{
        out.write("<h1 id='notFound' style=\"margin-left:40%;\">this page is not found!</h1>");
        return;
    }
%>
    <div class="mid-right" id="mid-right-addNewDriver">
        <span>您的位置为：<a href="${pageContext.request.contextPath}/jsp/administratorJsp/management.jsp">首页<img src="${pageContext.request.contextPath }/image/navigate-outline.svg" width="30" height="30"></a>>>新增司机</span>
        <center>
            <h2>填写雇佣司机信息</h2>
            <form id="addNewDriverForm" action="${pageContext.request.contextPath}/administrator/doWithDriver?method=addNewDriver" method="post">
                <table border="1">
                    <tr><td class="td-rows">司 机 工 号</td><td><input name="driver_id" type="text" required /></td></tr>
                    <tr><td class="td-rows">联 系 电 话</td><td><input name="telephone" type="text" required /></td></tr>
                    <tr><td class="td-rows">司 机 名 称</td><td><input name="name" type="text" required /></td></tr>
                    <tr><td class="td-rows">默 认 密 码</td><td><input name="password" type="password" value="00000"/></td></tr>
                </table>
                <input type="submit" value="提交"/><input type="reset" value="重填" />
            </form>
            <%
                String url="#";
                String msg="";
                Object addDriverResult=request.getAttribute("addDriverResult");
                if(addDriverResult!=null){
                    if((boolean)addDriverResult){//true,修改成功
                        url=request.getContextPath()+"/jsp/administratorJsp/management.jsp";
                        msg="添加成功！返回.";
                    }
                    else
                        msg="添加失败！抱歉.";
                }
            %>
            <a id="gotoMainJsp" href="<%=url%>" onchange="disappear()" onclick="showA()"><%=msg%></a>
        </center>

    </div>

<script>
    function disappear(){
        document.getElementById("addNewDriverForm").style.display="none";
        document.getElementById("gotoMainJsp").innerText="";
    }
    function showA(){
        document.getElementById("addNewDriverForm").style.display="block";
        document.getElementById("gotoMainJsp").innerText="";
    }
</script>
