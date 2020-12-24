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
<div class="mid-right" id="mid-left-deleteHotel">
    <span>您的位置为：<a href="${pageContext.request.contextPath}/jsp/administratorJsp/management.jsp">首页<img src="${pageContext.request.contextPath }/image/navigate-outline.svg" width="30" height="30"></a>>>注销酒店账号</span>
    <center id="center-form">
        <div>
            <h2>解约酒店</h2>
            <form id="deleteForm" action="${pageContext.request.contextPath}/administrator/doWithHotel" method="post">
                <input type="hidden" name="method" value="deleteHotel"/>
                <table border="1">
                    <tr><td class="td-rows">酒 店 ID</td><td><input name="hotel_id" type="text" required /></td></tr>
                    <tr><td class="td-rows">酒 店 名 称</td><td><input name="hotel_name" type="text" required /></td></tr>
                </table>
                <input type="submit" value="提交"/> <input type="reset" value="重填" />
            </form>
            <%
                String url="#";
                String msg="";
                Object deleteHotelResult=request.getAttribute("deleteHotelResult");
                if(deleteHotelResult!=null){
                    if((boolean)deleteHotelResult){//true,修改成功
                        url=request.getContextPath()+"/jsp/administratorJsp/management.jsp";
                        msg="解约成功！返回.";
                    }
                    else
                        msg="解约失败！抱歉.";
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