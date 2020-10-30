<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
	<head>
		<title>网上书店</title>
		<link href="css/bookstore.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="head">
			<div class="head_left">
				<a href="#">
					<img hspace="11" src="picture/logo_dear.gif" vspace="5">
				</a>
				<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;书店提供专业服务
			</div>
			<div class="head_right">
				<div class="head_right_nei">
					<div class="head_top">
						<div class="head_buy">
							<s:if test="#session.user!=null">
								欢迎您，
								<s:property value="#session.user.username" />
							</s:if>
							<strong>
								<a href="/bookstore/showCart.jsp">
									<img height="15" src="picture/buy01.jpg" width="16">&nbsp;购物车
								</a>
							</strong> |
							<a href="#">用户FAQ</a>
						</div>
					</div>
					<div class="head_middle">
						<a class="title01" href="index.jsp">
							<span>&nbsp;&nbsp;首页&nbsp;&nbsp;</span>
						</a>
						<s:if test="#session.user==null">
							<a class="title01" href="login.jsp">
								<span>&nbsp;&nbsp;登录&nbsp;&nbsp;</span>
							</a>
						</s:if>
						<s:else>
							<a class="title01" href="logout.action">
								<span>&nbsp;&nbsp;注销&nbsp;&nbsp;</span>
							</a>
						</s:else>
						<a class="title01" href="register.jsp">
							<span>&nbsp;&nbsp;注册&nbsp;&nbsp;</span>
						</a>
						<a class="title01" href="#">
							<span>&nbsp;联系我们&nbsp;&nbsp;&nbsp;</span>
						</a>
						<a class="title01" href="#">
							<span>&nbsp;网站地图&nbsp;&nbsp;&nbsp;</span>
						</a>
					</div>
					<div class="head_bottom">
						<form action="searchBook.action" method="post">
							<input type="text" name="bookname" size="50" align="middle" />
							<input type="image" name="submit" src="picture/search02.jpg" align="top" style="width: 48px; height: 22px" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
