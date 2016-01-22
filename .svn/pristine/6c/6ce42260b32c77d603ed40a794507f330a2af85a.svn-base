/**
 * 管理员页面JavaScript
 */
	addLoadEvent(init);
	addLoadEvent(hoversee);
	//初始化导航
	function init(){
		if(!document.getElementById) return false;
		if(!document.getElementById('nav')) return false;
		if(!window.location.href) return false;
		var strUrl = window.location.href;// 得到当前URL地址
		var splitList = strUrl.split('/');
		var regexp;
		if(splitList[splitList.length-1].indexOf('?')==-1){
			regexp = new RegExp(splitList[splitList.length-1]);// 得到匹配正则式
		}else{
			var pageurl = splitList[splitList.length-1].split('?');
			regexp = new RegExp(pageurl[0]);
		}
		var list = document.getElementById('nav');
		var zu = list.getElementsByTagName('li');
		var i,j;
		for(i=0;i<zu.length;i++){
			var alist = zu[i].getElementsByTagName('a');
			for(j=0;j<alist.length;j++) {
				if(regexp.test(alist[j].href)){
					alist[j].style.backgroundColor="#9bafcc";
					break;
				}
			}
			if(j==alist.length){
				zu[i].getElementsByTagName('dl')[0].style.display = "none";
				zu[i].getElementsByTagName('h3')[0].style.backgroundPosition = "13px 0px";
			}
		}
	}
	//注册导航点击事件
	function hoversee() {
		if(!document.getElementById) {return false;}
		if(!document.getElementById('nav')) {return false;}
		var list = document.getElementById('nav');
		var zu = list.getElementsByTagName('li');
		for(var i=0;i<zu.length;i++){
			zu[i].onclick = function(){
				if(this.getElementsByTagName('dl')[0].style.display =="block"){
					this.getElementsByTagName('dl')[0].style.display = "none";
					this.getElementsByTagName('h3')[0].style.backgroundPosition = "13px 0px";
				} else {
					this.getElementsByTagName('dl')[0].style.display = "block";
					this.getElementsByTagName('h3')[0].style.backgroundPosition = "13px -35px";
				}

			}
		}
	}
	function addLoadEvent(func){
		var oldfunc = window.onload;
		if(typeof window.onload !='function'){
			window.onload = func;
		} else {
			window.onload = function(){
				oldfunc();
				func();
			}
		}
	}
	/** ********************* */
	/** ***导航hover时候的样式* */
	/** ********************* */
	function lihover(){
		if(!document.getElementById) {return false;}
		if(!document.getElementById('nav')) {return false;}
		var list = document.getElementById('nav');
		var zu = list.getElementsByTagName('h3');
		for(var i=0;i<zu.length;i++){
			zu[i].onmouseover = function(){
				this.style.backgroundColor = "#779dc7";
				this.style.cursor = "pointer";
			}
			zu[i].onmouseout = function(){
				this.style.backgroundColor = "transparent";
			}
		}
	}
	addLoadEvent(lihover);
	/** ***@todelete******* */
	/** ***将导航与右边main底部对齐* */
	/** ********************* */
	function duiqi(){
		if(!document.getElementById) return false;
		if(!document.getElementById('nav')||!document.getElementById('main')) return false;
		var nav= document.getElementById('nav');
		var main = document.getElementById('main');
		var heightmax = parseInt(GetCurrentStyle(nav, "minHeight"));
		if(heightmax==null) return false; 
		var mainheight = parseInt(GetCurrentStyle(main, "height"));
		var paddingTop = parseInt(GetCurrentStyle(main, "paddingTop"));
		var paddingBottom = parseInt(GetCurrentStyle(main, "paddingBottom"));
		if(heightmax<mainheight+paddingTop+paddingBottom) {
			nav.style.height = (mainheight+paddingTop+paddingBottom)+"px";
			nav.height = (mainheight+paddingTop+paddingBottom)+"px"; }
	}
	/** ********************* */
	/** ***获取当前样式********** */
	/** ********************* */
	function GetCurrentStyle (obj, prop) {   
	    if (obj.currentStyle) {        
	        return obj.currentStyle[prop];     
	    }      
	    else if (window.getComputedStyle) {        
	        propprop = prop.replace (/([A-Z])/g,"-$1");           
	        propprop = prop.toLowerCase ();        
	        return document.defaultView.getComputedStyle (obj,null)[prop];     
	    }      
	    return null;   
	}