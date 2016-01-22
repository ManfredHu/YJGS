/**
 * 登陆页面JS
 */
function clearError() {
	if (!document.getElementById('error')) {
		return false;
	} else {
		document.getElementById('error').parentNode.removeChild(document
				.getElementById('error'));
	}
}

// 重新获取验证字符
function changeImage() {
	// 单击触发图片重载事件，完成图片验证码的更换
	document.getElementById("imgRandom").src = document
			.getElementById("imgRandom").src
			+ '?';
}
function blue(elem) {
	elem.style.borderColor = "#56abe4";
}
function checkName(elem) {
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
function checkUsername(elem) {
	var regex = /^(\w){4,25}$/;
	var s = elem.value;
	if (!regex.test(s)) {
		elem.style.borderColor = "#eb4f38";
		return false;
	} else {
		elem.style.borderColor = "#11cd6e";
		return true;
	}
}
function checkPassword(elem) {
	var patrn = /^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{4,25}$/;
	var s = elem.value;
	if (!patrn.exec(s)) {
		elem.style.borderColor = "#eb4f38";
		return false;
	} else {
		elem.style.borderColor = "#11cd6e";
		return true;
	}
}
function checkNum(elem) {
	var patrn = /^\d{4}$/;
	var s = elem.value;
	if (!patrn.exec(s)) {
		elem.style.borderColor = "#eb4f38";
		return false;
	} else {
		elem.style.borderColor = "#11cd6e";
		return true;
	}
}
function showError(text) {
	if (!document.getElementById)
		return false;
	if (!document.getElementById('loginForm'))
		return false;
	if (document.getElementById('error')) {
		document.getElementById('error').innerHTML = text;
	} else {
		var error = document.createElement('p');
		error.setAttribute('id', 'error');
		var text = document.createTextNode(text);
		error.appendChild(text);
		var loginForm = document.getElementById('loginForm');
		loginForm.getElementsByTagName('div')[0].appendChild(error);
	}
}
function checkAll() {
	if (!document.getElementById)
		return false;
	if (!document.getElementById('loginForm'))
		return false;
	var text = document.getElementById('userNum');
	var password = document.getElementById('userPwd');
	var checkNumber = document.getElementById('yanzhengma');
	if (!text || !password || !checkNumber)
		return false;
	if (!checkUsername(text)) {
		showError('用户名格式错误！');
		return false;
	} else if (!checkPassword(password)) {
		showError('密码格式错误！');
		return false;
	} else if (!checkNum(checkNumber)) {
		showError('验证码格式错误！');
		return false;
	} else {
		return true;
	}
}
/** ********************* */
/** *****设置密保页面验证****** */
/** ********************* */
// 检测问题
function checkProblem(elem) {
	clearError();// 有提示着清除提示
	var ptext = document.createElement('p');
	ptext.setAttribute('id', 'error');
	var text;
	if (elem.value.length <= 0) {
		text = document.createTextNode('问题不能为空');
	} else if (elem.value.length >= 50) {
		text = document.createTextNode('问题过长');
	} else {
		elem.style.borderColor = "#11cd6e";
		return true;
	}
	ptext.appendChild(text);
	if (!document.getElementById('writeProblem'))
		return false;
	document.getElementById('writeProblem').appendChild(ptext);
	elem.style.borderColor = "#eb4f38";
	return false;
}
// 检测答案
function checkAnswer(elem) {
	clearError();
	var ptext = document.createElement('p');
	ptext.setAttribute('id', 'error');
	var text;
	if (elem.value.length <= 0) {
		text = document.createTextNode('答案不能为空');
	} else if (elem.value.length >= 50) {
		text = document.createTextNode('答案过长');
	} else {
		elem.style.borderColor = "#11cd6e";
		return true;
	}
	ptext.appendChild(text);
	if (!document.getElementById('writeProblem'))
		return false;
	document.getElementById('writeProblem').appendChild(ptext);
	elem.style.borderColor = "#eb4f38";
	return false;
}
function checkProblemAndAnswer(elem) {
	if (!document.getElementById('writeProblem'))
		return false;
	var loginDiv = document.getElementById('writeProblem');
	var inputList = loginDiv.getElementsByTagName('input');
	for (var i = 0; i < 6; i++) {
		if (inputList[i].value.length <= 0 || inputList[i].value.length >= 50) {
			inputList[i].style.borderColor = "#eb4f38";
			if (document.getElementById('error')) {
				document.getElementById('error').innerHTML = "问题或答案错误";
			} else {
				var ptext = document.createElement('p');
				ptext.setAttribute('id', 'error');
				var text = document.createTextNode("问题或答案错误");
				ptext.appendChild(text);
				loginDiv.appendChild(ptext);
			}
			return false;
		}
	}
	return true;
}
/** ********************* */
/** *****修改密码页面验证****** */
/** ********************* */
function clearErrorText() {
	if (document.getElementById('error0')) {
		document.getElementById('error0').parentNode.removeChild(document
				.getElementById('error0'));
	} else if (document.getElementById('error1')) {
		document.getElementById('error1').parentNode.removeChild(document
				.getElementById('error1'));
	} else if (document.getElementById('error2')) {
		document.getElementById('error2').parentNode.removeChild(document
				.getElementById('error2'));
	}
}
function pwdCheckAll() {
	clearErrorText();
	var ffrom = document.getElementById('changePwd');
	var textList = ffrom.getElementsByTagName('input');
	for (var i = 0; i < 3; i++) {
		if (!checkPassword(textList[i])) {
			var ptext = document.createElement('p');
			ptext.className = "error";
			ptext.setAttribute('id', 'error' + i);
			var text = document.createTextNode('密码格式错误');
			ptext.appendChild(text);
			if (!document.getElementById('changePwd'))
				return false;
			document.getElementById('changePwd').appendChild(ptext);
			return false;
		}
	}
	if (textList[1].value != textList[2].value) {
		if (document.getElementById('error2')) {
			document.getElementById('error2').innerHTML = "两次密码不同";
			return false;
		} else {
			var xtext = document.createElement('p');
			xtext.setAttribute('class', 'error');
			xtext.setAttribute('id', 'error2');
			var text1 = document.createTextNode('两次密码不同');
			xtext.appendChild(text1);
			document.getElementById('changePwd').appendChild(xtext);
			return false;
		}
	}
	return true;
}
/*建议反馈页面*/
function isNull(ele){
	var s = ele.value;
	s = s.replace(/\s/g,"");
	if (s.length>0) {
		ele.style.borderColor = "#11cd6e";
		return true;
	} else {
		ele.style.borderColor = "#eb4f38";
		return false;
	}
	
}
function checkEmail(ele){
	var reg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
	if(reg.test(ele.value)){
		ele.style.borderColor = "#11cd6e";
		return true;
	} else {
		ele.style.borderColor = "#eb4f38";
		return false;
		
	}
		
}