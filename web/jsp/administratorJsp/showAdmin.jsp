<%@ page import="java.util.List" %>
<%@ page import="vo.administratorVo.Admin" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@include file="management.jsp"%>
<%
    if(admin==null){
        out.write("<h1 id='notFound' style=\"margin-left:40%;\">this page is not found!</h1>");
        return;
    }
    List<Admin> adminList=null;
    Object list=request.getAttribute("adminList");
    if(list instanceof List){
        adminList=(List<Admin>)list;
%>
<div class="mid-right" id="mid-right-showHotel">
    <span>您的位置为：<a href="${pageContext.request.contextPath}/jsp/administratorJsp/management.jsp">首页<img src="${pageContext.request.contextPath }/image/navigate-outline.svg" width="30" height="30"></a>>>查看管理员</span>
    <center>
        请输入您要查询的管理员ID：<input id="adminId" type="text" required /><a id="doSearch" href="#" onclick="doSearch()">确定查询</a><a href="#" onclick="">查看所有酒店</a>
        <table id="show-hotel-table" border="1">
            <tr style="height: 30px;"><th>管理员ID</th><th>管理员名字</th><th>联系电话</th></tr>
            <%
                for(int i=0;i<adminList.size();i++){
            %>
            <tr id="" style="height: 30px;"><td><%=adminList.get(i).getAdmin_id()%></td><td><%=adminList.get(i).getAdmin_name()%></td>
                <td><%=adminList.get(i).getTelephone()%></td></tr>
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
            var adminId=document.getElementById("adminId").value;
            for(var i in adminId){
                if(adminId[i]>'9'||adminId[i]<'0'){
                    alert("请输入有效ID");
                    return;
                }
            }
            if(adminId===''){
                alert("请输入有效ID");
                return;
            }
            var url="${pageContext.request.contextPath}/administrator/doWithAdmin?method=showAdmin&adminId="+adminId;
            var a=document.getElementById("doSearch");
            a.href=url;
        }
        else{
            alert("请先登录！");
        }
    }
</script>
