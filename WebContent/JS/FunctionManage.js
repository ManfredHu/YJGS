/**
 * 功能管理模块
 */
function blue(elem) {
	elem.style.borderColor = "#56abe4";
}
function checkPass(elem) {
	if (!document.getElementById)
		return false;
	var reg = /^[\u4E00-\u9FA5\uF900-\uFA2D]{2,7}$/;
	if (elem.value == "") {
		elem.style.borderColor = "#eb4f38";
		if (document.getElementById('errorInfo')) {
			return false;
		}
		var ptext = document.createElement('p');
		ptext.setAttribute('id', 'errorInfo');
		var text = document.createTextNode("不能为空，请输入2-7个中文字符！");
		ptext.appendChild(text);
		var form = document.getElementById('functionManageForm');
		form.appendChild(ptext);
		return false;
	}

	if (reg.test(elem.value)) {
		elem.style.borderColor = "#11cd6e";
		if(document.getElementById('errorInfo')){
			document.getElementById('errorInfo').parentNode.removeChild(document.getElementById('errorInfo'));
		}
		return true;
	} else {
		elem.style.borderColor = "#eb4f38";
		if (document.getElementById('errorInfo')) {
			return false;
		}
		var ptext = document.createElement('p');
		ptext.setAttribute('id', 'errorInfo');
		var text = document.createTextNode("请输入2-7个中文字符！");
		ptext.appendChild(text);
		var form = document.getElementById('functionManageForm');
		form.appendChild(ptext);
		return false;
	}

}
function checkAll() {
	if (!document.getElementById)
		return false;
	var reg = /^[\u4E00-\u9FA5\uF900-\uFA2D]{2,7}$/;
	var form = document.getElementById('functionManageForm');
	var liList = form.getElementsByTagName('li');
	for (var i = 0; i < liList.length; i++) {
		if (!reg.test(liList[i].firstChild.value)) {
			liList[i].firstChild.style.borderColor = "#eb4f38";
			if (document.getElementById('errorInfo')) {
				return false;
			}
			var ptext = document.createElement('p');
			ptext.setAttribute('id', 'errorInfo');
			var text = document.createTextNode("请输入2-7个中文字符！");
			ptext.appendChild(text);
			var form = document.getElementById('functionManageForm');
			form.appendChild(ptext);
			return false;
		} 
	}
	return true;

}