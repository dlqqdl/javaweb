<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/hotelJsp/jsp/common/head.jsp"%>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>住宿管理页面 >> 入住添加页面</span>
        </div>
        <div class="providerAdd">
            <form id="addLiving" name="addLiving" method="post" action="${pageContext.request.contextPath}/jsp/user.do">
				<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="info">${message}</div>
                <div>
                    <label for="confId">与会者ID：</label>
                    <input type="text" name="confId" id="confId" value="">
					<!-- 放置提示信息 -->
					<font color="red"></font>
                </div>
                <div>
                    <label for="confName">姓名：</label>
                    <input type="text" name="confName" id="confName" value="">
					<font color="red"></font>
                </div>
<%--                <div>--%>
<%--                    <label for="userPassword">用户密码：</label>--%>
<%--                    <input type="password" name="userPassword" id="userPassword" value=""> --%>
<%--					<font color="red"></font>--%>
<%--                </div>--%>
<%--                <div>--%>
<%--                    <label for="ruserPassword">确认密码：</label>--%>
<%--                    <input type="password" name="ruserPassword" id="ruserPassword" value=""> --%>
<%--					<font color="red"></font>--%>
<%--                </div>--%>
                <div>
                    <label >性别：</label>
					<select name="sex" id="sex">
					    <option value="男" selected="selected">男</option>
					    <option value="女">女</option>
					 </select>
                </div>
                <div>
                    <label for="startTime">入住时间：</label>
                    <input type="text" Class="Wdate" id="startTime" name="startTime"
					readonly="readonly" onclick="WdatePicker();">
					<font color="red"></font>
                </div>
                <div>
                    <label for="endTime">离开时间：</label>
                    <input type="text" Class="Wdate" id="endTime" name="endTime"
                           readonly="readonly" onclick="WdatePicker();">
                    <font color="red"></font>
                </div>
                <div>
                    <label for="roomId">房间号：</label>
                    <input type="text" name="roomId" id="roomId" value="">
                    <font color="red"></font>
                </div>
                <div>
                    <label for="tel">用户电话：</label>
                    <input type="text" name="tel" id="tel" value="">
					<font color="red"></font>
                </div>
                <div>
                <label for="request">住宿要求：</label>
                <input name="request" id="request"  value="">
                </div>
                <div>
                    <label for="response">酒店答复：</label>
                    <input name="response" id="response"  value="">
                </div>
<%--                <div>--%>
<%--                    <label for="address">用户地址：</label>--%>
<%--                   <input name="address" id="address"  value="">--%>
<%--                </div>--%>
<%--                <div>--%>
<%--                    <label >用户角色：</label>--%>
<%--                    <!-- 列出所有的角色分类 -->--%>
<%--					<select name="userRole" id="userRole"></select>--%>
<%--	        		<font color="red"></font>--%>
<%--                </div>--%>
                <div class="providerAddBtn">
                    <input type="button" name="add" id="add" value="保存" >
					<input type="button" id="back" name="back" value="返回" >
                </div>
            </form>
        </div>
</div>
</section>
<%@include file="/jsp/hotelJsp/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/hotelJs/useradd.js"></script>
