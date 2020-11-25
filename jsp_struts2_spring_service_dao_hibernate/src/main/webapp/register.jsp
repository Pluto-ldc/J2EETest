<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html lang="zh-cn">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" type="text/css" href="https://file.plutoldc.xyz/bootstrap-4.5.0/css/bootstrap.min.css" />
		<title>注册</title>
	</head>
	<body class="text-center">
		<div class="container" style="margin-top: 10%;">
			<div class="row justify-content-center">
				<div class="col-4">
					<form action="register.action" method="post">
						<h1 class="h3 mb-3 font-weight-normal">Register</h1>
						<s:if test="msg != null">
							<p class="text-danger">
								<s:property value="msg" />
							</p>
						</s:if>
						<p><input type="text" name="user.userName" class="form-control" placeholder="Username" required autofocus></p>
						<p> <input type="password" name="user.passWord" class="form-control" placeholder="Password" required></p>
						<p>
							<button class="btn btn-lg btn-success btn-block" type="submit">Register</button><br>
							<a href="./"><button class="btn btn-lg btn-primary btn-block" type="button">Back To Login</button></a>
						</p>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
