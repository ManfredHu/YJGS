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
function Ajax(PostData, tagA, tagI, servlet) {
	var xmlhttp;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			tagA.setAttribute("href", xmlhttp.responseText);
			tagI.setAttribute("src", xmlhttp.responseText);
		}
	}
	xmlhttp.open("POST", servlet, true);
	xmlhttp.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	xmlhttp.send(PostData);

}

function changePic(picID) {
	var picLink = document.getElementById("picLink");
	var img = picLink.getElementsByTagName("img")[0];
	var postData = "picID=" + picID;
	Ajax(postData, picLink, img, "GetAjaxPic");
}