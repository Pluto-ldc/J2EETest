<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<title>���Ϲ���ϵͳ</title>
	<link href="css/bookstore.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="js/checkQuantity.js"></script>
</head>
<body>
			<h3>����ͼ���Ƽ���</h3>
		
		<s:iterator value="#request['books']" var="book">
					<table width="600" border="0">
						<tr>
							<td width="200" align="center">
								<img src="/bookstore/picture/<s:property value="#book.picture"/>">
							</td>
							<td>
								<table>
									<tr>
										<td>
										����:<s:property value="#book.bookname"/><br>
										</td>
									</tr>
									<tr>
										<td>
							�۸�:<s:property value="#book.price"/>Ԫ
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
			<form action="addToCart.action" method="post" onsubmit="return check(this)">
				����:
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

</body>
</html>
