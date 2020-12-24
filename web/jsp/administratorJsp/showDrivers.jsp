<%@ page import="java.util.List" %>
<%@ page import="vo.administratorVo.Driver" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@include file="management.jsp"%>
<%
    if(admin==null){
        out.write("<h1 id='notFound' style=\"margin-left:40%;\">this page is not found!</h1>");
        return;
    }
    List<Driver> driverList=null;
    Object list=request.getAttribute("driverList");
    if(list instanceof List){
        driverList=(List<Driver>)list;
%>
<div class="mid-right" id="mid-right-showDriver">
    <span>您的位置为：<a href="${pageContext.request.contextPath}/jsp/administratorJsp/management.jsp">首页<img src="${pageContext.request.contextPath }/image/navigate-outline.svg" width="30" height="30"></a>>>查找司机</span>
    <center>
        请输入您要查询的司机工号：<input id="driverId" type="text"><a id="doSearch" href="#" onclick="doSearch()">确定查询</a>
        <table id="show-driver-table" border="1">
            <tr style="height: 30px;"><th>司机工号</th><th>司机名称</th><th>联系电话</th><th>登录密码</th><th>操作</th></tr>
            <%
                for(int i=0;i<driverList.size();i++){
            %>
            <tr id="" style="height: 30px;"><td><%=driverList.get(i).getDriver_id()%></td><td><%=driverList.get(i).getName()%></td>
                <td><%=driverList.get(i).getTelephone()%></td><td><%=driverList.get(i).getPassword()%></td>
                <td><a href="${pageContext.request.contextPath}/jsp/administratorJsp/deleteDriver.jsp">解约</a></td></tr>
            <%
                    }
                }
            %>
        </table>
    </center>
</div>
<script>
    function doSearch(){
        if(<%=admin!=null%>){
            var driverId=document.getElementById("driverId").value;
            for(var i in driverId){
                if(driverId[i]>'9'||driverId[i]<'0'){
                    alert("请输入有效ID");
                    return;
                }
            }
            if(driverId===''){
                alert("请输入有效ID");
                return;
            }
            var url="${pageContext.request.contextPath}/administrator/doWithDriver?method=showDriver&driverId="+driverId;
            var a=document.getElementById("doSearch");
            a.href=url;
        }
        else{
            alert("请先登录！");
        }
    }
</script>
