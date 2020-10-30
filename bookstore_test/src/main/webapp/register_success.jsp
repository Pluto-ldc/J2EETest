<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<title>网上书店</title>
	<link href="css/bookstore.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="content">
		<div class="left">
			<div class="list_box">
				<div class="list_bk"></div>
			</div>
		</div>
		<div class="right">
			<div class="right_box">
				<font face="宋体"></font><font face="宋体"></font><font face="宋体"></font><font face="宋体"></font>
				<div class="banner"></div>
				<div class="info_bk1">
					<div align="center">
						您好！用户 <s:property value="user.username"/> 欢迎您注册成功！
						<a href="login.jsp">登录</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
