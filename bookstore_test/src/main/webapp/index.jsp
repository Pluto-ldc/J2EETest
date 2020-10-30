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
				<!-- 调用名为browseCatalog的逻辑Action，并将结果包含到本页面中 -->
					<s:action name="browseCatalog" executeResult="true"/>
				</div>
			</div>
		</div>
		<div class="right">
			<div class="right_box">
				<font face="宋体"></font><font face="宋体"></font><font face="宋体"></font><font face="宋体"></font>
				<div class="banner"></div>
				<div align="center">
					<s:action name="newBook" executeResult="true"/>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"/>
</body>
</html>
