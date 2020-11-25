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
		<title>网上书店</title>
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div class="container text-center align-items-center" style="height: 575px;">
			<div class="row justify-content-center">
				<div class="col-3">
					<s:action name="browseCatalog" executeResult="true" />
				</div>
				<div class="col-5">
					<div class="col-12 mt-3">
						<div style="margin-top: 75px;">
							<h3 class="text-primary">订单添加成功！</h3>
							<h5 style="text-align: left; text-indent: 2em;" class="text-info m-2">
								<s:property value="#session.user.username" />,您的订单已经下达，订单号为
								<s:property value="#request.order.orderid" />,我们会在3日内寄送图书给您！
							</h5>
							<div class="row m-2">
								<div class="col-2"></div>
								<a class="btn btn-primary col-3" href="${pageContext.request.contextPath}/index.jsp">继续购物</a>
								<div class="col-2"></div>
								<a href="${pageContext.request.contextPath}/logout" class="btn btn-danger col-3">注销登录</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-3"></div>
			</div>
		</div>
		<jsp:include page="footer.html"></jsp:include>
	</body>
</html>
