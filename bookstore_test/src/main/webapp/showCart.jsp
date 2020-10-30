<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
	<head>
		<title>网上书店</title>
		<link href="css/bookstore.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/checkQuantity.js"></script>
	</head>
	<body>
		<jsp:include page="head.jsp" />
		<div class="content">
			<div class="left">
				<div class="list_box">
					<div class="list_bk">
						<!-- 调用名为browseCatalog的逻辑actio 并将结果包含到本页面中 -->
						<s:action name="browseCatalog" executeResult="true" />
					</div>
				</div>
			</div>
			<div class="right">
				<div class="right_box">
					<s:set var="items" value="#session.cart.items" />
					<s:if test="#items.size!=0">
						您购物车中的图书：<br>
						<table id="td" cellSpacing="2" cellSpacing="5" width="95%" align="center" border="0">
							<tr>
								<td bgcolor="rgb(238,238,238)" align="center" width="50%" height="12">书名</td>
								<td bgcolor="rgb(238,238,238)" align="center" width="15%">定价</td>
								<td bgcolor="rgb(238,238,238)" align="center" width="15%">数量</td>
								<td bgcolor="rgb(238,238,238)" align="center" width="20%" colspan="2">
									<font color="gray">操作</font>
								</td>
							</tr>
							<tr>
								<s:iterator value="#items">
									<form action="updateCart" method="post" onsubmit="return check(this)">
										<table>
											<tr>
												<td>
													<s:property value="value.book.bookName" />
												</td>
												<td>
													<s:property value="value.book.price" />
												</td>
												<td>
													<input type="text" name="quantity" value="<s:property value=" value.quantity" />"size="4"/>
													<input type="hidden" name="bookId" value="<s:property value=" value.book.bookId" />"/>
												</td>
												<td valign="middle">
													<input type="submit" value="更新">
												</td>
											</tr>
										</table>
									</form>
									<td>
										<form action="deleteBook.action">
											<input type="hidden" name="bookId" value="<s:property value=" value.book.bookId" />"/>
											<input type="submit" value="删除">
										</form>
									</td>
								</s:iterator>
							</tr>
						</table>
						消费金额：
						<s:property value="#session.cart.totalPrice" />元
						<a href="checkout.action"><img src="/bookstore_test/picture/count.gif" /></a>
					</s:if>
					<s:else>
						对不起！您还没有选购图书！
					</s:else>
				</div>
			</div>
		</div>
		<jsp:include page="foot.jsp" />
	</body>
</html>
