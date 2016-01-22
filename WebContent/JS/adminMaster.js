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
				var dlStyle = this.getElementsByTagName('dl')[0].style;
				var h3Style = this.getElementsByTagName('h3')[0].style;
				if(dlStyle.display =="block"){
					dlStyle.display = "none";
					h3Style.backgroundPosition = "13px 0px";
				} else {
					dlStyle.display = "block";
					h3Style.backgroundPosition = "13px -35px";
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