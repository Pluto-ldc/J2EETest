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
		<div class="container text-center align-items-center" style="height: 575px;">
			<div class="row justify-content-center">
				<div class="col-3">
					<s:action name="browseCatalog" executeResult="true" />
				</div>
				<div class="col-5">
					<div class="col-12 mt-3">
						<div style="margin-top: 75px;">
							<h3 class="text-primary">图书已成功加入购物车！</h3>
							<form action="browseBookPaging" method="post" class="m-5">
								<input type="hidden" name="catalogId" value="<s:property value=" #session['catalogId']" />">
								<div class="row">
									<button type="submit" class="btn btn-success col-4">继续购物</button>
									<div class="col-2"></div>
									<a class="col-6" href="checkout">
										<button type="button" class="btn btn-primary">进入结算中心</button>
									</a>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="col-3"></div>
			</div>
		</div>
		<jsp:include page="footer.html"></jsp:include>
	</body>
</html>
