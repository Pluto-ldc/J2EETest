<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
	<head>
		<title>网上购书系统</title>
		<link href="css/bookstore.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/checkQuantity.js"></script>
	</head>
	<body>
		<h3>最新图书推荐：</h3>

		<s:iterator value="#request['books']" var="book">
			<table width="600" border="0">
				<tr>
					<td width="200" align="center">
						<img src="/bookstore/picture/<s:property value=" #book.picture" />">
					</td>
					<td>
						<table>
							<tr>
								<td>
									书名:
									<s:property value="#book.bookname" /><br>
								</td>
							</tr>
							<tr>
								<td>
									价格:
									<s:property value="#book.price" />元
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

									<form action="addToCart.action" method="post" onsubmit="return check(this)">
										数量:
										<input type="text" name="quantity" value="0" size="4" />
										<input type="hidden" name="bookid" value="<s:property value=" #book.bookid" />">
										<input type="image" name="submit" src="/bookstore/picture/buy.gif" />
									</form>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</s:iterator>

	</body>
</html>
