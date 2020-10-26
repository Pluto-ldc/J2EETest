<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登陆</title>
</head>
<body>
	<h1>图书电子商城登陆</h1>
	<form action="${pageContext.request.contextPath }/LoginServlet"
		method="post">
		<h4>
			<font color="red">${msg }</font>
		</h4>
		<table border="1">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="passWord"></td>
			</tr>
			<tr>
				<td>验证码：</td>
				<td><input type="text" name="verifyCode"></td>
				<td><a href="" onclick="changeImg()"><img alt="点击切换"
						src="${pageContext.request.contextPath }/verifyCodeServlet"></a>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="登陆"></td>
				<td><input type="reset" value="重置"></td>
				<td><a href="${pageContext.request.contextPath }/register.jsp"><input
						type="button" value="注册"></a></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	function changeImg() {
		document.getElementById("img_checkCode").src="/test03/CheckImgServlet?time="+new Date().getTime();
	}
</script>
</html>