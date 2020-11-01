<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="/Shop/css/bootstrap.min.css"/>
		<title>用户添加</title>
		<style type="text/css">
			th{
				text-align: center;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1 class="bg-info" style="text-align: center; padding: 15px;">用户管理系统</h1>
					<hr/>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
				</div>
				<div class="col-md-6">
				</div>
				<div class="col-md-3">
					<p class="bg-warning" style=" 50%; padding: 10px; text-align: center;">
					<c:if test="${empty admin.name }"><font size="4" color="red">请<a href="/Shop/Login.jsp">登录</a></font></c:if>
					<c:if test="${!empty admin.name }">
						欢迎:【${admin.name }】 &nbsp;&nbsp;&nbsp; <img src="../img/girl.jpg" width="50px" class="img-rounded" alt="" />
					</c:if>
					</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12" style="height: 10px;"></div>
			</div>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8" style="text-align: center;">
					<form class="form-inline" action="updateUser.do" method="post" onsubmit="return check()">
					<input hidden="hidden" name="id" value="${user.id}" />
						<table class="table  table-bordered" style="width:100%;">
							<tr class="bg-primary">
								<td style="text-align: center;" colspan="2"><span style="font-size: 20px;">用户信息修改</span></td>
							</tr>
							<tr class="active">
								<td style="width: 120px; vertical-align: middle">用户名</td>
								<td><input type="text" style="width: 100%;" placeholder="请输入用户名" id="name" class="form-control" name="userName" value="${user.userName }"></td>
							</tr>
							<tr class="active">
								<td style="width: 120px; vertical-align: middle">手机号</td>
								<td><input type="text" style="width: 100%;" placeholder="请输入手机号" id="mobile" class="form-control" name="mobile" value="${user.mobile }"></td>
							</tr>
							<tr class="active">
								<td style="width: 120px; vertical-align: middle">年龄</td>
								<td><input type="number" style="width: 100%;" placeholder="请输入年龄" id="age" class="form-control" name="age" value="${user.age }"></td>
							</tr>
							<tr class="active">
								<td style="width: 120px; vertical-align: middle">邮箱</td>
								<td><input type="text" style="width: 100%;" placeholder="请输入邮箱" class="form-control" name="email" value="${user.email }"></td>
							</tr>
							<tr class="active">
								<td style="width: 120px; vertical-align: middle">地址</td>
								<td><input type="text" style="width: 100%;" placeholder="请输入地址" class="form-control" name="address" value="${user.address }"></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<input type="button" onclick="history.back()" style="width: 200px;" class="btn btn-info" value="返回">
									<input type="submit" style="width: 200px;" class="btn btn-success" value="保存修改">
								</td>
							</tr>
						</table>
					</form>
				</div>
				<div class="col-md-2"></div>
			</div>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4"></div>
				<div class="col-md-4"></div>
			</div>
		</div>

	</body>
	<script type="text/javascript">
			function check() {
				var name = document.getElementById("name");
				var mobile = document.getElementById("mobile");
				var age = document.getElementById("age");
				if (name.value == "") {
					alert("请输入用户名！");
					return false;
				}
				if (mobile.value == "") {
					alert("请输入手机号！");
					return false;
				}
				if (age.value == "") {
					alert("请输入年龄！");
					return false;
				}
				return true;
			}
		</script>
</html>
