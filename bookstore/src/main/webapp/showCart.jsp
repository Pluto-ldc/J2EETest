<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<script type="text/javascript" src="https://file.plutoldc.xyz/jquery-3.5.1/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="https://file.plutoldc.xyz/bootstrap-4.5.0/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="https://file.plutoldc.xyz/bootstrap-4.5.0/css/bootstrap.min.css" />
		<!--设置页面的宽度随着使用者的设备变化二变化 -->
		<meta name="viewport" content="width=device-width,initial-scal=1">
		<title>网上书店</title>
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div class="container text-center align-cartMap-center" style="height: 575px;">
			<div class="row justify-content-center">
				<div class="col-3">
					<s:action name="browseCatalog" executeResult="true" />
				</div>
				<div class="col-8">
					<div class="col-12 mt-3">
						<s:set var="cartMap" value="#session.cart.cartMap" />
						<s:if test="#cartMap.size!=0">
							<p class="text-primary">所有符合条件的图书</p>
							<table class="table table-hover table-bordered table-condensed table-striped m-3 col-12">
								<tr>
									<th width="20%">书名</th>
									<th width="20%">定价</th>
									<th width="20%">数量</th>
									<th class="text-success" colspan="2">
										操作
									</th>
								</tr>

								<s:iterator value="#cartMap">
									<tr>
										<td style="vertical-align: middle;">
											<s:property value="value.book.bookName" />
										</td>
										<td style="vertical-align: middle;">
											<s:property value="value.book.price" />
										</td>
										<form action="updateCart" method="post">
											<td>
												<input type="number" class="form-control" value="<s:property value=" value.quantity" />" name="quantity"/>
												<input type="hidden" name="bookId" value="<s:property value=" value.book.bookId" />" />
											</td>
											<td>
												<button class="col-4 btn btn-primary" type="submit">修改</button>&nbsp;&nbsp;&nbsp;&nbsp;
												<a href="${pageContext.request.contextPath}/deleteBook?bookId=<s:property value=" value.book.bookId" />">
													<button class="col-4 btn btn-danger" type="button">删除</button>
												</a>
											</td>
										</form>
									</tr>
								</s:iterator>
								<tr>
									<td colspan="5">
										消费金额：
										<s:property value="#session.cart.totalPrice" />元
									</td>
								</tr>
							</table>
							<a class="col-4 btn btn-xs btn-primary" href="checkout">进入结算中心</a>
						</s:if>
						<s:else>
							<p style="margin-top: 120px;" class="text-danger">对不起！您还没有选购图书！</p>
						</s:else>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="footer.html"></jsp:include>
	</body>
</html>
