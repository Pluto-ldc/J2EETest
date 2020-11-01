<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
		<title>登录</title>
	</head>
	<body class="text-center">
		<div class="container" style="margin-top: 10%;">
			<div class="row justify-content-center">
				<div class="col-4">
					<form action="login.action" method="post">
						<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
						<p><input type="text" name="user.userName" id="inputEmail" class="form-control" placeholder="Username" required
							 autofocus></p>
						<p> <input type="password" name="user.passWord" id="inputPassword" class="form-control" placeholder="Password"
							 required></p>
						<p><button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button></p>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
