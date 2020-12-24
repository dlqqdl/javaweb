<%@ page import="java.util.List" %>
<%@ page import="vo.administratorVo.Conferee" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@include file="management.jsp"%>
<%
    if(admin==null){
        out.write("<h1 id='notFound' style=\"margin-left:40%;\">this page is not found!</h1>");
        return;
    }
    List<Conferee> confereeList=null;
    Object list=request.getAttribute("confereeList");
    if(list!=null&&(list instanceof List)){
        confereeList=(List<Conferee>)list;
%>
<div class="mid-right" id="mid-right-showConferee">
    <span>您的位置为：<a href="${pageContext.request.contextPath}/jsp/administratorJsp/management.jsp">首页<img src="${pageContext.request.contextPath }/image/navigate-outline.svg" width="30" height="30"></a>>>查找参会者</span>
    <center>
        请输入您要查询的与会人员ID：<input id="confereeId" type="text" required /><a id="doSearch" href="#" onclick="doSearch()">确定查询</a>
        <table id="show-conferee-table" border="1">
            <tr style="line-height: 10px;height: 10px"><th>ID</th><th>名称</th><th>账号</th><th>登录密码</th><th>联系电话</th><th>性别</th><th>email</th><th>操作</th></tr>
            <%
                for(int i=0;i<confereeList.size();i++){
            %>
            <tr id="" style="height: 30px;"><td><%=confereeList.get(i).getConf_id()%></td><td><%=confereeList.get(i).getConf_name()%></td>
                <td><%=confereeList.get(i).getAccount()%></td><td><%=confereeList.get(i).getPassword()%></td>
                <td><%=confereeList.get(i).getTel()%></td><td><%=confereeList.get(i).getSex()%></td>
                <td><%=confereeList.get(i).getEmail()%></td><td><a href="${pageContext.request.contextPath}/jsp/administratorJsp/deleteConferee.jsp">注销</a></td></tr>
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
            var confereeId=document.getElementById("confereeId").value;
            for(var i in confereeId){
                if(confereeId[i]>'9'||confereeId[i]<'0'){
                    alert("请输入有效ID");
                    return;
                }
            }
            if(confereeId===''){
                alert("请输入有效ID");
                return;
            }
            var url="${pageContext.request.contextPath}/administrator/doWithUser?method=showUser&confereeId="+confereeId;
            var a=document.getElementById("doSearch");
            a.href=url;
        }
        else{
            alert("请先登录！");
        }
    }
</script>
