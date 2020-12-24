<%@ page import="java.util.List" %>
<%@ page import="vo.administratorVo.Organizer" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@include file="management.jsp"%>
<%
    if(admin==null){
        out.write("<h1 id='notFound' style=\"margin-left:40%;\">this page is not found!</h1>");
        return;
    }
    List<Organizer> organizerList=null;
    Object list=request.getAttribute("organizerList");
    if(list instanceof List){
        organizerList=(List<Organizer>)list;
%>
<div class="mid-right" id="mid-right-showHotel">
    <span>您的位置为：<a href="${pageContext.request.contextPath}/jsp/administratorJsp/management.jsp">首页<img src="${pageContext.request.contextPath }/image/navigate-outline.svg" width="30" height="30"></a>>>查找组织者</span>
    <center>
        请输入您要查询的组织者ID：<input id="organizerId" type="text"><a id="doSearch" href="#" onclick="doSearch()">确定查询</a><a href="#" onclick="">查看所有酒店</a>
        <table id="show-organizer-table" border="1">
            <tr style="height: 30px;"><th>用户ID</th><th>用户名字</th><th>联系电话</th><th>用户密码</th><th>操作</th></tr>
            <%
                for(int i=0;i<organizerList.size();i++){
            %>
            <tr id="" style="height: 30px;"><td><%=organizerList.get(i).getOrgan_id()%></td><td><%=organizerList.get(i).getOrgan_name()%></td>
                <td><%=organizerList.get(i).getTelephone()%></td><td><%=organizerList.get(i).getPassword()%></td>
                <td><a href="${pageContext.request.contextPath}/jsp/administratorJsp/deleteOrganizer.jsp">注销</a></td></tr>
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
            var organizerId=document.getElementById("organizerId").value;
            for(var i in organizerId){
                if(organizerId[i]>'9'||organizerId[i]<'0'){
                    alert("请输入有效ID");
                    return;
                }
            }
            if(organizerId===''){
                alert("请输入有效ID");
                return;
            }
            var url="${pageContext.request.contextPath}/administrator/doWithOrganizer?method=showOrganizer&organizerId="+organizerId;
            var a=document.getElementById("doSearch");
            a.href=url;
        }
        else{
            alert("请先登录！");
        }
    }
</script>
