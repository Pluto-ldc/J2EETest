<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/booklist.js"></script>
</head>
<body>
	<p>
	<form method="post" action="../SerachBook">
		<input type="text" name="keyWord"> <input type="submit"
			value="搜索">
	</form>
	</p>
	<table border="1" width="100%">
		<tr>
			<th>编号</th>
			<th>名称</th>
			<th>分类</th>
			<th>描述</th>
			<th>作者</th>
			<th>价格</th>
			<th>购物车</th>
			<c:if test="${user.isAdmin==1 }">
				<th>操作</th>
			</c:if>
		</tr>
		<c:set var="id" value="${bookDataList[1]*(bookDataList[2]-1) }" />
		<c:forEach var="book" items="${bookDataList[0] }">
			<tr>
				<c:set var="id" value="${id+1 }" />
				<td>${id }</td>
				<td>${book.bookName }</td>
				<td>${book.bookType }</td>
				<td>${book.bookNote}</td>
				<td>${book.author }</td>
				<td>${book.price }</td>
				<td><input id="box${book.id}"
					onclick="AddorRomove(${book.id })" type="button" value="加入购物车"></td>
				<c:if test="${user.isAdmin==1 }">
					<td><a href=""><input type="button" value="修改"></a>&nbsp;
						<input onclick="deleteBook('${book.id }','${book.bookName }')"
						type="button" value="删除"></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
	<p align="center">
		<font size="3" color="blue"> <a
			href="../PageBook?pageIndex=${ bookDataList[2]-1}">上一页</a> <c:forEach
				var="pageIndex" varStatus="status" begin="1"
				end="${ bookDataList[3]}">
				<a href="../PageBook?pageIndex=${pageIndex}">${pageIndex}</a>
			</c:forEach> <a href="../PageBook?pageIndex=${ bookDataList[2]+1}">下一页</a>
		</font>
	</p>
</body>
</html>