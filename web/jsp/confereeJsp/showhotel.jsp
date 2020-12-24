<%@ page import="vo.confereeVo.Hotel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>会议管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/confereePublic.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/confereeStyle.css"/>
</head>
<body>
<%@include file="head.jsp"%>>
<!--主体内容-->
<section class="publicMian ">
    <%@include file="adminleft.jsp"%>>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>酒店信息页面</span>
        </div>

        <!--用户-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">酒店名称</th>
                <th width="20%">酒店地址</th>
                <th width="20%">酒店电话</th>
                <th width="20%">预定状态</th>
                <th width="30%">操作</th>
            </tr>
            <%
                Hotel hotel=new Hotel();
//                List<Hotel> hotelList=new LinkedList<>();
                hotel =(Hotel)request.getAttribute("hotel");
                session.setAttribute("Hotel",hotel);
                if (hotel==null){
            %>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td>当前未预定酒店</td>
                <td></td>
            </tr>
            <%
                }else {
            %>
            <tr>
                <td>${hotel.name}</td>
                <td>${hotel.address}</td>
                <td>${hotel.tel}</td>
                <%
                    if (hotel.getFlag()){
                %>
                <td>预定成功！</td>
                <%
                    }else{
                %>
                <td>未回复，请等待！</td>
                <%
                    }
                    }
                %>
                <td>
                    <a href="${pageContext.request.contextPath}/jsp/confereeJsp/HotelView.jsp"><img src="${pageContext.request.contextPath}/image/read.png" alt="查看具体信息" title="查看具体信息"/></a>
                </td>
            </tr>

        </table>

    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<footer class="footer">
</footer>

<script src="${pageContext.request.contextPath}/js/confereeJquery.js"></script>
<script src="${pageContext.request.contextPath}/js/confereeJs.js"></script>
<script src="${pageContext.request.contextPath}/js/confereeTime.js"></script>

</body>
</html>