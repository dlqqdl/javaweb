<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/hotelJsp/jsp/common/head.jsp"%>
 <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>信息查看页面</span>
        </div>
        <div class="providerView">
            <p><strong>与会者ID：</strong><span>${living.confId}</span></p>
            <p><strong>名称：</strong><span>${living.confereeName}</span></p>
            <p><strong>性别：</strong>
            	<span>
            		<c:if test="${living.sex == '男'}">男</c:if>
					<c:if test="${living.sex == '女'}">女</c:if>
				</span>
			</p>
            <c:if test="${living.roomId != 0}">
                <p><strong>房间号：</strong><span>${living.roomId}</span></p>
            </c:if>
            <p><strong>电话：</strong><span>${living.tel}</span></p>
            <p><strong>入住时间：</strong><span>${living.startTime}</span></p>
            <p><strong>离开时间：</strong><span>${living.endTime}</span></p>
            <p><strong>客户要求：</strong><span>${living.request}</span></p>
            <c:if test="${not empty living.response}">
                <p><strong>酒店答复：</strong><span>${living.response}</span></p>
            </c:if>
			<div class="providerAddBtn">
            	<input type="button" id="back" name="back" value="返回" >
            </div>
        </div>
    </div>
</section>
<%@include file="/jsp/hotelJsp/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/hotelJs/userview.js"></script>