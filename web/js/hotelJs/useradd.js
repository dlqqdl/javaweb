var confId = null;
var confName = null;
var sex=null;
//var tel = null;
var startTime = null;
var endTime = null;
var addBtn = null;
var backBtn = null;


$(function(){
	confId = $("#confId");
	confName = $("#confName");
	sex=$("#sex");
	//tel = $("#tel");
	startTime = $("#startTime");
	endTime = $("#endTime");
	addBtn = $("#add");
	backBtn = $("#back");
	//初始化的时候，要把所有的提示信息变为：* 以提示必填项，更灵活，不要写在页面上
	confId.next().html("*");
	confName.next().html("*");
	sex.next().html("*");
//	tel.next().html("*");
	startTime.next().html("*");
	endTime.next().html("*");
	
	// $.ajax({
	// 	type:"GET",//请求类型
	// 	url:path+"/jsp/user.do",//请求的url
	// 	data:{method:"getrolelist"},//请求参数
	// 	dataType:"json",//ajax接口（请求url）返回的数据类型
	// 	success:function(data){//data：返回数据（json对象）
	// 		if(data != null){
	// 			userRole.html("");
	// 			var options = "<option value=\"0\">请选择</option>";
	// 			for(var i = 0; i < data.length; i++){
	// 				//alert(data[i].id);
	// 				//alert(data[i].roleName);
	// 				options += "<option value=\""+data[i].id+"\">"+data[i].roleName+"</option>";
	// 			}
	// 			userRole.html(options);
	// 		}
	// 	},
	// 	error:function(data){//当访问时候，404，500 等非200的错误状态码
	// 		validateTip(userRole.next(),{"color":"red"},imgNo+" 获取用户角色列表error",false);
	// 	}
	// });
	
	
	
	/*
	 * 验证
	 * 失焦\获焦
	 * jquery的方法传递
	 */
	confId.bind("blur",function(){
		//ajax后台验证--userCode是否已存在
		//user.do?method=ucexist&userCode=**
		$.ajax({
			type:"GET",//请求类型
			url:path+"/jsp/user.do",//请求的url
			data:{method:"idExist",confId:confId.val()},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				if(data.confId == "exist"){//账号已存在，错误提示
					validateTip(confId.next(),{"color":"red"},imgNo+ " 该ID已存在",false);
				}else if(data.confId == "void"){//ID为空
					validateTip(confId.next(),{"color":"red"},imgNo+" ID不能为空",false);
				}else if(data.confId=="right"){//账号可用，正确提示
					validateTip(confId.next(),{"color":"green"},imgYes+" 该ID可以创建",true);
				}
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				validateTip(confId.next(),{"color":"red"},imgNo+" 您访问的页面不存在",false);
			}
		});
	}).bind("focus",function(){
		//显示友情提示
		validateTip(confId.next(),{"color":"#666666"},"* 用户编码是您注册系统的账号",false);
	}).focus();
	
	// userName.bind("focus",function(){
	// 	validateTip(userName.next(),{"color":"#666666"},"* 用户名长度必须是大于1小于10的字符",false);
	// }).bind("blur",function(){
	// 	if(userName.val() != null && userName.val().length > 1
	// 			&& userName.val().length < 10){
	// 		validateTip(userName.next(),{"color":"green"},imgYes,true);
	// 	}else{
	// 		validateTip(userName.next(),{"color":"red"},imgNo+" 用户名输入的不符合规范，请重新输入",false);
	// 	}
	//
	// });
	
	// userPassword.bind("focus",function(){
	// 	validateTip(userPassword.next(),{"color":"#666666"},"* 密码长度必须是大于6小于20",false);
	// }).bind("blur",function(){
	// 	if(userPassword.val() != null && userPassword.val().length > 6
	// 			&& userPassword.val().length < 20 ){
	// 		validateTip(userPassword.next(),{"color":"green"},imgYes,true);
	// 	}else{
	// 		validateTip(userPassword.next(),{"color":"red"},imgNo + " 密码输入不符合规范，请重新输入",false);
	// 	}
	// });
	
	// ruserPassword.bind("focus",function(){
	// 	validateTip(ruserPassword.next(),{"color":"#666666"},"* 请输入与上面一只的密码",false);
	// }).bind("blur",function(){
	// 	if(ruserPassword.val() != null && ruserPassword.val().length > 6
	// 			&& ruserPassword.val().length < 20 && userPassword.val() == ruserPassword.val()){
	// 		validateTip(ruserPassword.next(),{"color":"green"},imgYes,true);
	// 	}else{
	// 		validateTip(ruserPassword.next(),{"color":"red"},imgNo + " 两次密码输入不一致，请重新输入",false);
	// 	}
	// });
	
	
	startTime.bind("focus",function(){
		validateTip(startTime.next(),{"color":"#666666"},"* 点击输入框，选择日期",false);
	}).bind("blur",function(){
		if(startTime.val() != null && startTime.val() != ""){
			validateTip(startTime.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(startTime.next(),{"color":"red"},imgNo + " 选择的日期不正确,请重新输入",false);
		}
	});
	endTime.bind("focus",function(){
		validateTip(endTime.next(),{"color":"#666666"},"* 点击输入框，选择日期",false);
	}).bind("blur",function(){
		if(endTime.val() != null && endTime.val() != ""){
			validateTip(endTime.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(endTime.next(),{"color":"red"},imgNo + " 选择的日期不正确,请重新输入",false);
		}
	});
	
	// tel.bind("focus",function(){
	// 	validateTip(phone.next(),{"color":"#666666"},"* 请输入手机号",false);
	// }).bind("blur",function(){
	// 	var patrn=/^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
	// 	if(tel.val().match(patrn)){
	// 		validateTip(tel.next(),{"color":"green"},imgYes,true);
	// 	}else{
	// 		validateTip(tel.next(),{"color":"red"},imgNo + " 您输入的手机号格式不正确",false);
	// 	}
	// });
	
	// userRole.bind("focus",function(){
	// 	validateTip(userRole.next(),{"color":"#666666"},"* 请选择用户角色",false);
	// }).bind("blur",function(){
	// 	if(userRole.val() != null && userRole.val() > 0){
	// 		validateTip(userRole.next(),{"color":"green"},imgYes,true);
	// 	}else{
	// 		validateTip(userRole.next(),{"color":"red"},imgNo + " 请重新选择用户角色",false);
	// 	}
	// });
	//
	addBtn.bind("click",function(){
		if(confId.attr("validateStatus") != "true"){
			confId.blur();
		}
		else if(startTime.attr("validateStatus") != "true"){
			startTime.blur();
		}
		// else if(phone.attr("validateStatus") != "true"){
		// 	phone.blur();
		// }
		else if(endTime.attr("validateStatus") != "true"){
			endTime.blur();
		}else{
			if(confirm("是否确认提交数据")){
				$("#addLiving").submit();
			}
		}
	});
	
	backBtn.on("click",function(){
		if(referer != undefined
			&& null != referer
			&& "" !== referer
			&& "null" != referer
			&& referer.length > 4){
		 window.location.href = referer;
		}else{
			history.back(-1);
		}
	});
});