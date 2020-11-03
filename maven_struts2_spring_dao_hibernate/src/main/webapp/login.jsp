<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录页面</title>
	</head>
	<body>
		<form action="login.action" method="post">
			用户登录<br>
			姓名:<input type="text" name="user.userName"><br>
			密码:<input type="password" name="user.passWord"><br>
			<input type="submit" value="登录">
		</form>
	</body>
</html>