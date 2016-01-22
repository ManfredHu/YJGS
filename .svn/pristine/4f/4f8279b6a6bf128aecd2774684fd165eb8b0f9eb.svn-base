/**
 * @authors manfred hu
 * @date    2014-11-24 23:11:32
 * @version v1.0
 */
/** ******************************** */
/** ****加载addLoadEvent函数******* */
/** ******************************** */
function addLoadEvent(func) {
	var oldfunc = window.onload;
	if (typeof window.onload != 'function') {
		window.onload = func;
	} else {
		window.onload = function(){
		oldfunc();
		func();
		}
	}
}
/***********************************/
/***********首部背景图片移动********/
/** ******************************** */
function moveImage() {
	if (!document.getElementById)
		return false;
	if (!document.getElementById('header'))
		return false;
	var x = parseInt(document.getElementById('header').style.backgroundPosition);
	x++;
	header.style.backgroundPosition = x + "px 0px";
	setTimeout('moveImage()', 80);
}
function init() {
	if (!document.getElementById)
		return false;
	if (!document.getElementById('header'))
		return false;
	var head = document.getElementById('header');
	head.style.backgroundPosition = "0px 0px";
	moveImage(head);
}
addLoadEvent(init);
/* begin 开始移动 */
function seeProList() {
	if (!document.getElementById("liPro")) {
		return false;
	}
	var liPro = document.getElementById("liPro");
	liPro.onmouseover = function() {
		var seeUl = liPro.getElementsByTagName("ul")[0];
		seeUl.style.display = "block";
	}
	liPro.onmouseout = function() {
		var seeUl = liPro.getElementsByTagName("ul")[0];
		seeUl.style.display = "none";
	}
}
/** ******************************** */
/** ***********返回顶部************* */
/** ******************************** */
function goTopEx() {
	var obj = document.getElementById("goTopBtn");
	function getScrollTop() {
		return document.documentElement.scrollTop + document.body.scrollTop;
	}
	function setScrollTop(value) {
		if (document.documentElement.scrollTop) {
			document.documentElement.scrollTop = value;
		} else {
			document.body.scrollTop = value;
		}
	}
	window.onscroll = function() {
		getScrollTop() > 0 ? obj.style.display = ""
				: obj.style.display = "none";
	}
	obj.onclick = function() {
		var goTop = setInterval(scrollMove, 10);
		function scrollMove() {
			setScrollTop(getScrollTop() / 1.1);
			if (getScrollTop() < 1)
				clearInterval(goTop);
		}
	}
}
/** ******************************** */
/** ***********收藏网站************* */
/** ******************************** */
function AddFavorite(sURL, sTitle) {
	try {
		window.external.addFavorite(sURL, sTitle);
	} catch (e) {
		try {
			window.sidebar.addPanel(sTitle, sURL, "");
		} catch (e) {
			salert("加入收藏失败，请使用Ctrl+D进行添加");
		}
	}
}
/** ******************************** */
/** ***********设为首页************* */
/** ******************************** */
function SetHome(obj, vrl) {
	try {
		obj.style.behavior = 'url(#default#homepage)';
		obj.setHomePage(vrl);
	} catch (e) {
		if (window.netscape) {
			try {
				netscape.security.PrivilegeManager
						.enablePrivilege("UniversalXPConnect");
			} catch (e) {
				salert("此操作被浏览器拒绝！\n请在浏览器地址栏输入“about:config”并回车\n然后将 [signed.applets.codebase_principal_support]的值设置为'true',双击即可。");
			}
			var prefs = Components.classes['@mozilla.org/preferences-service;1']
					.getService(Components.interfaces.nsIPrefBranch);
			prefs.setCharPref('browser.startup.homepage', vrl);
		}
	}
}
/** ******************************** */
/** ***********遮罩函数************* */
/** ******************************** */
function salert(str) {
	var msgw, msgh, bordercolor;
	msgw = 400;// 提示窗口的宽度
	msgh = 100;// 提示窗口的高度
	titleheight = 25 // 提示窗口标题高度
	bordercolor = "#336699";// 提示窗口的边框颜色
	titlecolor = "#99ccff";// 提示窗口的标题颜色

	var swidth, sheight;
	swidth = document.body.offsetWidth;
	sheight = document.body.offsetHeight;
	if (sheight < screen.height) {
		sheight = screen.height;
	}
	// 创建遮罩层
	var bgobj = document.createElement("div");
	bgobj.setAttribute('id', 'bgdiv');
	bgobj.style.position = "absolute";
	bgobj.style.top = "0";
	bgobj.style.background = "#777";
	bgobj.style.filter = "progid:dximagetransform.microsoft.alpha(style=3,opacity=25,finishopacity=75";
	bgobj.style.opacity = "0.6";
	bgobj.style.left = "0";
	bgobj.style.width = swidth + "px";
	bgobj.style.height = sheight + "px";
	bgobj.style.zindex = "10000";
	document.body.appendChild(bgobj);
	var msgobj = document.createElement("div");
	msgobj.setAttribute("id", "msgdiv");
	msgobj.setAttribute("align", "center");
	msgobj.style.background = "white";
	msgobj.style.border = "1px solid " + bordercolor;
	msgobj.style.position = "absolute";
	msgobj.style.left = "50%";
	msgobj.style.top = "50%";
	msgobj.style.font = "12px/1.6em Microsoft YaHei, arial, sans-serif";
	msgobj.style.marginLeft = "-225px";
	msgobj.style.marginTop = -75 + document.documentElement.scrollTop + "px";
	msgobj.style.width = msgw + "px";
	msgobj.style.height = msgh + "px";
	msgobj.style.textalign = "center";
	msgobj.style.lineheight = (msgh - titleheight) + "px";
	msgobj.style.zindex = "10001";

	var title = document.createElement("h4");
	title.setAttribute("id", "msgtitle");
	title.setAttribute("align", "right");
	title.style.margin = "0";
	title.style.padding = "3px";
	title.style.background = bordercolor;
	title.style.filter = "progid:dximagetransform.microsoft.alpha(startx=20, starty=20, finishx=100, finishy=100,style=1,opacity=75,finishopacity=100);";
	title.style.opacity = "0.75";
	title.style.border = "1px solid " + bordercolor;
	title.style.height = "18px";
	title.style.font = "12px Microsoft YaHei, arial, sans-serif";
	title.style.color = "white";
	title.style.cursor = "pointer";
	title.innerHTML = "关闭";
	title.onclick = function() {
		document.body.removeChild(bgobj);
		document.getElementById("msgdiv").removeChild(title);
		document.body.removeChild(msgobj);
	}
	document.body.appendChild(msgobj);
	document.getElementById("msgdiv").appendChild(title);
	var txt = document.createElement("p");
	txt.style.margin = "1em 0";
	txt.setAttribute("id", "msgtxt");
	txt.innerHTML = str;
	document.getElementById("msgdiv").appendChild(txt);
}

/* DeleteNowPage.js函数 */
function DeleteProductPage() {
	if (!document.getElementById('pagenow'))
		return false;
	if (!document.getElementById('pageNum'))
		return false;
	var span = document.getElementById('pagenow');
	var alist = document.getElementById('pageNum');
	var aa = alist.getElementsByTagName('a');
	for (var i = 0; i < aa.length; i++) {
		if (aa[i].innerHTML == span.innerHTML) {
			aa[i].style.borderColor = "#fff";
			aa[i].style.color = "#3b3b3b";
		}
	}
}
function hoverColor() {
	if (!document.getElementById)
		return false;
	if (!document.getElementById('tbfortr'))
		return false;
	var main = document.getElementById('tbfortr');
	var list = main.getElementsByTagName('tr');
	for (var i = 0; i < list.length; i++) {
		list[i].onmouseover = function() {
			this.style.backgroundColor = '#eee';
		}
		list[i].onmouseout = function() {
			this.style.backgroundColor = 'transparent';
		}
	}
}
function changeNowPage() {
	if (!document.getElementById)
		return false;
	if (!document.getElementById('curPage'))
		return false;
	if (!document.getElementById('aList'))
		return false;
	var span = document.getElementById('curPage');
	var alist = document.getElementById('aList');
	var aa = alist.getElementsByTagName('a');
	for (var i = 0; i < aa.length; i++) {
		if (aa[i].innerHTML == span.innerHTML) {
			aa[i].style.borderColor = "#fff";
			aa[i].style.color = "#3b3b3b";
		}
	}
}
function changeLiHover() {
	if(!document.getElementById('proNav'))
		return false;
	var liList = document.getElementById('proNav').getElementsByTagName('li');
	for(var i=0;i<liList.length;i++){
			liList[i].onmouseover = function(){
				this.style.background = 'url(../Image/bg_product.png) no-repeat';
				this.style.borderLeft = 'none';
				this.style.paddingLeft = '60px';
			}
			liList[i].onmouseout = function(){
				this.style.backgroundImage = 'none';
				this.style.borderLeft = '1px solid #ebecee';
				this.style.paddingLeft = '40px';
			}
		}
		
}
