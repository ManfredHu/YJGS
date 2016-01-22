/**
 * 
 */
function deleteNews(id) {
	window.location.href = "deleteNewsSel?deleteNewsID=" + id + "";
}

function typeChange(thisA) {

	var thisForm = thisA.parentNode;
	thisForm.submit();
}
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
addLoadEvent(altColor);
function changeNowPage() {
	if (!document.getElementById)
		return false;
	var num = document.getElementById('pageNow');
	if(!num) return false;
	var PageList = document.getElementById('PageList');
	var alist = PageList.getElementsByTagName('a');
	for (var i = 0; i < alist.length; i++) {
		if (alist[i].innerHTML == num.innerHTML) {
			alist[i].style.borderColor = "#fff";
			alist[i].style.color = "#000";
		}
	}
}
addLoadEvent(changeNowPage);