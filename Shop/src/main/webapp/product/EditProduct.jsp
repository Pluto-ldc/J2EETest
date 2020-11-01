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
		<title>商品信息修改</title>
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
					<h1 class="bg-info" style="text-align: center; padding: 15px;">商品管理系统</h1>
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
					<form class="form-inline" action="updateProduct.do" method="post" onsubmit="return check()">
					<input hidden="hidden" name="id" value="${product.id}" />
						<table class="table  table-bordered" style="width:100%;">
							<tr class="bg-primary">
								<td style="text-align: center;" colspan="2"><span style="font-size: 20px;">商品信息修改</span></td>
							</tr>
							<tr class="active">
								<td style="width: 120px; vertical-align: middle">商品名</td>
								<td><input type="text" style="width: 100%;" id="name" placeholder="请输入商品名" class="form-control" name="name" value="${product.name }"></td>
							</tr>
							<tr class="active">
								<td style="width: 120px; vertical-align: middle">价格</td>
								<td><input type="number" style="width: 100%;" id="price" placeholder="请输入价格" class="form-control" name="price" value="${product.price }"></td>
							</tr>
							<tr class="active">
								<td style="width: 120px; vertical-align: middle">库存</td>
								<td><input type="number" style="width: 100%;" id="sum" placeholder="请输入库存" class="form-control" name="sum" value="${product.sum }"></td>
							</tr>
							<tr class="active">
								<td style="width: 120px; vertical-align: middle">描述</td>
								<td><textarea name="description" class="form-control" style="width:100%;height:100px">${product.description }</textarea></td>
							</tr>
							<!-- <tr class="active">
								<td style="width: 120px; vertical-align: middle">商品图片</td>
								<td>
									<input type="file" name="productPic" class="form-control" id="" />
								</td>
							</tr> -->
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
				var price = document.getElementById("price");
				var sum = document.getElementById("sum");
				if (name.value == "") {
					alert("请输入商品名！");
					return false;
				}
				if (price.value == "") {
					alert("请输入价格！");
					return false;
				}
				if (sum.value == "") {
					alert("请输入库存！");
					return false;
				}
				return true;
			}
		</script>
</html>
