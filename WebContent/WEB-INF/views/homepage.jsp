<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title>Starter Template for Bootstrap</title>
<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	padding-top: 50px;
}

.starter-template {
	padding: 40px 15px;
	text-align: center;
}
</style>
</head>

<body>

	<c:choose>
		<c:when test="${'100' == param.msg}">
			<div class="alert alert-danger" role="alert">
				<strong>借书成功</strong>
			</div>
		</c:when>

		<c:when test="${'101' == param.msg}">
			<div class="alert alert-danger" role="alert">
				<strong>借书失败</strong>
			</div>
		</c:when>

		<c:when test="${'201' == param.msg}">
			<div class="alert alert-danger" role="alert">
				<strong>还书失败</strong>
			</div>
		</c:when>

		<c:when test="${'200' == param.msg}">
			<div class="alert alert-danger" role="alert">
				<strong>还书成功</strong>
			</div>
		</c:when>
	</c:choose>
	<c:if test="${'10001' eq param.error}">
	</c:if>


	<%@ include file="body.jsp"%>
	<div class="container">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">借书</h3>
			</div>
			<div class="panel-body">
				<form id="borrowBook" method="post" class="form-horizontal"
					action="/borrowbook" novalidate="novalidate">
					<div class="form-group">
						<label class="col-sm-4 control-label" for="cardCode">图书证编号</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="cardCode"
								name="cardCode" placeholder="请输入图书证编号：">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label" for="bookCode">图书编号</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="bookCode"
								name="bookCode" placeholder="请输入图书编号：">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-9 col-sm-offset-4">
							<button type="submit" class="btn btn-primary" name="signup"
								value="提交">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>


		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">还书</h3>
			</div>
			<div class="panel-body">
				<form id="reBook" method="post" class="form-horizontal"
					action="/rebook" novalidate="novalidate">
					<div class="form-group">
						<label class="col-sm-4 control-label" for="cardCode">图书证编号</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="cardCode"
								name="cardCode" placeholder="请输入图书证编号：">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label" for="bookCode">图书编号</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="bookCode"
								name="bookCode" placeholder="请输入图书编号：">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-9 col-sm-offset-4">
							<button type="submit" class="btn btn-primary" name="signup"
								value="提交">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>


	</div>



	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="/js/jquery.validate.min.js"></script>
	<script>
		$(function() {
			$("#home>li:nth-child(1)").addClass("active");
			$("#borrowBook").validate({
				rules : {
					cardCode : "required",
					bookCode : "required"
				},
				messages : {
					cardCode : "请输入图书证号",
					bookCode : "请输入图书编号"
				},
				errorElement : "em"
			});

			$("#reBook").validate({
				rules : {
					cardCode : "required",
					bookCode : "required"
				},
				messages : {
					cardCode : "请输入图书证号",
					bookCode : "请输入图书编号"
				},
				errorElement : "em"
			});
		});
	</script>
</body>
</html>
