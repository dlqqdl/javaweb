<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/hotelJsp/jsp/common/head.jsp"%>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>住宿管理页面 >> 住宿信息修改页面</span>
        </div>
        <div class="providerAdd providerView">
        <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath}/jsp/user.do">
			<input type="hidden" name="method" value="modifyLiving">
			<input type="hidden" name="confId" value="${living.confId}"/>
			 <div>
                 <p><strong>名称：</strong><span style="color: black">${living.confereeName}</span></p>
					<font color="red"></font>
             </div>
			 <div>
                 <p><strong>性别：</strong>
                     <span style="color: black">
            		    <c:if test="${living.sex eq '男'}">男</c:if>
					    <c:if test="${living.sex eq '女'}">女</c:if>
				    </span>
                 </p>
             </div>
            <div>
                <p><strong>电话：</strong><span style="color: black">${living.tel}</span></p>
            </div>
            <div>
                <label for="roomId"><strong>房间号：</strong></label>
                <input type="text" name="roomId" id="roomId" value="${living.roomId}">
            </div>
			 <div>
                    <label for="startTime"><strong>入住时间：</strong></label>
                    <input type="text" Class="Wdate" id="startTime" name="startTime" value="${living.startTime}"
					readonly="readonly" onclick="WdatePicker();">
                    <font color="red"></font>
             </div>
            <div>
                <label for="endTime"><strong>离开时间：</strong></label>
                <input type="text" Class="Wdate" id="endTime" name="endTime" value="${living.endTime}"
                       readonly="readonly" onclick="WdatePicker();">
                <font color="red"></font>
            </div>
            <div>
                <p><strong>客户要求：</strong><span style="color: black">${living.request}</span></p>
            </div>
            <div>
                <label for="response"><strong>酒店答复：</strong></label>
                <input type="text" name="response" id="response" value="${living.response}">
            </div>
<%--				<div>--%>
<%--                    <label >用户角色：</label>--%>
<%--                    <!-- 列出所有的角色分类 -->--%>
<%--					<input type="hidden" value="${user.userRole}" id="rid" />--%>
<%--					<select name="userRole" id="userRole"></select>--%>
<%--        			<font color="red"></font>--%>
<%--                </div>--%>
			 <div class="providerAddBtn">
                    <input type="button" name="save" id="save" value="保存" />
                    <input type="button" id="back" name="back" value="返回"/>
                </div>
            </form>
        </div>
    </div>
</section>
<%@include file="/jsp/hotelJsp/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/hotelJs/usermodify.js"></script>
