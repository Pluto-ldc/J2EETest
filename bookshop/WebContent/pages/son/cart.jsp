<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${!empty cartList }">
<table border="1" width="100%">
		<tr align="center">
			<td><b>编号</b></td>
			<td><b>名称</b></td>
			<td><b>分类</b></td>
			<td><b>描述</b></td>
			<td><b>作者</b></td>
			<td><b>价格</b></td>
			<td><b>时间</b></td>
			<td><b>购物车</b></td>

		</tr>
		<c:set var="id" value="${carts[1]*(carts[2]-1) }"/>
		<c:forEach items="${carts[0]}" var="cart" varStatus="status">

			<tr onmouseover="this.style.backgroundColor = 'white'"
				onmouseout="this.style.backgroundColor = '#F5FAFE';">
				
				<c:set var="id" value="${id+1 }"/>
				<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="11%">${id}</td>
				<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="11%">${cart.book.bookName}</td>
				<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="11%">${cart.book.bookType}</td>
				<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="11%">${cart.book.bookNote}</td>
				<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="11%">${cart.book.author}</td>
				<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="11%">${cart.book.price}</td>
				<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="20%"><font size="3">${cart.dateString}</font></td>
				<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="12%"><input id="box${cart.book.id}" onclick="AddorRomove(${cart.book.id })"  type="button" value="移除购物车" /></td>
			</tr>
		</c:forEach>
		<tr>
			<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="11%">总价</td>
			<td colspan="6" style="CURSOR: hand; HEIGHT: 22px" align="center" width="11%">${carts[4] }</td>
				<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="12%">
					<a href="${pageContext.request.contextPath}/CartSubmit">
						<input type="button" value="提交订单" /></a>
				</td>
		</tr>
	</table>
	<p align="center">
		<font size="3" color="blue"> <a
			href="../PageCart?pageIndex=${ carts[2]-1}">上一页</a> <c:forEach
				var="pageIndex" varStatus="status" begin="1"
				end="${ carts[3]}">
				<a href="../PageCart?pageIndex=${pageIndex}">${pageIndex}</a>
			</c:forEach> <a href="../PageCart?pageIndex=${ carts[2]+1}">下一页</a>
		</font>
	</p>
</c:if>
<c:if test="${empty cartList }">
	<h3>购物车是空的哦</h3>
</c:if>
</body>
<script type="text/javascript">
	
		function AddorRomove(bookId) {
			var buttonText = document.getElementById("box"+bookId).value;//绑定事件
			if(buttonText=='移除购物车'){
				let data = 'bookId='+bookId,
		      　　　　url = '${pageContext.request.contextPath}/RemoveCartServlet',
		      　　　　xhr = new XMLHttpRequest();
		      　　xhr.open('post', url);
		          //设置header
		      　　xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		      　　xhr.send(data);
		      　　xhr.onreadystatechange = function () {
		      　　　　if (xhr.readyState === 4 && ( xhr.status === 200 || xhr.status === 304 )){
		      　　　　　　console.log(xhr.responseText);
		      　　　　}
		      　　}
		      	alert("图书移除购物车成功！");
		      	location.reload();
			}
		}
	</script>
</html>