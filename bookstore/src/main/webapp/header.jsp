<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<script type="text/javascript" src="https://file.plutoldc.xyz/jquery-3.5.1/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="https://file.plutoldc.xyz/bootstrap-4.5.0/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="https://file.plutoldc.xyz/bootstrap-4.5.0/css/bootstrap.min.css" />
		<!--设置页面的宽度随着使用者的设备变化二变化 -->
		<meta name="viewport" content="width=device-width,initial-scal=1">
		<title></title>
	</head>
	<body>
		<div class="container mt-3 text-center">
			<div class="row">
				<div class="col-3" style="font-size: 10px;">
					<div class="row d-flex justify-content-center align-items-center">
						<a class="" href="#"> <img class="img-fluid" src="https://file.plutoldc.xyz/bookstore/img/logo_dear.gif">
						</a>
					</div>
					<div class="row d-flex justify-content-center align-items-center">
						<span>书店提供专业服务</span>
					</div>
				</div>
				<div class="col-6 d-flex justify-content-center align-items-end mb-4">
					<div class="row">
						<div class="col">
							<header>
								<nav style="font-size: 19px;">
									<a class="p-4 text-dark" target="_self" href="${pageContext.request.contextPath}/index.jsp">首页</a>
									<s:if test="#session.user==null">
										<a class="p-4 text-dark" target="_self" href="${pageContext.request.contextPath}/login.jsp">登录</a>
									</s:if>
									<s:else>
										<a class="p-4 text-dark" href="${pageContext.request.contextPath}/logout">注销</a>
									</s:else>
									<a class="p-4 text-dark" target="_self" href="${pageContext.request.contextPath}/register.jsp">注册</a> <a class="p-4 text-dark"
									 href="#">联系我们</a> <a class="p-4 text-dark" href="#">网站地图</a>
								</nav>
							</header>
						</div>
					</div>
				</div>
				<div class="col-3" style="font-size: 15px;">
					<div class="row">
						<div class="col list-inline">
							<s:if test="#session.user!=null">
								<span class="list-inline-item">欢迎您，${user.userName }</span>
							</s:if>
							<span class="list-inline-item"> <img class="img-fluid" src="https://file.plutoldc.xyz/bookstore/img/buy01.jpg">
								<a href="${pageContext.request.contextPath}/showCart.jsp">购物车</a>｜ <a href="#">用户FAQ</a>
							</span>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-6 offset-md-4">
					<form class="form-inline" action="searchBook" method="post">
						<input type="text" size="40" class="form-control" name="bookNameKey" placeholder="请输入图书关键词" required>
						<button type="submit" class="btn btn-primary mb-2 ml-3">搜索</button>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
