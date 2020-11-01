<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<!-- 引入BootStrap0 -->
		<link rel="stylesheet" href="/Shop/css/bootstrap.min.css">
		<title></title>
		<style>
			/* div{
				border: 1px solid red;
			} */
		</style>
	</head>

	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<h1 class="bg-primary" style="text-align: center;">用户注册</h1>
				</div>
				<div class="col-md-2"></div>
			</div>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<form action="/Shop/admin/register.do" method='post' onsubmit="return check()">
					<!-- 登录表单 -->
						<table class="table">
							<tr class="active">
								<td>用户名</td>
								<td><input class="form-control" type="text" id="userName" name="name" placeholder="请输入用户名"></td>
								<td></td>
							</tr>
							<tr class="active">
								<td>密码</td>
								<td><input class="form-control" type="password" id="passWord" name="pwd" placeholder="请输入密码"></td>
								<td></td>
							</tr>
							<tr class="active">
								<td>手机</td>
								<td><input class="form-control" type="text" name="mobile" placeholder="请输入手机"></td>
								<td></td>
							</tr>
							<tr class="active">
								<td>邮箱</td>
								<td><input class="form-control" type="text" name="email" placeholder="请输入邮箱"></td>
								<td></td>
							</tr>
							<!-- <tr class="active">
								<td>验证码</td>
								<td><input class="form-control" type="text" name="safeCode" id=""></td>
								<td></td>
							</tr> -->
							<tr class="active">
								<td colspan="2" style="text-align: center;">
									<a href="/Shop/Login.jsp"><input class="btn btn-info" type="button" value="返回登录"></a>
									<input class="btn btn-success" type="submit" value="&nbsp;&nbsp;注&nbsp;&nbsp;册&nbsp;&nbsp;">
								</td>
								<td></td>
							</tr>
							<tr>
								<td colspan="3" align="center"><font color="red">${requestScope.msg }</font></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		function check() {
			var userName=document.getElementById("userName");
			var passWord=document.getElementById("passWord");
			if(userName.value==""||passWord==""){
				alert("用户名或密码不能为空！");
				return false;
			}else{
				return true;
			}
		}
	</script>
</html>
