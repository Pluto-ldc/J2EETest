<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head><title>注册页面</title></head>
	<body>
		<form action="register.action"method="post">
			用户注册<br>
			姓名:<input type="text" name="user.username"size="20"/><br>
			密&nbsp;&nbsp;码:<input type="password" name="user.password"size="20"/><br>
			<input type="submit" value="提交"/>
		</form>
	</body>
</html>