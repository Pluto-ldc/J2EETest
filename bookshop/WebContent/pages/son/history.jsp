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
	<table border="1" width="100%">
		<tr align="center">
			<td><b>订单编号</b></td>
			<td><b>订单状态</b></td>
			<td><b>订单时间</b></td>
			<td><b>订单操作</b></td>

		</tr>
		<c:set var="id" value="${transactions[1]*(transactions[2]-1) }" />
		<c:forEach items="${transactions[0]}" var="transaction"
			varStatus="status">

			<tr onmouseover="this.style.backgroundColor = 'white'"
				onmouseout="this.style.backgroundColor = '#F5FAFE';">

				<c:set var="id" value="${id+1 }" />
				<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="11%">${id}</td>
				<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="11%">
					<c:if test="${transaction.status}">已完成</c:if> <c:if
						test="${!transaction.status}">未完成</c:if>
				</td>
				<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="11%">
					<c:if test="${empty transaction.dateString}">待提交</c:if> <font
					size="3"><c:if test="${!empty transaction.dateString}">${transaction.dateString}</c:if></font>
				</td>
				<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="12%"><a
					href="../TransactionInfo?transactionIndex=${id }"><input
						type="button" value="查看详情" /></a></td>
			</tr>
		</c:forEach>
	</table>
	<p align="center">
		<font size="3" color="blue"> <a
			href="../PageTransaction?pageIndex=${ transactions[2]-1}">上一页</a> <c:forEach
				var="pageIndex" varStatus="status" begin="1"
				end="${ transactions[3]}">
				<a href="../PageTransaction?pageIndex=${pageIndex}">${pageIndex}</a>
			</c:forEach> <a href="../PageTransaction?pageIndex=${ transactions[2]+1}">下一页</a>
		</font>
	</p>
	<c:if test="${!empty transactionSelect }">
		<table border="1" width="80%" style="margin: 0 auto; margin-top: 45px;">
			<tr>
				<th>编号</th>
				<th>名称</th>
				<th>分类</th>
				<th>描述</th>
				<th>作者</th>
				<th>价格</th>
			<tr>
				<c:set var="id" value="${0}" />
				<c:forEach var="book" items="${transactionSelect[0]}">
					<tr>
						<c:set var="id" value="${id+1}" />
						<td>${id}</td>
						<td>${book.bookName}</td>
						<c:if test="${empty book.bookType}">
							<td colspan="4">已下架</td>
						</c:if>
						<c:if test="${!empty book.bookType}">
							<td>${book.bookType}</td>
							<td>${book.bookNote}</td>
							<td>${book.author}</td>
							<td>${book.price}</td>
						</c:if>
					</tr>
				</c:forEach>
				<tr>
					<td>总价</td>
					<td colspan="5">${transactionSelect[1]}</td>
				</tr>
		</table>
	</c:if>
</body>
</html>