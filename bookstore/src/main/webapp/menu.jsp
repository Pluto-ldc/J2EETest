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
		<nav class="col-12 d-md-block bg-light mt-5">
			<div class="sidebar-sticky pt-3">
				<h6 class="text-muted">
					<span>图书分类</span>
				</h6>
				<ul class="nav flex-column mb-2">
					<s:iterator value="#request['catalogs']" var="catalog">
						<li class="nav-item"><a class="nav-link" href="browseBookPaging?catalogId=<s:property value=" #catalog.catalogId" />"
							target="_self">
							<s:property value="#catalog.catalogName" />
							</a></li>
					</s:iterator>
				</ul>
			</div>
		</nav>
	</body>
</html>
