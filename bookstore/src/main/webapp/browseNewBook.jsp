<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<s:iterator value="#request['books']" var="book">
			<div class="row">
				<table class="table table-striped m-1">
					<tr>
						<td width="30%" rowspan="4"><img class="img-fluid" src="<s:property value="#book.picture" />">
						</td>
						<td align="right" colspan="2">书名:</td>
						<td align="left" colspan="2">
							<s:property value=" #book.bookName" />
						</td>
					</tr>
					<tr>
						<td align="right" colspan="2" width="35%">价格:</td>
						<td align="left" colspan="2">¥
							<s:property value=" #book.price" />
						</td>
					</tr>
					<tr>
						<form action="addToCart" method="post">
							<td style="vertical-align: middle;" width="14%">数量:</td>
							<td><input type="number" class="form-control" name="quantity" value="1" /></td>
							<td colspan="2"><input type="hidden" name="bookId" value="<s:property value=" #book.bookId" />"> <input class="btn btn-primary"
								 type="submit" value="购买" /></td>
						</form>
					</tr>
				</table>
			</div>
		</s:iterator>
	</body>
</html>
