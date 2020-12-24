<%@ page import="java.util.List" %>
<%@ page import="vo.administratorVo.Hotel" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@include file="management.jsp"%>
<%
    if(admin==null){
        out.write("<h1 id='notFound' style=\"margin-left:40%;\">this page is not found!</h1>");
        return;
    }
    List<Hotel> hotelList=null;
    Object list=request.getAttribute("hotelList");
    if(list instanceof List){
        hotelList=(List<Hotel>)list;
%>
<div class="mid-right" id="mid-right-showHotel">
    <span>您的位置为：<a href="${pageContext.request.contextPath}/jsp/administratorJsp/management.jsp">首页<img src="${pageContext.request.contextPath }/image/navigate-outline.svg" width="30" height="30"></a>>>查找酒店</span>
    <center>
        请输入您要查询的酒店名称：<input id="hotelName" type="text"><a id="doSearch" href="#" onclick="doSearch()">确定查询</a><a href="#" onclick="">查看所有酒店</a>
        <table id="show-hotel-table" border="1">
            <tr style="height: 30px;"><th>酒店ID</th><th>酒店名称</th><th>酒店地址</th><th>联系电话</th><th>可用房间</th><td>操作</td></tr>
            <%
                for(int i=0;i<hotelList.size();i++){
            %>
            <tr id="" style="height: 30px;"><td><%=hotelList.get(i).getHotel_id()%></td><td><%=hotelList.get(i).getHotel_name()%></td>
                <td><%=hotelList.get(i).getAddress()%></td><td><%=hotelList.get(i).getTel()%></td>
                <td><%=hotelList.get(i).getRooms()%></td><td><a href="${pageContext.request.contextPath}/jsp/administratorJsp/deleteHotel.jsp">解约</a></td></tr>
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
            var hotelName=document.getElementById("hotelName").value;
            if(hotelName===''){
                alert("请输入有效ID");
                return;
            }
            var url="${pageContext.request.contextPath}/administrator/doWithHotel?method=showOneHotel&hotelName="+hotelName;
            var a=document.getElementById("doSearch");
            a.href=url;
        }
        else{
            alert("请先登录！");
        }
    }
</script>
