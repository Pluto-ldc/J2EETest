<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加图书</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/AddBookServlet"
		method="post">

		<h4>
			<font color="red">${msg }</font>
		</h4>
		<table>
			<tr>
				<td>名称：</td>
				<td><input type="text" name="bookName"></td>
			</tr>
			<tr>
				<td>分类：</td>
				<td><input type="text" name="bookType"></td>
			</tr>
			<tr>
				<td>描述：</td>
				<td><input type="text" name="bookNote"></td>
			</tr>
			<tr>
				<td>作者：</td>
				<td><input type="text" name="author"></td>
			</tr>
			<tr>
				<td>价格：</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td><input type="submit" value="增加"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>