<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<title>�������</title>
	<link href="css/bookstore.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="js/checkQuantity.js"></script>
</head>
<body>
	<jsp:include page="head.jsp"/>
	<div class="content">
		<div class="left">
			<div class="list_box">
				<div class="list_bk">
				<!-- ������ΪbrowseCatalog���߼�actio ���������������ҳ���� -->
					<s:action name="browseCatalog" executeResult="true"/>
				</div>
			</div>
		</div>
		<div class="right">
			<div class="right_box">
			<s:set var="items" value="#session.cart.items"/>
			<s:if test="#items.size!=0">
			�����ﳵ�е�ͼ�飺<br>
			<table id="td" cellSpacing="2" cellSpacing="5" width="95%" align="center" border="0">
			<tr>
			<td bgcolor="rgb(238,238,238)" align="center" width="50%" height="12">����</td>
			<td bgcolor="rgb(238,238,238)" align="center" width="15%">����</td>
			<td bgcolor="rgb(238,238,238)" align="center" width="15%">����</td>
			<td bgcolor="rgb(238,238,238)" align="center" width="20%" colspan="2">
				<font color="gray">����</font>
				</td>
				</tr>
				<s:iterator value="#items">
				<form action="updateCart" method="post"  onsubmit="return check(this)">
				<tr>
				<td>
				<s:property value="value.book.bookname"/>
				</td>
				<td>
				<s:property value="value.book.price"/>
				</td>
				<td>
<input type="text" name="quantity" value="<s:property value="value.quantity"/>"size="4"/>
<input type="hidden" name="bookid" value="<s:property value="value.book.bookid"/>"/>
				</td>
				
				<td valign="middle">
					<input type="submit" value="����"/>
				</form>	
				
				<td>
			<form action="deleteBook.action">
			<input type="hidden" name="bookid" value="<s:property value="value.book.bookid"/>"/>
			<input type="submit" value="ɾ��">
			</form>
			</td>
			</tr>
				</s:iterator>				
			</table>
			<hr/>
		���ѽ�<s:property value="#session.cart.totalPrice"/>Ԫ
		<a href="checkout.action"><img src="/bookstore/picture/count.gif"/></a>
			</s:if>
			<s:else>
			�Բ�������û��ѡ��ͼ�飡
			</s:else>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"/>
</body>
</html>
