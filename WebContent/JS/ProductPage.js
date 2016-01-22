var curParamNum = 1;
var maxParamNum = 10; // 最大参数个数
function addParam() {
	var paramTableBody;
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
	paramTableBody = document.getElementById("paramTableBody");
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
	deleteButton.onclick = function() {
		deleteParam(this);
	};
	deleteButton.className = "deletebtn";
	// 插入节点，组成表格
	paramTableBody.appendChild(newTr);
	newTr.appendChild(newTd1);
	newTr.appendChild(newTd2);
	newTr.appendChild(newTd3);
	newTd1.appendChild(newInput1);
	newTd2.appendChild(newInput2);
	newTd3.appendChild(deleteButton);
}
function deleteParam(thisA) {
	var paramTableBody;
	var thisRow;
	if (curParamNum == 1) {
		alert('至少保留一个参数，无法继续删除');
		return;
	} else {
		curParamNum -= 1;
	}
	// 获取表格以及当前的行节点
	paramTableBody = document.getElementById("paramTableBody");
	thisRow = thisA.parentNode.parentNode;
	// 移除当前行节点
	paramTableBody.removeChild(thisRow);
}
function uploading(one) {
	var allowExt = ".jpg,.jpeg,.png,.bmp,.gif"; // 支持的扩展名
	var fileExt = one.value.substr(one.value.lastIndexOf('.')).toLowerCase();
	if (allowExt.indexOf(fileExt) == -1) {
		alert("上传图片的类型错误！仅支持jpg,gif,png,bmp,png格式图片");
		return;
	} else {
		var ff = document.getElementById('PicUpload');
		if (ff != null) {
			ff.submit();
		}
	}
}
function deletePic(){
	var picList = document.getElementById('picList');
	var aList = picList.getElementsByTagName('a');
	for(var i=0;i<aList.length;i++){
		aList[i].onclick = function(){
			return confirm("确定删除吗？");
		}
	}
}
addLoadEvent(deletePic);