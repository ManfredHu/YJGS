/**
 * 产品类别管理
 */
var canModify = 1;
	var curTypeCache = "";
	function Modify(thisA, typeID) {
		var thisRow = thisA.parentNode.parentNode.parentNode;
		var TDs = thisRow.getElementsByTagName("td");
		//检查当前是否可以修改
		if (canModify == 0) {
			return;
		} else {

			canModify = 0;
		}

		//保存当前的类别名
		curTypeCache = TDs.item(1).innerHTML;

		//替换类别名称节点为input表单
		var TextBox = document.createElement("input");
		TextBox.setAttribute("type", "text");
		TextBox.setAttribute("name", "" + typeID); //设置表单名称为类别ID
		TextBox.setAttribute("value", curTypeCache);
		TextBox.setAttribute("id","typeNameText")
		TDs.item(1).replaceChild(TextBox, TDs.item(1).firstChild);
		
		//生成确定以及取消按钮
		var LinkYes = document.createElement("input");
		var LinkNo = document.createElement("input");

		LinkYes.setAttribute("type", "submit");
		LinkYes.setAttribute("id", "sureBtn");
		LinkYes.setAttribute("value", "确定");
		LinkNo.setAttribute("type", "button");
		LinkNo.setAttribute("id","cancelBtn");
		LinkNo.setAttribute("value", "取消");
		LinkNo.setAttribute("onclick", "Cancel(this," + typeID + ")");
		
		TDs.item(3).replaceChild(LinkYes, TDs.item(3).firstChild);
		TDs.item(3).appendChild(LinkNo);
		TDs.item(1).firstChild.focus();
	}

	function Cancel(thisA, typeID) {

		var thisRow = thisA.parentNode.parentNode;
		var TDs = thisRow.getElementsByTagName("td");

		//设置当前可修改
		canModify = 1;

		//将文本输入框还原为文字
		var typeName = document.createTextNode(curTypeCache);

		TDs.item(1).replaceChild(typeName, TDs.item(1).firstChild);

		//还原修改按钮
		var LinkEdit = document.createElement("a");

		LinkEdit.innerHTML = "修改";
		LinkEdit.setAttribute("href", "#");
		LinkEdit.setAttribute("onclick", "Modify(this," + typeID
				+ ");return false");

		TDs.item(3).replaceChild(LinkEdit, TDs.item(3).firstChild);
		TDs.item(3).removeChild(TDs.item(3).lastChild);
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
	function sureDelete(){
		if(confirm('确定要删除吗？'))
			return true;
		else 
			return false;
	}