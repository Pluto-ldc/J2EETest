<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0;
	padding: 0;
}

a {
	color: black;
	text-decoration: none;
}

html, body {
	width: 100%;
	height: 100%;
	background: linear-gradient(to right bottom, rgba(216, 193, 12, 0.26),
		rgba(10, 209, 223, 0.253));
}

table, tr, td {
	text-align: center;
	font-size: 20px;
}

.main {
	width: 75%;
	height: 90%;
	margin: 0 auto;
	text-align: center;
}
</style>
</head>
<body>
	<table width="100%" height="100%">
		<tr height='10%'>
			<td>
				<h1 style="text-align: center;">图书管理系统</h1> <c:set var="say"
					value="先生"></c:set> <c:if test="${user.sex=='女'}">
					<c:set var="say" value="女士"></c:set>
				</c:if>
				<p align="right">
					欢迎您，${user.name}${say}&nbsp;&nbsp;<a
						href="${pageContext.request.contextPath }/LayoutServlet">退出登录</a>
				</p>
			</td>
		</tr>
		<tr>
			<td>
				<table height="100%" width="100%">
					<tr>
						<td width="10%">
							<table height="80%" width="100%">

								<c:if test="${user.isAdmin==1 }">
									<tr>
										<td><a href="main.jsp?son=addbook">增加图书</a></td>
									</tr>
								</c:if>
								<tr>
									<td><a href="../FindAllBooksServlet">图书列表</a></td>
								</tr>
								<tr>
									<td><a href="../PageCart">购物车</a></td>
								</tr>
								<tr>
									<td><a href="../PageTransaction">交易记录</a></td>
								</tr>
								<tr>
									<td><a href="main.jsp?son=perinfo">个人信息</a></td>
								</tr>
								<tr>
									<td><a href="main.jsp?son=updatepwd">修改密码</a></td>
								</tr>
							</table>
						</td>
						<td>
							<div class="main">
								<c:if test="${empty param.son }">
									<br>
									<br>
									<br>
									<br>
									<br>
									<br>
									<br>
									<h1>欢迎来到图书电子商城</h1>
								</c:if>
								<c:if test="${!empty param.son }">
									<jsp:include page="./son/${param.son }.jsp"></jsp:include>
								</c:if>
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>