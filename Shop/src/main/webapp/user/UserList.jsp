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
						<li><a href="/Shop/product/list.do">商品维护 <span
								class="sr-only">(current)</span></a></li>
						<li><a href="/Shop/product/analysis.do">数据分析</a></li>
						<li class="active"><a href="/Shop/user/list.do">账户维护</a></li>
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
					<c:if test="${empty admin.name }"><font size="4" color="red">请<a href="/Shop/Login.jsp">登录</a></font></c:if>
					<c:if test="${!empty admin.name }">
						欢迎:【${admin.name }】 &nbsp;&nbsp;&nbsp; <img src="../img/girl.jpg" width="50px" class="img-rounded" alt="" />
					</c:if>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="panel panel-info">
					<div class="panel-heading">用户来源分布</div>
					<div class="panel-body">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5>
									<span style="font-size: 16px;" class="label label-success">用户来源分布</span>
								</h5>
							</div>
							<div class="ibox-content">
								<div class="echarts" id="userAddressPie" style="height: 300px;"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-7">
				<div class="panel panel-info">
					<div class="panel-heading">用户访问量趋势</div>
					<div class="panel-body">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5>
									<span style="font-size: 16px;" class="label label-success">用户访问量趋势</span>
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
				<a href="/Shop/user/AddUser.jsp" class="btn btn-info btn-xs"> <i
					class=" fa fa-plus-circle"></i> 添加
				</a> <a href="/Shop/user/export.do" class="btn btn-success btn-xs"><i
					class="fa fa-save">导出</i></a>
			</div>
			<div class="col-md-3"></div>
			<div class="col-md-3"></div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<!-- 表格信息 -->
				<table class="table table-hover table-bordered table-condensed">
					<thead>
						<tr class="bg-primary">
							<th>用户名</th>
							<th>手机号</th>
							<th>年龄</th>
							<th>邮箱</th>
							<th>地址</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${requestScope.users }">
							<tr>
								<td>${user.userName}</td>
								<td>${user.mobile }</td>
								<td>${user.age }</td>
								<td>${user.email }</td>
								<td>${user.address }</td>
								<td><a class="btn btn-danger btn-xs" href="/Shop/user/delete.do?id=${user.id }"> <i
										class="fa fa-trash">删除</i>
								</a> <a class="btn btn-primary btn-xs" href="/Shop/user/editUser.do?id=${user.id }"> <i
										class="fa fa-edit">编辑</i>
								</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- 其他JS文件 -->
	<!-- 全局js -->
	<script src="/Shop/js/jquery.min.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="/Shop/js/plugins/echarts/echarts.min.js"></script>
	<br />

	<script>
		/*支付平台占比饼状图*/
		$(function() {
			var pieChart = echarts.init(document
					.getElementById("userAddressPie"));
			var pieoption = {
				title : {
					text : '',
					x : 'center'
				},
				tooltip : {
					trigger : 'item',
					formatter : "{a} <br/>{b} : {c} ({d}%)"
				},
				legend : {
					orient : 'vertical',
					x : 'left',
					data : [ '游戏平台', '视频娱乐', '门户媒体', '电商平台' ]
				},
				calculable : true,
				series : [ {
					name : '支付平台',
					type : 'pie',
					radius : '55%',
					center : [ '50%', '60%' ],
					data : [ {
						value : 335,
						name : '游戏平台'
					}, {
						value : 310,
						name : '视频娱乐'
					}, {
						value : 234,
						name : '门户媒体'
					}, {
						value : 135,
						name : '电商平台'
					} ]
				} ]
			};
			pieChart.setOption(pieoption);
		})

		/* 折线图 */
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('lineChart'));

		// 指定图表的配置项和数据
		option = {
			title : {
				text : '',
			},
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [ '用户访问趋势' ]
			},
			toolbox : {
				show : true,
				feature : {
					magicType : {
						type : [ 'line', 'bar' ]
					},
					saveAsImage : {}
				}
			},
			xAxis : {
				type : 'category',
				boundaryGap : false,
				data : [ '周一', '周二', '周三', '周四', '周五', '周六', '周日' ]
			},
			yAxis : {
				type : 'value',
				axisLabel : {
					formatter : '{value} 次'
				}
			},
			series : [

			{
				name : '用户访问趋势',
				type : 'line',
				data : [ 100, 200, 250, 255, 300, 200, 260 ],
				markPoint : {
					data : [ {
						name : '周最低',
						value : -2,
						xAxis : 1,
						yAxis : -1.5
					} ]
				},
				markLine : {
					data : [ {
						type : 'average',
						name : '平均值'
					}, [ {
						symbol : 'none',
						x : '90%',
						yAxis : 'max'
					}, {
						symbol : 'circle',
						label : {
							normal : {
								position : 'start',
								formatter : '最大值'
							}
						},
						type : 'max',
						name : '最高点'
					} ] ]
				}
			} ]
		};

		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	</script>
</body>
</html>
