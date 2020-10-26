<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/EditUserInfo"
		method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="userName" value="${user.userName }"></td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="name" value="${user.name }"></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><input type="text" name="sex" value="${user.sex }"></td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input type="text" name="email" value="${user.email }"></td>
			</tr>
			<tr>
				<td>电话：</td>
				<td><input type="text" name="mobile" value="${user.mobile }"></td>
				<input hidden name="userId" value="${user.id }">
			</tr>
			<tr>
				<td><input type="submit" value="修改"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>