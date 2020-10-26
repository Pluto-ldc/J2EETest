<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
</head>
<body>
	<h1>用户注册</h1>
	<form action="${pageContext.request.contextPath }/RegisterServlet"
		method="post">

		<h4>
			<font color="red">${msg }</font>
		</h4>
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="passWord"></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" name="passWord2"></td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><input type="text" name="sex"></td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>电话：</td>
				<td><input type="text" name="mobile"></td>
			</tr>
			<tr>
				<td><input type="submit" value="注册"></td>
				<td><input type="reset" value="重置"></td>
				<td><a href="${pageContext.request.contextPath }/login.jsp"><input
						type="button" value="登陆"></a></td>
			</tr>
		</table>
	</form>
</body>
</html>