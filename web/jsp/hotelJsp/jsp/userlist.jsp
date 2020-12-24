<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/hotelJsp/jsp/common/head.jsp"%>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>住宿管理页面</span>
            </div>
            <div class="search">
           		<form method="get" action="${pageContext.request.contextPath}/jsp/user.do">
					<input name="method" value="query" class="input-text" type="hidden">
					 <span>用户名：</span>
					 <input name="queryname" class="input-text"	type="text" value="${queryName}">

<%--					 <span>用户角色：</span>--%>
<%--					 <select name="queryUserRole">--%>
<%--						<c:if test="${roleList != null}">--%>
<%--						   <option value="0">--请选择--</option>--%>
<%--						   <c:forEach var="role" items="${roleList}">--%>
<%--						   		<option <c:if test="${role.id == queryUserRole}">selected="selected"</c:if>--%>
<%--						   		value="${role.id}">${role.roleName}</option>--%>
<%--						   </c:forEach>--%>
<%--						</c:if>--%>
<%--	        		</select>--%>

					 <input type="hidden" name="pageIndex" value="1"/>
					 <input	value="查 询" type="submit" id="searchbutton">
					<span >
            		    <c:if test="${numOfRoom<100}"><span style="color: red;font-size:15px">当前剩余房间数：${numOfRoom}</span></c:if>
					    <c:if test="${numOfRoom>=100}"><span style="color: green;font-size:15px">当前剩余房间数：${numOfRoom}</c:if>
				    </span>
					 <a href="${pageContext.request.contextPath}/jsp/hotelJsp/jsp/useradd.jsp" >添加用户</a>
				</form>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">与会者ID</th>
                    <th width="5%">名称</th>
                    <th width="5%">性别</th>
                    <th width="5%">房间号</th>
					<th width="15%">电话</th>
                    <th width="10%">入住时间</th>
					<th width="10%">离开时间</th>
					<th width="10%">客户要求</th>
					<th width="10%">答复</th>
                    <th width="20%">操作</th>
                </tr>
                   <c:forEach var="living" items="${livingList}" varStatus="status">
					<tr>
						<td>
							<span>${living.confId}</span>
						</td>
						<td>
							<span>${living.confereeName}</span>
						</td>
						<td>
							<span>${living.sex}</span>
						</td>
						<td>
							<span>${living.roomId}</span>
						</td>
						<td>
							<span>${living.tel}</span>
						</td>
						<td>
						 	<span>${living.startTime}</span>
						</td>
						<td>
							<span>${living.endTime}</span>
						</td>
						<td>
							<span>${living.request}</span>
						</td>
						<td>
							<span>${living.response}</span>
						</td>
						<td>
						<span><a class="viewLiving" href="javascript:;" confId=${living.confId} confName=${living.confereeName}><img src="${pageContext.request.contextPath}/image/read.png" alt="查看" title="查看"/></a></span>
						<span><a class="modifyLiving" href="javascript:;" confId=${living.confId} confName=${living.confereeName}><img src="${pageContext.request.contextPath}/image/xiugai.png" alt="修改" title="修改"/></a></span>
						<span><a class="deleteLiving" href="javascript:;" confId=${living.confId} confName=${living.confereeName} flag=${living.flag}><img src="${pageContext.request.contextPath}/image/schu.png" alt="删除" title="删除"/></a></span>
						</td>
					</tr>
				</c:forEach>
			</table>
			<input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
		  	<c:import url="rollpage.jsp">
	          	<c:param name="totalCount" value="${totalCount}"/>
	          	<c:param name="currentPage" value="${currentPage}"/>
	          	<c:param name="totalPageCount" value="${totalPageCount}"/>
          	</c:import>
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

<%@include file="/jsp/hotelJsp/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/hotelJs/userlist.js"></script>
