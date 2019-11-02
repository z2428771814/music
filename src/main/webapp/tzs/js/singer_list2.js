var addr = undefined;
var sex = undefined;
var let = undefined;
var start = undefined;
var stop = undefined;
var genre = undefined;
$(function() {
	
	var totalPage = 0;  //总页数
	var len = 0;
	var total;
	var lenSex;
	
	var muSize;
	var str = "";
		//字母
	for(var i=0;i<26;i++) {
		letter = String.fromCharCode((65+i));
		str += '<a href="javascript:void(0);" class="singer_tag__item" data-key="index" data-id="2"  onclick="findLetter(this,\''+letter+'\')" id="ab">'+letter+'</a>';
	}
	$("#letters").append($(str));
	$("#letters").find("a").eq(9).remove();
	$("#letters").find("a").eq(20).remove();
	$("#letters").find("a").eq(20).remove();
	
	//查询地区
	$.post("../music/findAddr", null, function(data) {
		var str1 = "";
		$.each(data, function(index, item) {
			str1 += '<a href="javascript:void(0);" onclick="findAddr(this, \''+item.addr+'\')" class="singer_tag__item" data-key="area" data-id="200" hidefocus="true" id="diqu">'+item.addr+'</a>';
		});
		$("#findAddr").append($(str1));
	}, "json");
	
	//所有歌手类型
	$.post("../music/singType", null, function(data) {
		var str2 = "";
		$.each(data, function(index, item) {
			str2 += '<a href="javascript:;" class="singer_tag__item" data-key="genre" data-id="1" onclick="findType(this, \''+item.genre+'\')">'+item.genre+'</a>';
		});
		$("#singType").append($(str2));
	}, "json");
	
})
function findLetter(obj,le) {
	let = le;
	console.log(let);
	if ( let == "A" ) {
		 start = 45217;
		 stop = 45252;
	} else if ( let == "B" ) {
		start = 45253;
		stop = 45760;
	} else if ( let == "C" ) {
		start = 45761;
		stop = 	46317;
	} else if ( let == "D" ) {
		start = 46318;
		stop = 46825;
	} else if ( let == "E" ) {
		start = 46826;
		stop = 47009;
	} else if ( let == "F" ) {
		start = 47010;
		stop = 47296;
	} else if ( let == "G" ) {
		start = 47297;
		stop = 47613;
	} else if ( let == "H" ) {
		start = 47614;
		stop = 	48118;
	} else if ( let == "J" ) {
		start = 48119;
		stop = 	49061;
	} else if ( let == "K" ) {
		start = 49062;
		stop = 	49323;
	} else if ( let == "L" ) {
		start = 49324;
		stop = 	49895;
	} else if ( let == "M" ) {
		start = 49896;
		stop = 	50370;
	} else if ( let == "N" ) {
		start = 50371;
		stop = 50613;
	} else if ( let == "O" ) {
		start = 50614;
		stop = 	50621;
	} else if ( let == "P" ) {
		start = 50622;
		stop = 50905;
	} else if ( let == "Q" ) {
		start = 50906;
		stop = 51386;
	} else if ( let == "R" ) {
		start = 51387;
		stop = 51445;
	} else if ( let == "S" ) {
		start = 51446;
		stop = 52217;
	} else if ( let == "T" ) {
		start = 52218;
		stop = 52697;
	} else if ( let == "W" ) {
		start = 52698;
		stop = 52979;
	} else if ( let == "X" ) {
		start = 52980;
		stop = 53688;
	} else if ( let == "Y" ) {
		start = 53689;
		stop = 54480;
	} else if ( let == "Z" ) {
		start = 54481;
		stop = 55289;
	}
	judge();
	beg();
	$("#letters a").removeClass("singer_tag__item--select");
	$(obj).addClass("singer_tag__item--select");
}
function findAddr(obj,ar) {
	addr = ar;
	console.log(addr);
	judge();
	beg();
	$("#findAddr a").removeClass("singer_tag__item--select");
	//修改样式
	$(obj).addClass("singer_tag__item--select");
}
function findSex(obj,se) {
	sex = se;
	console.log(sex);
	judge();
	beg();
	$("#findSex a").removeClass("singer_tag__item--select");
	//修改样式
	$(obj).addClass("singer_tag__item--select");
}
function findType(obj,ty) {
	genre = ty;
	console.log(genre);
	judge();
	//alert(addr +"1"+ let+"2" + sex + "3" + start+"4"+stop + "5"+ genre + "***");
	beg();
	$("#singType a").removeClass("singer_tag__item--select");
	//修改样式
	$(obj).addClass("singer_tag__item--select");
	
}
//判断
function judge() {
	if(let == undefined || let == "") {
		let = "";
	} 
	if(addr == undefined || addr == "") {
		addr = "";
	}
	if(start == undefined || start == "") {
		start = "";
	}
	if(stop == undefined || stop == "") {
		stop = "";
	}
	if(sex == undefined || sex == "") {
		sex = "";
	}
	if(genre == undefined || genre == "") {
		genre = "";
	}
}

//请求
function beg() {
	$.post("../music/findLet", {addr:addr,sex:sex,genre:genre,start:start,stop:stop,let:let,page:page,rows:rows}, function(data) {
		console.log(data.count + "数量");
		len = data.count;
		console.log(data + "数据");
		singerinfo(data.letter);
		$("#pageTool div").remove();
		newArea();
		if (len <= 0) {
			len = 1;
		}
		area.render({count:len,pagesize:rows,page:1});
		
	},"json");
}

//歌手展示
function singerinfo(data) {
	var str = "";
	$.each(data, function(index, item) {
		str += '<li class="singer_list__item">';
		str += '<div class="singer_list__item_box">';
		str += '<a href="https://y.qq.com/n/yqq/singer/002Vcz8F2hpBQj.html#stat=y_new.singerlist.singername" onclick="setStatCookie&amp;&amp;setStatCookie();"';
		str += 'class="singer_list__cover js_singer" hidefocus="true" data-stat="y_new.singerlist.singerpic" data-singermid="001fNHEf1SFEFN" data-singerid="13948" title="'+item.sgname+'">';
		str += '<img class="singer_list__pic" src="../'+item.by1+'" alt="'+item.sgname+'></a>';
		str += '<h3 class="singer_list__title"><a href="javascript:void(0);" onclick="setStatCookie&amp;&amp;setStatCookie();" class="js_singer" title="'+item.sgname+'">'+item.sgname+'</a></h3>';
		str += '</div></li>';
	},"json");
	$("#singer_list").html("").append($(str));
}

function newSinger() {
	p.init({			
		target: $('#pageTool'), pagesize: rows, count: totalPage, page:page,callback: function (page, rows) {
			$.post("../music/singerShow",{page:page,rows:rows},function(data){
				singerinfo(data);
			})
		}
	});
	//重新渲染分页使用render
	p.render({count:totalPage,pagesize:rows,page:1});
}

//歌手展示
function singerShow() {
	$.post("../music/findByFirst", {page:page,rows:rows}, function(data) {
		pageInfo(data.count);
		singerinfo(data.singer);
	}, "json");
}

//分页查询
function pageInfo(total) {	//total abc也行 是个形参变量存的是data.total的值
	totalPage = total;
	newSinger();
}

function newArea() {
	area.init({			
		target: $('#pageTool'), pagesize: rows, count: len, page:page,callback: function (page, rows) {
			$.post("../music/findLet", {addr:addr,sex:sex,genre:genre,start:start,stop:stop,let:let,page:page,rows:rows}, function(data) {
				console.log(data.letter);
				console.log(data.count + "数量");
				singerinfo(data.letter);
			})
		}
	});
	//重新渲染分页使用render
	area.render({count:len,pagesize:rows,page:1});
}

function newLet(obj) {
	judge();
	start = "";
	stop = "";
	let = "";
	beg();
	$("#letters a").removeClass("singer_tag__item--select");
	$(obj).addClass("singer_tag__item--select");
}
function newAddr(obj) {
	judge();
	addr = "";
	beg();
	$("#findAddr a").removeClass("singer_tag__item--select");
	//修改样式
	$(obj).addClass("singer_tag__item--select");
}
function newSex(obj) {
	judge();
	sex = "";
	beg();
	$("#findSex a").removeClass("singer_tag__item--select");
	//修改样式
	$(obj).addClass("singer_tag__item--select");
}
function newType(obj) {
	judge();
	genre = "";
	beg();
	$("#singType a").removeClass("singer_tag__item--select");
	//修改样式
	$(obj).addClass("singer_tag__item--select");
}
