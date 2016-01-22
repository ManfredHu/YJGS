/**
 * 添加管理员验证
 */
function blue(elem) {
	elem.style.borderColor = "#56abe4";
}
// 检查输入的用户名，允许中文+字母
function checkUsername(elem) {
	var regex = /^(\w+){2,15}|([\u0391-\uFFE5]+){2,15}$/;
	var s = elem.value;
	var username = document.getElementById('userName');// 得到用户输入框
	if (elem.value == '') {
		elem.style.borderColor = "#cccccc";
		return false;
	}
	if (!regex.test(s)) {
		elem.style.borderColor = "#eb4f38";
		// 存在提示则返回
		if (document.getElementById('usererror'))
			return false;
		var error = document.createElement('p');
		error.setAttribute('id', 'usererror');
		var text = document.createTextNode('用户名错误');
		error.appendChild(text);
		insertAfter(error, username);
		return false;
	} else {
		elem.style.borderColor = "#11cd6e";
		// 存在提示，要消除
		if (document.getElementById('usererror'))
			document.getElementById('usererror').parentNode
					.removeChild(document.getElementById('usererror'));
		return true;
	}
}
// 判断是否拥有账号,ajax
function hasAccount(value) {
	var xmlhttp = createXMLHttpRequest();
	if (!xmlhttp) {
		return;
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			if (xmlhttp.responseText == "true") {
				return;
			} else {
				{
					// 执行没有通过的情况，此时应该有提示
					var temp = document.getElementById('accounterror');
					if (temp != null) {
						return;
					} else {
						// 此时为输入正确，但是数据库里面已经有这样的账号
						document.getElementById('userAccount').style.borderColor = "#eb4f38";// 改变边框颜色
						var error = document.createElement('p');
						error.setAttribute('id', 'accounterror');
						var text = document.createTextNode('已有账号');
						error.appendChild(text);
						insertAfter(error, userAccount);
					}

				}
			}
		}
	}
	xmlhttp.open("POST", 'AccountValidate', true);
	xmlhttp.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded;charset=UTF-8");
	xmlhttp.send('userAccount=' + value);
}
// 检查输入的账号
function checkAccount(elem) {
	var regex = /^(\w){4,15}$/;
	var s = elem.value;
	var account = document.getElementById('userAccount');
	if (elem.value == '') {
		elem.style.borderColor = "#cccccc";//没有输入，显示边框灰色
		return false;
	}
	if (!regex.test(s)) {
		elem.style.borderColor = "#eb4f38"; // 显示边框红色
		if (document.getElementById('accounterror')) {
			if (document.getElementById('accounterror').innerHTML == "账号错误")
				return; // 存在账号错误提示，相同提示，返回
			if (document.getElementById('accounterror').innerHTML == "已有账号") {
				document.getElementById('accounterror').parentNode
						.removeChild(document.getElementById('accounterror'));
				// 存在已有账号提示，清除提示
			}
		}
		//没有提示，创建提示
		var error = document.createElement('p');
		error.setAttribute('id', 'accounterror');
		var text = document.createTextNode('账号错误');
		error.appendChild(text);
		insertAfter(error, account);
		hasAccount(elem.value);// 验证数据库是否有此账号
		return false;
	} else {
		elem.style.borderColor = "#11cd6e";
		hasAccount(elem.value);
		// 存在提示，要消除
		if (document.getElementById('accounterror'))
			document.getElementById('accounterror').parentNode
					.removeChild(document.getElementById('accounterror'));
		return true;
	}
}
function checkAll() {
	var username = document.getElementById('userName');// 得到用户输入框
	var account = document.getElementById('userAccount');
	if (checkUsername(username) && checkAccount(account))
		return true;
	else
		return false;
}
function insertAfter(newElem, targetElem) {
	var parent = targetElem.parentNode;
	if (parent.lastChild == targetElem) {
		parent.appendChild(newElem);
	} else {
		parent.insertBefore(newElem, targetElem.nextSibling);
	}
}
// 得到XMLHttpRequest对象
function createXMLHttpRequest() {
	if (window.XMLHttpRequest) {
		return new XMLHttpRequest();
	} else {
		return ActiveXObject("Microsoft.XMLHTTP");
	}
}
