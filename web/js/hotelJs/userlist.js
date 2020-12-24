var livingObj;

//用户管理页面上点击删除按钮弹出删除框(userlist.jsp)
function deleteLiving(obj){
	$.ajax({
		type:"GET",
		url:path+"/jsp/user.do",
		data:{method:"deleteLiving",confId:obj.attr("confId"),flag:obj.attr("flag")},
		dataType:"json",
		success:function(data){
			if(data.deleteResult === "true"){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
			}else if(data.deleteResult === "false"){//删除失败
				//alert("对不起，删除用户【"+obj.attr("username")+"】失败");
				changeDLGContent("对不起，删除用户【"+obj.attr("confName")+"】失败");
			}
			// else if(data.deleteResult == "notexist"){
			// 	//alert("对不起，用户【"+obj.attr("username")+"】不存在");
			// 	changeDLGContent("对不起，用户【"+obj.attr("username")+"】不存在");
			// }
		},
		error:function(data){
			//alert("对不起，删除失败");
			changeDLGContent("对不起，删除失败");
		}
	});
}

function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeUse').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeUse').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}

$(function(){
	//通过jquery的class选择器（数组）
	//对每个class为viewUser的元素进行动作绑定（click）
	/**
	 * bind、live、delegate
	 * on
	 */
	$(".viewLiving").on("click",function(){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
		var obj = $(this);
		window.location.href=path+"/jsp/user.do?method=viewLiving&confId="+ obj.attr("confId");
	});

	$(".modifyLiving").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/jsp/user.do?method=findLiving&confId="+ obj.attr("confId");
	});
	$(".allocateLiving").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/jsp/user.do?method=findLiving2&confId="+ obj.attr("confId");
	});

	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deleteLiving(livingObj);
	});

	$(".deleteLiving").on("click",function(){
		livingObj = $(this);
		changeDLGContent("你确定要删除用户【"+livingObj.attr("confName")+"】吗？");
		openYesOrNoDLG();
	});
});