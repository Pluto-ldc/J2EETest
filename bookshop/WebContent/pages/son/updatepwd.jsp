<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/UpdateUserPwd"
		method="post">
		<table>
			<tr>
				<td>原密码：</td>
				<td><input type="password" name="passWordOld"></td>
			</tr>
			<tr>
				<td>新密码：</td>
				<td><input type="password" name="passWord"></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" name="passWord2"></td>
			</tr>
			<tr>
				<input hidden name="userId" value="${user.id }">
				<td><input type="submit" value="修改"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>