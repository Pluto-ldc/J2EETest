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
					<div class="col-12 m-5 p-3">
						<form action="login" method="post">
							<h1 class="h3 mb-4 font-weight-normal">登陆</h1>
							<s:if test="message != null">
								<p class="text-danger">
									<s:property value="message" />
								</p>
							</s:if>
							<div class="form-inline mb-4">
								<label class="col-4">用&nbsp;&nbsp;户&nbsp;&nbsp;名：</label> <input type="text" name="user.userName" class="form-control col-8"
								 placeholder="请输入用户名" required autofocus>
							</div>
							<div class="form-inline mb-4">
								<label class="col-4">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
								<input type="password" name="user.passWord" class="form-control col-8" placeholder="请输入密码" required>
							</div>
							<div class="form-inline">
								<div class="col-2"></div>
								<input class="btn btn-primary col-3" type="submit" value="登陆" />
								<div class="col-2"></div>
								<input class="btn btn-warning col-3" type="reset" value="重置" />
								<div class="col-2"></div>
							</div>
						</form>
					</div>
				</div>
				<div class="col-3"></div>
			</div>
		</div>
		<jsp:include page="footer.html"></jsp:include>
	</body>
</html>
