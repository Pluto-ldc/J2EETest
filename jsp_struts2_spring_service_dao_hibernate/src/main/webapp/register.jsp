<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html lang="zh-cn">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
		<title>注册</title>
	</head>
	<body class="text-center">
		<div class="container" style="margin-top: 10%;">
			<div class="row justify-content-center">
				<div class="col-4">
					<form action="register.action" method="post">
						<h1 class="h3 mb-3 font-weight-normal">Register</h1>
						<p><input type="text" name="user.userName" class="form-control" placeholder="Username" required autofocus></p>
						<p> <input type="password" name="user.passWord" class="form-control" placeholder="Password" required></p>
						<p>
							<button class="btn btn-lg btn-success btn-block" type="submit">Register</button><br>
							<a href="./login.jsp"><button class="btn btn-lg btn-primary btn-block" type="button">Back To Login</button></a>
						</p>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
