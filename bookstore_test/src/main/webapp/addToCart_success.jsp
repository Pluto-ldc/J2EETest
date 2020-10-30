<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<title>网上书店</title>
	<link href="css/bookstore.css" rel="stylesheet" type="text/css"/>
</head>
<body>
		<jsp:include page="head.jsp"/>
		<div class="content">
			<div class="left">
				<div class="list_box">
					<div class="list_bk">
						<s:action name="browseCatalog" executeResult="true"/>
					</div>
				</div>
			</div>
		<div class="right">
			<div class="right_box">
				<font face="宋体">图书添加成功</font>
				<form action="browseBookPaging.action" method="post">
					<input type="hidden" name="catalogid" value="<s:property value="#session['catalogid']"/>">
					<input type="image" name="submit" src="/bookstore/picture/continue.gif">
				</form>
				<a href="#"><img src="/bookstore/picture/count.gif"></a>
			</div>
		</div>
	</div>	
	<jsp:include page="foot.jsp"/>
</body>
</html>