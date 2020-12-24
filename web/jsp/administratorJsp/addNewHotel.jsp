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
<div class="mid-right" id="mid-left-addNewHotel">
    <span>您的位置为：<a href="${pageContext.request.contextPath}/jsp/administratorJsp/management.jsp">首页<img src="${pageContext.request.contextPath }/image/navigate-outline.svg" width="30" height="30"></a>>>新增酒店</span>
    <center id="center-form">
        <div>
            <h2>添加酒店信息</h2>
            <form id="addNewForm" action="${pageContext.request.contextPath}/administrator/doWithHotel?method=addNewHotel" method="post">
                <table border="1">
                    <tr><td class="td-rows">酒 店 ID</td><td><input name="hotel_id" type="text" required /></td></tr>
                    <tr><td class="td-rows">酒 店 名 称</td><td><input name="names" type="text" required /></td></tr>
                    <tr><td class="td-rows">酒 店 地 址</td><td><input name="address" type="text" required /></td></tr>
                    <tr><td class="td-rows">联 系 电 话</td><td><input name="tel" type="text" required /></td></tr>
                    <tr><td class="td-rows">可 用 房 间</td><td><input name="rooms" type="text" required /></td></tr>
                    <tr><td class="td-rows">默 认 密 码</td><td><input name="password" type="password" value="00000"/></td></tr>
                </table>
                <input type="submit" value="提交" onclick="checkIsOk()"/><input type="reset" value="重填" />
            </form>
            <%
                String url="#";
                String msg="";
                Object addHotelResult=request.getAttribute("addHotelResult");
                if(addHotelResult!=null){
                    if((boolean)addHotelResult){//true,修改成功
                        url=request.getContextPath()+"/jsp/administratorJsp/management.jsp";
                        msg="添加成功！返回.";
                    }
                    else
                        msg="添加失败！抱歉.";
                }
            %>
            <a id="gotoMainJsp" href="<%=url%>" onchange="disappear()" onclick="show()"><%=msg%></a>
        </div>
    </center>
</div>
<script>
    function disappear(){
        document.getElementById("addNewForm").style.display="none";
        document.getElementById("gotoMainJsp").innerText="";
    }
    function show(){
        document.getElementById("addNewForm").style.display="block";
        document.getElementById("gotoMainJsp").innerText="";
    }
</script>