<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<form action="../Product/ProductSearch" method="post">
	<div>
		<span>产品搜索：</span>
		<input name="keyWords" id="textbox2" type="text" maxlength="100"
			value="请输入关键字..." onfocus="if(this.value=='请输入关键字...')this.value=''"
			onblur="if(this.value=='')this.value='请输入关键字...'" /> <input
			id="check2" type="submit" value="搜索" />
	</div>
</form>
