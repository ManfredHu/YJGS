/**
 * 管理管理员页面
 */
/* 交替行背景变色且注册HOVER颜色变化 */
function altColor() {
	if (!document.getElementById)
		return false;
	if (!document.getElementById('main'))
		return false;
	var main = document.getElementById('main');
	var atable = main.getElementsByTagName('table');
	if (!atable)
		return false;
	for (var j = 0; j < atable.length; j++) {
		var list = atable[j].getElementsByTagName('tr');
		for (var i = 1; i < list.length; i++) {
			if (i % 2 == 0)
				list[i].style.backgroundColor = '#f0f8ff';
			else {
				list[i].style.backgroundColor = '#cae4fe';
			}
		}
	}
}
/* hover的时候颜色变化 */
function hoverColor() {
	if (!document.getElementById)
		return false;
	if (!document.getElementById('main'))
		return false;
	var main = document.getElementById('main');
	var list = main.getElementsByTagName('tr');
	for (var i = 1; i < list.length; i++) {
		list[i].onmouseover = function() {
			this.style.backgroundColor = '#F59292';
		}
		list[i].onmouseout = altColor;
	}
}
addLoadEvent(altColor);
//addLoadEvent(hoverColor);