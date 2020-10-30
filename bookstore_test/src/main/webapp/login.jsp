<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<title>网上书店</title>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
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
				<font face="宋体"></font><font face="宋体"></font><font face="宋体"></font><font face="宋体"></font>
				
				<div class="banner" align="center">
				<font face="宋体" color="#ff0000" size="3">
					<s:property value="message"/>
				</font>
				</div>
				
				<div class="info_bk1">
					<div align="center">
					
						<form action="login.action" method="post" name="login">
							用户登录<br>
							用户名:<input type="text" name="user.username" size="20" id="username"/><br>
							密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="user.password" size="21" id="username"/><br>
							<input type="submit" value="登录"/>
						</form>
						 
						 <!--
						<s:form action="login.action" method="post">
							<s:textfield name="username" label="用户名"/>
							<s:password name="password" label="密码"/>
							<s:submit value="登录"/>
						</s:form>
						-->
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>