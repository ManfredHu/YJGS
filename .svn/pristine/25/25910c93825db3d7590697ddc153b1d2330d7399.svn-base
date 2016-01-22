/**
 * 添加产品页面
 */
var curParamNum = 1;
var maxParamNum = 10; // 最大参数个数
function addParam() {
	var paramTable;
	var newTr;
	var newTd1, newTd2, newTd3;
	var newInput1, newInput2;
	var deleteButton;
	if (curParamNum == maxParamNum) {
		alert('已达到最大参数个数，无法继续添加');
		return;
	} else {
		curParamNum += 1;
	}
	// 获取参数表格
	paramTable = document.getElementById("paramsTable");
	paramTbody = paramTable.getElementsByTagName("tbody")[0];
	// 创建新行
	newTr = document.createElement("tr");
	newTd1 = document.createElement("td");
	newTd2 = document.createElement("td");
	newTd3 = document.createElement("td");
	newInput1 = document.createElement("input");
	newInput2 = document.createElement("input");
	deleteButton = document.createElement("input");
	// 添加新的参数输入框
	newInput1.setAttribute("type", "text");
	newInput1.setAttribute("name", "names");
	newInput2.setAttribute("type", "text");
	newInput2.setAttribute("name", "values");
	deleteButton.setAttribute("type", "button");
	deleteButton.setAttribute("value", "删除");
	deleteButton.onclick = function(){deleteParam(this);};
	//deleteButton.setAttribute("onclick", "function(){deleteParam(this);}");
	deleteButton.className = "deletebtn";
	// 插入节点，组成表格
	paramTbody.appendChild(newTr);
	newTr.appendChild(newTd1);
	newTr.appendChild(newTd2);
	newTr.appendChild(newTd3);
	newTd1.appendChild(newInput1);
	newTd2.appendChild(newInput2);
	newTd3.appendChild(deleteButton);
}

function deleteParam(thisA) {
	var paramTable;
	var thisRow;
	if (curParamNum == 1) {
		alert('至少保留一个参数，无法继续删除');
		return;
	} else {
		curParamNum -= 1;
	}
	// 获取表格以及当前的行节点
	paramTable = document.getElementById("paramsTable");
	paramTbody = document.getElementsByTagName("tbody")[0];
	thisRow = thisA.parentNode.parentNode;
	// 移除当前行节点
	paramTbody.removeChild(thisRow);
}
function checkAll() {
	if (!document.getElementById)
		return false;
	var main = document.getElementById('main');
	var select = main.getElementsByTagName('select')[0];
	if (select.value == 0) {
		createText("请选择类别");
		select.style.borderColor = "#eb4f38";
		return false;
	}else{
		select.style.borderColor = "#ccc";
	}
	var proName = document.getElementById('proName');
	if (proName.value.length==0||proName.value.length>50) {
		createText("产品名称格式错误");
		proName.style.borderColor = "#eb4f38";
		return false;
	}else{
		proName.style.borderColor = "#ccc";
	}
	var tableBody = main.getElementsByTagName('tbody')[0];
	var trList = tableBody.getElementsByTagName('tr');
	for(var i=0;i<trList.length;i++){
		var inputList = trList[i].getElementsByTagName('input');
		if(inputList[0].value.length==0||inputList[0].value.length>10){
			inputList[0].style.borderColor = "#eb4f38";
			createText("参数不能为空且需小于10个字");
			return false;
		}else{
			inputList[0].style.borderColor = "#ccc";
		}
		if(inputList[1].value.length==0||inputList[1].value.length>100){
			inputList[1].style.borderColor = "#eb4f38";
			createText("参数不能为空且需小于100个字");
			return false;
		}else{
			inputList[1].style.borderColor = "#ccc";
		}
	}
	return true;
}
function createText(text) {
	if (document.getElementById('error')) {
		document.getElementById('error').innerHTML=text;
		return;
	} else {
		var pp = document.createElement("p");
		pp.setAttribute('id', 'error');
		var innerText = document.createTextNode(text);
		pp.appendChild(innerText);
		if (!document.getElementById('AddProduct'))
			return false;
		document.getElementById('AddProduct').appendChild(pp);
	}
}