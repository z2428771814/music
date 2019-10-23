$(function() {
	$.post("../user/check", null, function(data) {
		var str = "";
		console.log(data);
		if (data.uid) {
			str += '<a class="top_login__link js_logined" href="//y.qq.com/portal/profile.html#stat=y_new.top.user_pic" onclick="setStatCookie&&setStatCookie();" style="display:block;">';
			str += '<img class="top_login__cover js_user_img" src="../'+data.pic+'" class="top_login__cover" alt="" />';
			str += '<img src="//y.gtimg.cn/mediastyle/yqq/img/login_qq.png?max_age=2592000" class="top_login__icon"></a>';
		} else {	//没有登录
			str += '<a class="top_login__link js_login" data-stat="y_new.top.login" href="../login.html">登录</a>';
		}
		
		$("#login_TOp").prepend($(str));
		$(".profile__name").html(data.uname);
		$("#uid").val(data.uid);
	}, "json");
})



