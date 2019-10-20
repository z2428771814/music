// JavaScript Document

//获取元素
var  $uname = $("#uname");
//输出到控制台
console.log($uname);

//用户名验证
//失去焦点事件
$("#uname").blur (function(){
	//获取用户输入的用户名
	var uname = $("#uname").val();
	console.log(uname);
	//判断用户名的格式
	if(uname == '' ){
		console.log("用户不能为空");
		//给当前对象的下一个标签设值
		$(this).next().html("用户不能为空");
		//未设值前该标签是隐藏的  此时就必须显示来
		$(this).next().show();
	}
	//正则表达式
	//创建一个规则
	var reg = /^[\u4400-\u9fa5\w]{2,15}$/;
	//判断
	/*
	var flag = reg.test(nickname);
	console.log(flag);
	*/
	console.log("我的账号为"+uname);
	if( !reg.test(uname) ){
		//给当前对象的下一个标签设值
		$(this).next().html("用户名必须是6-15位的英文或数字");
		//未设值前该标签是隐藏的  此时就必须显示来
		$(this).next().show();
	}
});

//聚焦事件
$("#uname").focus(function(){
	//隐藏
	$(this).next().hide();
})


//密码验证	
//失焦事件
$("#pwd").blur(function(){
	check_pwd();	
});

//聚焦事件
$("#pwd").focus(function(){
	$(this).next().hide();
});
	
function check_pwd(){
	//获取密码
	var pwd = $("#pwd").val();
	//规则
	var reg = /^[\w@!#$%^&*~]{6,15}$/;
	//判断
	if(!reg.test(pwd)){
		$("#pwd").next().html("密码不符合规范");
		$("#pwd").next().show();
	}
}

//确认密码验证
//失焦事件
$("#cpwd").blur(function(){
	check_cpwd();	
});

//聚焦事件
$("#cpwd").focus(function(){
	$(this).next().hide();
});
	
function check_cpwd(){
	//获取原密码
	var pwd = $("#pwd").val();
	//获取再次输入的密码
	var cpwd = $("#cpwd").val();
	
	//判断
	if(cpwd == ''){
		$("#cpwd").next().html("确认密码不能为空");
		$("#cpwd").next().show();
	}
	if(cpwd != pwd){
		$("#cpwd").next().html("两次输入的密码不一致");
		$("#cpwd").next().show();
	}
}

//手机号码验证
//失焦事件
$("#tel").blur(function(){
	check_tel();	
});

//聚焦事件
$("#tel").focus(function(){
	$("#tel").next().next().hide();
});


//聚焦事件
$("#email").blur(function(){
	var reg=/^[\da-zA-z]+@[\da-z]+\.[a-z]{2,}/;
	var email=$.trim($(this).val());
	if( !reg.test(email) ){
		$("#email").next().next().text("邮箱格式不正确。。。").show();
	}
});

//聚焦事件
$("#email").focus(function(){
	$("#email").next().next().hide();
});


	
function check_tel(){
	//获取电话号码
	var tel = $("#tel").val();
	//规则
	var reg = /^[1][3,4,5,7,8,9][0-9]{9}$/;
	
	if( !reg.test(tel)){
		$("#tel").next().next().html("手机号码格式错误");
		$("#tel").next().next().show();
	}
}


//获取验证码
function sendCode(){
	$("#uname").blur();
	$("#email").blur();
	console.log("我在钱面");
	if( $("#uname").next().css("display") != "none" ){
		return;
	}
	if( $("#email").next().next().css("display") != "none"  ){
		return;
	}
	console.log("我在中面");
	//昵称
	var uname = $.trim( $("#uname").val() );
	
	//获取邮箱
	var email = $.trim( $("#email").val() );
	
	//不允许在点击
	$("#getCode").attr("disabled","true");
	
	console.log("我在后面"+"参数为"+email+uname);
	//请求方式，地址，参数，回掉函数
	$.post("user/code",{
		receiveEmail:email,
		name:uname
	},function(data){
		data = parseInt( $.trim(data) );
		if( data>0 ){
			//倒计时
			var time=180;
			var timetask=setInterval(function(){
				if( time>0 ){
					time--;
					$("#getCode").val(time+"s");
				}else{
					$("#getCode").removeAttr("disabled").val("重新获取");
					clearInterval(timetask);
				}
			},1000)
		}else{
			$("#getCode").removeAttr("disabled").val("重新获取");
			$("#getCode").next().text("验证码发送失败，请重试。。.").show();
		}
	});
	
}

	

//协议
$("#allow").click(function(){
	//判断checkbox是否被选中
	if(!$(this).is(":checked")){
		$(this).next().next().html("您必须同意公司的协议");
		$(this).next().next().show();
		//给注册按钮设置禁用属性
		$("#reg").attr("disabled","disabled");
	}else{
		$(this).next().next().html("");
		$(this).next().next().hide();
		//移除注册按钮的禁用属性
		$("#reg").removeAttr("disabled");
	}
})


//注册
function checkRegister(){
	$("#myform input").each(function(){
		$(this).blur();
	})
	
	var spans = $(".error_tip");
	
	for( var i=0,len=spans.length;i<len;i++ ){
		if( $(spans[i]).css("display") != "none" ){//说明条件不符合
			return;
		}
	}
	
	$.post("user/reg",
		$("#myform").serialize()
	,function(data){
		data=parseInt( $.trim(data) );
		if( data == -2 ){
			$("#errmsg").text("验证码已过期，请重新获取。。。");
		} else if( data == -1 ){
			$("#errmsg").text("验证码错误，请重新获取。。。");
		}else if( data > 0 ){
			$("#myform")[0].reset();
			$("#errmsg").css("color","green").text("注册成功，请先登录");
			setTimeout(function(){
				location.href="login.html";
			},2000);
		} else {
			$("#errmsg").text("注册失败，请稍后重试。。。");
		}
	});
	//location.href="login.html";
}
	
	
	