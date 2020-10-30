<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<title>网上书店</title>
	<link href="css/bookstore.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="js/checkQuantity.js"></script>
</head>
<body>
		<jsp:include page="head.jsp"/>
		<div class="content">
			<div class="left">
				<div class="list_box">
					<div class="list_bk">
						<s:action name="browseCatalog" executeResult="true"/>
					</div>
				</div>
			</div>
			<div class="right">
				<div class="right_box">
					<s:iterator value="#request['books']" var="book">
					  <table width="600" border="0">
							<tr>
								<td width="200" align="center">
									<img src="/bookstore/picture/<s:property value="#book.picture"/>" width="100"/>
								</td>
								<td valign="top" width="400">
									<table>
										<tr>
											<td>
								书名:<s:property value="#book.bookname"/><br>
											</td>
										</tr>
										<tr>
											<td>
								价格:<s:property value="#book.price"/>元
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<form action="addToCart.action" method="post" onsubmit="return check(this)">
				数量:
				<input type="text" name="quantity" value="0" size="4"/>
				<input type="hidden" name="bookid" value="<s:property value="#book.bookid"/>">
				<input type="image" name="submit" src="/bookstore/picture/buy.gif"/>
			</form>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</s:iterator>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<s:set value="#request.pager" var="pager"/>
					<s:if test="#pager.hasFirst">
						<a href="browseBookPaging.action?currentPage=1">
						首页
						</a>
					</s:if>
					<s:if test="#pager.hasPrevious">
						<a		 href="browseBookPaging.action?currentPage=<s:property value="#pager.currentPage-1"/>">
							上一页
						</a>
					</s:if>
					<s:if test="#pager.hasNext">
						<a		 href="browseBookPaging.action?currentPage=<s:property value="#pager.currentPage+1"/>">
							下一页
						</a>
					</s:if>
					<s:if test="#pager.hasLast">
						<a		 href="browseBookPaging.action?currentPage=<s:property value="#pager.totalPage"/>">
							尾页
						</a>
					</s:if>
					<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					当 前 第 <s:property value="#pager.currentPage"/>页 ，总 共<s:property value="#pager.totalPage"/> 页
				</div>
			</div>
		</div>	
		<jsp:include page="foot.jsp"/>
</body>
</html>