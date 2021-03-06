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
						<s:iterator value="#request['books']" var="book">
							<div class="row">
								<table class="table table-striped m-1">
									<tr>
										<td width="30%" rowspan="4">
											<img class="img-fluid" src="<s:property value=" #book.picture" />">
										</td>
										<td align="right" colspan="2">书名:</td>
										<td align="left" colspan="2">
											<s:property value=" #book.bookName" />
										</td>
									</tr>
									<tr>
										<td align="right" colspan="2" width="35%">价格:</td>
										<td align="left" colspan="2">¥
											<s:property value=" #book.price" />
										</td>
									</tr>
									<tr>
										<form action="addToCart" method="post">
											<td style="vertical-align: middle;" width="14%">数量:</td>
											<td><input type="number" class="form-control" name="quantity" value="1" /></td>
											<td colspan="2">
												<input type="hidden" name="bookId" value="<s:property value=" #book.bookId" />"> <input class="btn btn-primary"
												 type="submit" value="购买" />
											</td>
										</form>
									</tr>
								</table>
							</div>
						</s:iterator>
						<s:set value="#request.pager" var="pager" />
						<div class="row m-1">
							<div class="col-3">
								<s:if test="#pager.hasFirst">
									<a href="browseBookPaging?currentPage=1">首页</a>
								</s:if>
							</div>
							<div class="col-3">
								<s:if test="#pager.hasPrevious">
									<a href="browseBookPaging?currentPage=<s:property value=" #pager.currentPage-1" />">上一页</a>
								</s:if>
							</div>
							<div class="col-3">
								<s:if test="#pager.hasNext">
									<a href="browseBookPaging?currentPage=<s:property value=" #pager.currentPage+1" />">下一页</a>
								</s:if>
							</div>
							<div class="col-3">
								<s:if test="#pager.hasLast">
									<a href="browseBookPaging?currentPage=<s:property value=" #pager.totalPage" />">尾页</a>
								</s:if>
							</div>
						</div>
						<s:if test="#pager.totalPage != 0">
							<p class="m-1">当 前 第
								<s:property value="#pager.currentPage" /> 页 ， 共
								<s:property value="#pager.totalPage" /> 页.</p>
						</s:if>
						<s:else>
							<p style="margin-top: 120px;" class="text-danger">此图分类下暂无图书！</p>
						</s:else>
					</div>
				</div>
				<div class="col-3"></div>
			</div>
		</div>
		<jsp:include page="footer.html"></jsp:include>
	</body>
</html>
