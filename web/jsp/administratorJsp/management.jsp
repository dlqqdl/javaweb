<%@ page import="vo.administratorVo.Admin" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
  <link href="${pageContext.request.contextPath }/css/management.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/css/showTable.css" rel="stylesheet">
  <script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/common.js"></script>
  <title>meeting-master</title>
</head>
<body onload="initAJAX()">
<div id="top"><!--上方-->
  <div id="top-left">
    <p id="para-1">欢迎使用会议系统后台管理</p>
  </div>
  <div id="top-right">
    <%
      Object result= session.getAttribute("loginResult");
      String text="您未登录 <img src=\""+request.getContextPath()+"/image/close-circle-outline.svg\" width=\"20\" height=\"20\">";
      String loginUrlText=request.getContextPath()+"/jsp/administratorJsp/login.jsp";
      Admin admin=null;
      if(result!=null){
        boolean res= (boolean)result;
        if(res){
          Object admin_tab=session.getAttribute("admin");
          if(admin_tab instanceof Admin){
            admin=(Admin) admin_tab;
            text="您好!"+admin.getAdmin_name()+"<img src=\""+request.getContextPath()+"/image/checkbox-outline.svg\" width=\"20\" height=\"20\">";
            loginUrlText="#";
      }
      }
      }
      %>
    <a id="login" href="<%=loginUrlText%>"><%=text%></a>
  </div>
</div><hr/>
  <div id="mid-left">
    <ul id="mid-left-1"><a href="#" class="head-a">我的资料 <img src="${pageContext.request.contextPath }/image/person-sharp.svg" width="20" height="20"></a>
      <li><a id="show-admin-a" href="#" class="left-1"onclick="couldShowAllAdmin()">所有管理员</a></li>
      <li><a id="modifyPass-a" href="#" class="left-1" onclick="couldModifyPassword()">修 改 密 码</a></li>
      <li><a id="logout" href="#" class="left-1" onclick="couldLogout()">退  出</a></li></ul>
    <ul id="mid-left-2"><a href="#" class="head-a">酒店合作 <img src="${pageContext.request.contextPath }/image/home-outline.svg" width="20" height="20"></a>
      <li><a id="showHotel-a" href="#" class="left-2" onclick="couldShowAllHotel()">已 有 合 作</a></li>
      <li><a id="addNewHotel-a" href="#" class="left-2" onclick="couldAddNewHotel()">新 建 合 作</a></li>
      <li><a id="deleteHotel-a" href="#" class="left-2" onclick="couldDeleteHotel()">解 除 合 作</a></li></ul>
    <ul id="mid-left-3"><a href="#" class="head-a">司机管理 <img src="${pageContext.request.contextPath }/image/car-outline.svg" width="20" height="20"></a>
      <li><a id="show-driver-a" href="#" class="left-3" onclick="couldShowAllDriver()">已 雇 司 机</a></li>
      <li><a id="deleteDriver-a" href="#" class="left-3" onclick="couldDeleteDriver()">解 雇 司 机</a></li>
      <li><a id="addNewDriver-a" href="#" class="left-3" onclick="couldAddNewDriver()">雇 佣 司 机</a></li></ul>
    <ul id="mid-left-4"><a href="#" class="head-a">组织者们 <img src="${pageContext.request.contextPath }/image/person-sharp.svg" width="20" height="20"></a>
      <li><a id="show-organizer-a" href="#" class="left-4" onclick="couldShowOrganizer()" >查找组织者</a></li>
      <li><a id="deleteOrganizer-a" href="#" class="left-4" onclick="couldDeleteOrganizer()">注销组织者</a></li></ul>
    <ul id="mid-left-5"><a href="#" class="head-a">用户管理 <img src="${pageContext.request.contextPath }/image/people-outline.svg" width="20" height="20"></a>
      <li><a id="show-conferee-a" href="#" class="left-5" onclick="couldShowAllConferee()">查 看 用 户</a></li>
      <li><a id="deleteConferee-a" href="#" class="left-5" onclick="couldDeleteConferee()">注 销 用 户</a></li>
    </ul>
    <ul id="mid-left-6"><a href="#" class="head-a">关于我们 <img src="${pageContext.request.contextPath }/image/alert-circle-outline.svg" width="20" height="20"></a>
      <li><a href="http://www.baidu.com" target="_blank" class="left-6">帮 助 文 档</a></li></ul>
  </div>
</body>
<script language="JavaScript">
  function couldShowAllAdmin(){
    if(<%=admin!=null%>){
      var urlText='${pageContext.request.contextPath}/administrator/doWithAdmin?method=showAllAdmin';
      var a=document.getElementById("show-admin-a");
      a.href=urlText;
    }
    else {
      alert("请先登录！");
    }
  }
  function couldModifyPassword(){
    if(<%=admin!=null%>){
      var urlText='${pageContext.request.contextPath}/jsp/administratorJsp/dealModify.jsp';
      var a=document.getElementById("modifyPass-a");
      a.href=urlText;
    }
    else
      alert("请先登录！");
  }
  function couldAddNewHotel(){
    if(<%=admin!=null%>){
      var urlText='${pageContext.request.contextPath}/jsp/administratorJsp/addNewHotel.jsp';
      var a=document.getElementById("addNewHotel-a");
      a.href=urlText;
    }
    else
      alert("请先登录！");
  }
  function couldAddNewDriver(){
    if(<%=admin!=null%>){
      var urlText='${pageContext.request.contextPath}/jsp/administratorJsp/addNewDriver.jsp';
      var a=document.getElementById("addNewDriver-a");
      a.href=urlText;
    }
    else
      alert("请先登录！");
  }
  function couldShowAllHotel(){
    if(<%=admin!=null%>){
      var urlText='${pageContext.request.contextPath}/administrator/doWithHotel?method=showAllHotel';
      var a=document.getElementById("showHotel-a");
      a.href=urlText;
    }
    else {
      alert("请先登录！");
    }
  }
  function couldDeleteHotel(){
    if(<%=admin!=null%>){
      var urlText='${pageContext.request.contextPath}/jsp/administratorJsp/deleteHotel.jsp';
      var a=document.getElementById("deleteHotel-a");
      a.href=urlText;
    }
    else {
      alert("请先登录！");
    }
  }
  function couldLogout(){
    if(<%=admin!=null%>){
      var urlText='${pageContext.request.contextPath}/administrator/logout';
      var a=document.getElementById("logout");
      a.href=urlText;
    }
    else {
      alert("请先登录！");
    }
  }
  function couldShowAllDriver(){
    if(<%=admin!=null%>){
      var urlText='${pageContext.request.contextPath}/administrator/doWithDriver?method=showAllDriver';
      var a=document.getElementById("show-driver-a");
      a.href=urlText;
    }
    else {
      alert("请先登录！");
    }
  }
  function couldDeleteDriver(){
    if(<%=admin!=null%>){
      var urlText='${pageContext.request.contextPath}/jsp/administratorJsp/deleteDriver.jsp';
      var a=document.getElementById("deleteDriver-a");
      a.href=urlText;
    }
    else {
      alert("请先登录！");
    }
  }
  function couldShowAllConferee(){// 显示所有用户信息
      if(<%=admin!=null%>){
        var urlText='${pageContext.request.contextPath}/administrator/doWithUser?method=showAllUser';
        var a=document.getElementById("show-conferee-a");
        a.href=urlText;
      }
      else {
          alert("请先登录！");
      }
  }
  function couldDeleteConferee(){
    if(<%=admin!=null%>){
      var urlText='${pageContext.request.contextPath}/jsp/administratorJsp/deleteConferee.jsp';
      var a=document.getElementById("deleteConferee-a");
      a.href=urlText;
    }
    else {
      alert("请先登录！");
    }
  }
  function couldShowOrganizer(){
    if(<%=admin!=null%>){
      var urlText='${pageContext.request.contextPath}/administrator/doWithOrganizer?method=showAllOrganizer';
      var a=document.getElementById("show-organizer-a");
      a.href=urlText;
    }
    else {
      alert("请先登录！");
    }
  }
  function couldDeleteOrganizer(){
    if(<%=admin!=null%>){
      var urlText='${pageContext.request.contextPath}/jsp/administratorJsp/deleteOrganizer.jsp';
      var a=document.getElementById("deleteOrganizer-a");
      a.href=urlText;
    }
    else {
      alert("请先登录！");
    }
  }
  function couldShowAllMeeting(){
    if(<%=admin!=null%>){
      var urlText='${pageContext.request.contextPath}/administrator/doWithMeeting?method=showAllMeeting';
      var a=document.getElementById("show-meeting-a");
      a.href=urlText;
    }
    else {
      alert("请先登录！");
    }
  }
  function couldDeleteMeeting(){
    if(<%=admin!=null%>){
      var urlText='${pageContext.request.contextPath}/jsp/administratorJsp/deleteMeeting.jsp';
      var a=document.getElementById("deleteMeeting-a");
      a.href=urlText;
    }
    else {
      alert("请先登录！");
    }
  }
</script>
</html>

