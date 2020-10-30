<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
	<head>
		<title>网上购书系统</title>
		<link href="css/bookstore.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<ul class=point02>
			<li>
				<strong>图书分类</strong>
			</li>
			<s:iterator value="#request['catalogs']" var="catalog">
				<li>
					<a href="browseBookPaging.action?catalogId=<s:property value=" #catalog.catalogId" />"target=_self>
					<s:property value="#catalog.catalogName" />
					</a>
				</li>
			</s:iterator>
		</ul>
	</body>
</html>
