<%@page import="java.util.Arrays"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.baizhi.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/Shop/css/bootstrap.css">
<!-- 引入图标库css -->
<link rel="stylesheet" href="/Shop/css/font-awesome.min.css">
<script src="/Shop/js/plugins/echarts/echarts.min.js"></script>
<title></title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#"> <img alt="Brand"
						src="/Shop/img/logo.png" width="80px">
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
					<li><a href="/Shop/admin/layout.do">退出 </a></li>
					</p>
			</div>
		</nav>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6"></div>
			<div class="col-md-3">
				<p class="bg-warning" style="padding: 10px; text-align: center;">
					<c:if test="${empty admin.name }">
						<font size="4" color="red">请<a href="/Shop/Login.jsp">登录</a></font>
					</c:if>
					<c:if test="${!empty admin.name }">
						欢迎:【${admin.name }】 &nbsp;&nbsp;&nbsp; <img src="../img/girl.jpg"
							width="50px" class="img-rounded" alt="" />
					</c:if>
				</p>
			</div>
		</div>
		<!-- 图表展示 -->
		<div class="row">
			<div class="col-md-12">

				<div class="panel panel-info">
					<!-- 					  <div class="panel-heading">商品销售量分布图</div>
					 -->
					<div class="panel-heading">电商平台销售趋势</div>
					<div class="panel-body">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5>
									<span style="font-size: 16px;" class="label label-success">电商平台销售趋势</span>
								</h5>
							</div>
							<div class="ibox-content">
								<div id='lineChart' style="height: 300px;"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<a href="AddProduct.jsp" class="btn btn-info btn-xs"> <i
					class=" fa fa-plus-circle"></i> 添加
				</a> <a href="/Shop/product/export.do" class="btn btn-success btn-xs"><i
					class="fa fa-save">导出</i></a>
			</div>
			<div class="col-md-3"></div>
			<div class="col-md-3"></div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form action="/Shop/product/removeBatch.do" method="post"
					onsubmit="return check()">
					<!-- 表格信息 -->
					<table class="table table-hover table-bordered table-condensed">
						<thead>
							<tr class="bg-primary">
								<th>
									<button type="submit" class="btn btn-danger btn-xs">删除</button>
								</th>
								<th>商品名</th>
								<th>价格</th>
								<th>库存</th>
								<th>访问量</th>
								<th>状态</th>
								<th>上架时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="p" items="${requestScope.products }">
								<tr>
									<td><input type="checkbox" name="ids" value="${p.id }"></td>
									<td>${p.name }</td>
									<td>￥${p.price }</td>
									<td><c:if test="${p.sum!=0 }">${p.sum }</c:if> <c:if
											test="${p.sum==0 }">
											<span class="label label-danger">${p.sum }</span>
										</c:if></td>
									<td>${p.visitCount }</td>
									<td><c:if test="${p.status == 0 }">
											<span class="label label-success">上架</span>
										</c:if> <c:if test="${p.status == 1 }">
											<span class="label label-warning">下架</span>
										</c:if></td>
									<td><fmt:formatDate value="${p.addDate }"
											pattern="yyyy-MM-dd" /></td>
									<td><c:if test="${p.status == 1 }">
											<a class="btn btn-success btn-xs"
												href="/Shop/product/changeStatus.do?id=${p.id }&status=0">
												<i class="fa fa-upload">上架</i>
											</a>
										</c:if> <c:if test="${p.status == 0 }">
											<a class="btn btn-warning btn-xs"
												href="/Shop/product/changeStatus.do?id=${p.id }&status=1">
												<i class="fa fa-download">下架</i>
											</a>
										</c:if> <a class="btn btn-danger btn-xs"
										href="/Shop/product/deleteProduct.do?id=${p.id }"> <i
											class="fa fa-trash">删除</i>
									</a> <a class="btn btn-primary btn-xs"
										href="/Shop/product/editProduct.do?id=${p.id }"> <i
											class="fa fa-edit">编辑</i>
									</a> <a class="btn btn-info btn-xs"
										href="/Shop/product/infoProduct.do?id=${p.id }"> <i
											class="fa fa-info-circle">详情</i>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
	<!-- 引入百度Echarts -->

	<script type="text/javascript">
		/* 折线图 */
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('lineChart'));

		// 指定图表的配置项和数据
		option = {
			title : {
				text : ''
			},
			tooltip : {
				trigger : 'axis',
				axisPointer : {
					type : 'cross',
					label : {
						backgroundColor : '#6a7985'
					}
				}
			},
			legend : {
				data : [ '销售量', '访问量' ]
			},
			toolbox : {
				feature : {
					saveAsImage : {}
				}
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			xAxis : [ {
				type : 'category',
				boundaryGap : false,
				data : [ '1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月',
						'10月', '11月', '12月' ]
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [

					{
						name : '销售量',
						type : 'line',
						stack : '总量',
						areaStyle : {
							normal : {}
						},
						data : [ 320, 332, 301, 334, 390, 330, 332, 301, 334,
								390, 330, 332 ]
					},
					{
						name : '访问量',
						type : 'line',
						stack : '总量',
						label : {
							normal : {
								show : true,
								position : 'top'
							}
						},
						areaStyle : {
							normal : {}
						},
						data :
	<%int[] circleCount = {0, 0, 0, 0, 0};
int[] monthVisits = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
List<Object> objects = (List<Object>) request.getAttribute("products");
for (Object object : objects) {
	Product product = (Product) object;
	for (int i = 0; i < monthVisits.length; i++) {
		if (product.getAddDate().getMonth() == i) {
			monthVisits[i] += product.getVisitCount();
		}
	}
	long visitCount = product.getVisitCount();
	if (visitCount < 1000) {
		circleCount[0] += 1;
	} else if (visitCount >= 1000 && visitCount < 2000) {
		circleCount[1] += 1;
	} else if (visitCount >= 2000 && visitCount < 3000) {
		circleCount[2] += 1;
	} else {
		circleCount[3] += 1;
	}
}
request.getSession().removeAttribute("circleCount");
request.getSession().setAttribute("circleCount", circleCount);
out.print(Arrays.toString(monthVisits));%>
		} ]
		};

		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	</script>
	<script type="text/javascript">
		function check() {
			var isTrue = false;
			var ids = document.getElementsByName("ids");
			ids.forEach(function(item) {
				if (item.checked) {
					isTrue = true;
				}
			});
			if(!isTrue){
				alert("请至少选择一项数据！");
			}
			return isTrue;
		}
	</script>
</body>
</html>
