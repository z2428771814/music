$(function(){
	findByAll();
});

function findByAll() {
	$.get("../../../admin/findAll", null, function(data){
		var str = "";
		$.each(data, function(index, item) {
			str += "<tr><td>"+item.aid+"</td><td>"+item.aname+"</td><td>"+item.email+"</td><td><a href='javascript:resetPwd("+item.aid+")'>[阵亡]</a></td></tr>";
		});
		$("#admin_info").html("").append($(str));
	},"json");
}

//function createTable(data,  )

function addNewsTypeInfo(){
	var aname=$.trim( $("#aname").val() );
	var pwd=$.trim( $("#pwd").val() );
	var email=$.trim( $("#email").val() );
	
	if (aname == "") {
		alert("请输入都统姓名...");
		return;
	}
	
	if (pwd == "") {
		alert("请输入都统密码...");
		return;
	}
	
	if (email == "") {
		alert("请输入都统号码...");
		return;
	}
	
	$.post("../../../admin/add", {aname:aname, pwd:pwd, email:email}, function(data){
		data = parseInt($.trim(data));
		if (data > 0) {
			alert("恭喜元帅旗下新增一名都统");
			$("#myform")[0].reset();
			findByAll();
		} else {
			alert("管理员信息添加失败，请稍后重试...");
		}
	},"text");
}

function resetPwd(aid) {
	$.post("../../../admin/deleAid", {aid:aid}, function(data){
		data = parseInt($.trim(data));
		if (data > 0) {
			alert("看来这位都统承受不了压力，已经离去了。。。。");
			findByAll();
		} else {
			alert("请查看都统阵亡手册。。。。");
		}
	},"text");
}