function changeLiHover() {
	if(!document.getElementById('proNav'))
		return false;
	var liList = document.getElementById('proNav').getElementsByTagName('li');
	for(var i=0;i<liList.length;i++){
			
			liList[i].onmouseover = function(){
				if(this.id=="curType") 
					return;
				this.style.background = 'url(../Image/bg_product.png) no-repeat';
				this.style.borderLeft = 'none';
				this.style.paddingLeft = '60px';
			}
			liList[i].onmouseout = function(){
				if(this.id=="curType") 
					return;
				this.style.backgroundImage = 'none';
				this.style.borderLeft = '1px solid #ebecee';
				this.style.paddingLeft = '40px';
			}
		}
		
}
addLoadEvent(changeLiHover);
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
addLoadEvent(changeNowPage);
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
addLoadEvent(hoverColor);
function DeleteProductPage(){
	if(!document.getElementById('pagenow')) 
		return false;
	if(!document.getElementById('pageNum'))
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
