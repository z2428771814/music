$(function() {
	
	//歌单类型推荐
	$.post("songList/oodType", null, function(data) {
		console.log(data);
		var str = "";
		$.each(data, function(index, item) {
			str += '<a href="javascript:;" class="index_tab__item js_tag" data-type="new_song" data-id="'+item.sid+'">'+item.stype+'</a>'
		});
		$("#type_list").append($(str));
	}, "json");
	
	//最新歌单
	$.post("songList/newOdd", null, function(data) {
		console.log(data);
		var str = "";
		$.each(data, function(index, item) {
			str += '<li class="playlist__item slide__item" data-disstid="'+item.lid+'">';
			str += '<div class="playlist__item_box"><div class="playlist__cover mod_cover">';
			str += '<a href="tzs/playsquare.html" onclick="setStatCookie&&setStatCookie();" class="js_playlist" data-stat="y_new.index.playlist.pic"  data-disstid="7252602321">';
			str += '<img src="tzs/image/T015R640x360M101003U84CO3oxo4F.jpg" id="img_dan"';
			str += 'alt="'+item.lname+'" class="playlist__pic"><i class="mod_cover__mask"></i><i class="mod_cover__icon_play js_play"></i></a></div>';
			str += '<h4 class="playlist__title">';
			str += '<span class="playlist__title_txt"><a href="tzs/playsquare.html" onclick="setStatCookie&&setStatCookie();" class="js_playlist" data-stat="y_new.index.playlist.pic" data-disstid="7252602321">'+item.lname+'</a></span>';
			str += '</h4><div class="playlist__other">播放量：'+item.by2+'</div></div></li>';
		});
		
		$("#list_dan").append($(str));
	}, "json");
	
	//查询地区
	$.post("music/findAddr", null, function(data) {
		console.log(data);
		var str = "";
		$.each(data, function(index, item) {
			str += '<a href="javascript:;" class="index_tab__item js_tag" data-type="playlist" data-id="'+item.sgid+'">'+item.addr+'</a>'
			
		});
		$("#mod_index_tab").append($(str));
	}, "json");
	
	//最新歌曲
	$.post("music/newSong", null, function(data) {
		console.log(data);
		var str = "";
		$.each(data, function(index, item) {
			str += '<li class="songlist__item"><div class="songlist__item_box">';
			str += '<a title="'+item.mname+'" class="album_name songlist__link mod_cover">';
			str += '<img class="songlist__pic" src="'+item.pices+'">';
			str += '<i class="mod_cover__mask"></i><i class="mod_cover__icon_play"></i></a>';
			str += '<div class="songlist__cont"><h3 class="songlist__song"><a title="'+item.mname+'" href="tzs/song_page.html#'+item.mid+'">'+item.mname+'</a></h3>';
			str += '<p class="songlist__author"><a title="'+item.sgname+'" class="c_tx_thin singer_name">'+item.sgname+'</a>';
			str += '</p><div class="songlist__time c_tx_thin">04:00</div></div></li>';
		});
		
		$(".songlist__list").append($(str));
	}, "json");
	
	
	$.post("user/check", null, function(data) {
		var str = "";
		console.log(data);
		if (data.uid) {
			str += '<a class="top_login__link js_logined" href="//y.qq.com/portal/profile.html#stat=y_new.top.user_pic" onclick="setStatCookie&&setStatCookie();" style="display:block;">';
			str += '<img src="'+data.pic+'" class="top_login__cover" alt="" />';
			str += '<img src="//y.gtimg.cn/mediastyle/yqq/img/login_qq.png?max_age=2592000" class="top_login__icon"></a>';
		} else {	//没有登录
			str += '<a class="top_login__link js_login" data-stat="y_new.top.login" href="login.html">登录</a>';
		}
		
		$("#login_TOp").prepend($(str));
	}, "json");
})



