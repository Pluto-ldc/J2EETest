<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="/Shop/css/bootstrap.css">
	<!-- 引入图标库css -->
	<link rel="stylesheet" href="/Shop/css/font-awesome.min.css">
<title>商品管理</title>
<style type="text/css">
th {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">
						<img alt="Brand" src="/Shop/img/logo.png" width="80px">
					</a>
					<ul class="nav navbar-nav">
						<li class="active"><a href="/Shop/product/list.do">商品维护 <span
								class="sr-only">(current)</span>
						</a></li>
						<li><a href="/Shop/product/analysis.do">数据分析</a></li>
						<li><a href="/Shop/user/list.do">账户维护</a></li>
					</ul>
				</div>
				<p class="navbar-text navbar-right">
					<ul class="nav navbar-nav">
					<li><a href="/Shop/Login.jsp">退出 </a></li>
				</p>
			</div>
		</nav>
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
			<div class="col-md-12">
				<div class="panel panel-success">
				  <div class="panel-heading">
				  		<c:set var="product" value="${requestScope.product}"></c:set>
				    <h3 class="panel-title">商品名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.name }</h3>
				  </div>
				  <div class="panel-body">
				  	<table class="table">
				  		<tr>
				  			<td colspan="4" style="text-align: center;">
				  				<img class="img-thumbnail" style="width: 350px; height: 200px;" src="/Shop/${product.pic_url }"/>
				  				
				  			</td>
				  		</tr>
				  		<tr>
				  			<td>价格:</td>
				  			<td>${product.price}</td>
				  			<td>库存:</td>
				  			<td>${product.sum}</td>
				  		</tr>
				  		<tr>
				  			<td>状态:</td>
				  			<td><c:if test="${product.status == 0 }">
										<span class="label label-success">上架</span>
									</c:if> <c:if test="${product.status == 1 }">
										<span class="label label-warning">下架</span>
									</c:if></td>
				  			<td>上架时间:</td>
				  			<td><fmt:formatDate value="${product.addDate }"
										pattern="yyyy-MM-dd" /></td>
				  		</tr>
				  		<tr>
				  			<td>商品描述</td>
				  			<td colspan="3">
				  				${product.description}
				  			</td>
				  		</tr>
				  		<tr>
				  			<td style="text-align: center;" colspan="2">
				  				<a href="#" onclick="history.back()" style="text-align: center;" class="btn btn-info"><i class="fa fa-chevron-circle-left"> 返回</i></a>
				  			</td>
							<td style="text-align: center;" colspan="2">
								<a href="/Shop/product/list.do" style="text-align: center;" class="btn btn-success"><i class="fa fa-shopping-cart"> 加入购物车</i></a>
							</td>
				  		</tr>
				  	</table>
				  </div>
				</div>				
			</div>
		</div>
	</div>

</body>
</html>
