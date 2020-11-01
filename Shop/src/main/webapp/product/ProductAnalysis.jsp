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
						<li class="active"><a href="/Shop/product/analysis.do">数据分析</a></li>
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
					<c:if test="${empty admin.name }"><font size="4" color="red">请<a href="/Shop/Login.jsp">登录</a></font></c:if>
					<c:if test="${!empty admin.name }">
						欢迎:【${admin.name }】 &nbsp;&nbsp;&nbsp; <img src="../img/girl.jpg" width="50px" class="img-rounded" alt="" />
					</c:if>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-info">
					<div class="panel-heading">商品访问量分布图</div>
					<div class="panel-body">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5>
									<span style="font-size: 16px;" class="label label-success">商品访问量占比</span>
								</h5>
							</div>
							<div class="ibox-content">
								<div class="echarts" id="userPie" style="height: 300px;"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="panel panel-info">
					<!-- 					  <div class="panel-heading">商品销售量分布图</div>
			 -->
					<div class="panel-heading">热点商品Top5</div>
					<div class="panel-body">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5>
									<span style="font-size: 16px;" class="label label-success">热点商品Top5</span>
								</h5>
							</div>
							<div class="ibox-content">
								<div class="echarts" id="coursesBar" style="height: 300px;"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- <div class="col-md-4">
								<div class="panel panel-info">
								  <div class="panel-heading">商品数量趋势</div>
								  <div class="panel-body">
									Panel content
								  </div>
								</div>
							</div> -->

		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-success">
					<div class="panel-heading">最受欢迎商品Top5</div>
					<div class="panel-body">
						<table class="table table-hover table-condensed">
							<thead>
								<tr>
									<th>排名</th>
									<th></th>
									<th>名称</th>
									<th>访问量</th>
									<th>价格</th>
									<th>信息</th>
								</tr>
							</thead>

							<tbody>
								<c:set var="id" value="1"></c:set>
								<c:forEach var="product" items="${requestScope.topProducts }">
									<tr>
										<td>${id }</td>
										<c:set var="id" value="${id+1 }"></c:set>
										<td><img src="/Shop/${product.pic_url }" class="img-thumbnail"
											as width="30px" alt=""></td>
										<td>${product.name }</td>
										<td>${product.visitCount }</td>
										<td>￥${product.price }</td>
										<td><a href="/Shop/product/infoProduct.do?id=${product.id }"
											class="btn btn-default btn-xs"><i
												class="fa fa-info-circle"></i> 详情</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

			</div>

			<div class="col-md-6">
				<div class="panel panel-warning">
					<div class="panel-heading">急需补货商品</div>
					<div class="panel-body">
						<table class="table table-hover table-condensed">
							<thead>
								<tr>
									<th>排名</th>
									<th></th>
									<th>名称</th>
									<th>库存</th>
									<th>价格</th>
								</tr>
							</thead>

							<tbody>
								<tr>
									
								</tr>
								<c:set var="id" value="1"></c:set>
								<c:forEach var="needProduct" items="${requestScope.needProducts }">
									<tr>
										<td>${id }</td>
										<c:set var="id" value="${id+1 }"></c:set>
									<td><img src="/Shop/${needProduct.pic_url }" class="img-thumbnail" as
										width="30px" alt=""></td>
									<td>${needProduct.name }</td>
									<td>${needProduct.sum }</td>
									<td>￥${needProduct.price }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>

	<!-- 其他JS文件 -->
	<!-- 全局js -->
	<script src="/Shop/js/jquery.min.js?v=2.1.4"></script>

	<script src="/Shop/js/plugins/echarts/echarts.min.js"></script>
	<br />
	<c:forEach var="product" items="${topProducts }">
		'${product.name}',
	</c:forEach>
	<script>
		/*支付平台占比饼状图*/
		$(function() {
			var pieChart = echarts.init(document.getElementById("userPie"));
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
					data : [ '1000以下', '1000~2000', '2000~3000', '3000以上' ]
				},
				calculable : true,
				series : [ {
					name : '支付平台',
					type : 'pie',
					radius : '55%',
					center : [ '50%', '60%' ],
					data : [ {
						value : ${circleCount[0]},
						name : '1000以下'
					}, {
						value : ${circleCount[1]},
						name : '1000~2000'
					}, {
						value : ${circleCount[2]},
						name : '2000~3000'
					}, {
						value : ${circleCount[3]},
						name : '3000以上'
					} ]
				} ]
			};
			pieChart.setOption(pieoption);

			/*初始化热销课程排行榜*/
			var barChart = echarts.init(document.getElementById("coursesBar"));
			var baroption = {
				title : {
					text : ''
				},
				tooltip : {
					trigger : 'axis'
				},
				legend : {
					data : [ '访问量', '库存' ]
				},
				grid : {
					left : 50,
					x : 30,
					x2 : 40,
					y2 : 24
				},
				calculable : true,
				xAxis : [ {
					axisLabel : {
						interval : 0,
						rotate : 0
					},
					data : [ 
						<c:forEach var="product" items="${topProducts }">
							'${product.name}',
						</c:forEach> 
					]
				} ],

				yAxis : [ {
					type : 'value'
				} ],
				series : [ {
					name : '访问量',
					type : 'bar',
					data : [ <c:forEach var="product" items="${topProducts }">
					'${product.visitCount}',
					</c:forEach> ],
					markPoint : {
						data : [ {
							type : 'max',
							name : '最大值'
						}, {
							type : 'min',
							name : '最小值'
						} ]
					}
				}, {
					name : '库存',
					type : 'bar',
					data : [ <c:forEach var="product" items="${topProducts }">
					'${product.sum}',
					</c:forEach> ],
					markPoint : {
						data : [ {
							type : 'max',
							name : '最大值'
						}, {
							type : 'min',
							name : '最小值'
						} ]
					}
				} ]
			};
			barChart.setOption(baroption);

			//初始化折线图
			initWeekLine(3);
		})
		/*
		线上课程营收曲线
		 * */
		function initWeekLine(swt) {
			switch (swt) {
			//月度
			case 1:
				var lineChart1 = echarts.init(document
						.getElementById("echarts-line-chart"));
				var lineoption1 = {
					title : {
						x : 'center',
						text : '平台月度营收'
					},
					tooltip : {
						trigger : 'axis'
					},
					grid : {
						left : 100
					},
					calculable : true,
					xAxis : [ {
						type : 'category',
						boundaryGap : false,
						data : [ '周一', '周二', '周三', '周四', '周五', '周六', '周日' ]
					} ],
					yAxis : [ {
						type : 'value',
						axisLabel : {
							formatter : '{value} 人民币'
						}
					} ],
					series : [ {
						name : '最高气温',
						type : 'line',
						data : [ 11, 11, 15, 13, 12, 13, 10 ],
						markPoint : {
							data : [ {
								type : 'max',
								name : '最大值'
							}, {
								type : 'min',
								name : '最小值'
							} ]
						},
						markLine : {
							data : [ {
								type : 'average',
								name : '平均值'
							} ]
						}
					} ]
				};
				lineChart1.setOption(lineoption1);
				break;
			//年度
			case 2:
				var lineChart2 = echarts.init(document
						.getElementById("echarts-line-chart"));
				var lineoption2 = {
					title : {
						text : '平台年度营收',
						x : 'center'
					},
					tooltip : {
						trigger : 'axis'
					},
					grid : {
						left : 100
					},
					calculable : true,
					xAxis : [ {
						type : 'category',
						boundaryGap : false,
						data : [ '周一', '周二', '周三', '周四', '周五', '周六', '周日' ]
					} ],
					yAxis : [ {
						type : 'value',
						axisLabel : {
							formatter : '{value} °C'
						}
					} ],
					series : [ {
						name : '最高气温',
						type : 'line',
						data : [ 11, 11, 15, 13, 12, 13, 10 ],
						markPoint : {
							data : [ {
								type : 'max',
								name : '最大值'
							}, {
								type : 'min',
								name : '最小值'
							} ]
						},
						markLine : {
							data : [ {
								type : 'average',
								name : '平均值'
							} ]
						}
					} ]
				};
				lineChart2.setOption(lineoption2);
				break;
			case 3:
				var lineChart3 = echarts.init(document
						.getElementById("echarts-line-chart"));
				var lineoption3 = {
					title : {
						text : '平台周度营收',
						x : 'center'
					},
					tooltip : {
						trigger : 'axis'
					},
					grid : {
						left : 100
					},
					calculable : true,
					xAxis : [ {
						type : 'category',
						boundaryGap : false,
						data : [ '周一', '周二', '周三', '周四', '周五', '周六', '周日' ]
					} ],
					yAxis : [ {
						type : 'value',
						axisLabel : {
							formatter : '{value} ￥'
						}
					} ],
					series : [ {
						name : '最高气温',
						type : 'line',
						data : [ 11000, 22200, 8000, 30000, 15000, 10000, 40000 ],
						markPoint : {
							data : [ {
								type : 'max',
								name : '最大值'
							}, {
								type : 'min',
								name : '最小值'
							} ]
						},
						markLine : {
							data : [ {
								type : 'average',
								name : '平均值'
							} ]
						}
					} ]
				};
				lineChart3.setOption(lineoption3);
			}
		}
	</script>
</body>
</html>
