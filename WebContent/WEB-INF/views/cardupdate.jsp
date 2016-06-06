<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.entity.Card" %>

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
	<%@ include file="body.jsp"%>
	<div class="container">

		<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">新增图书卡</h3>
					</div>
					<div class="panel-body">
						<form id="signupForm" method="post" class="form-horizontal" action="/cardupdate" novalidate="novalidate">
							<input value="${requestScope.card.id}" name="id" type="hidden"/>
							<div class="form-group">
								<label class="col-sm-4 control-label" for="code">编号</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="code" name="code" placeholder="请输入编号：" value = "${requestScope.card.code}">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-4 control-label" for="name">姓名</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名：" value ="${requestScope.card.name}">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-4 control-label" for="tel">电话</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="tel" name="tel" placeholder="请输入电话：" value ="${requestScope.card.tel}">
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-9 col-sm-offset-4">
									<button type="submit" class="btn btn-primary" name="signup" value="新增">修改</button>
								</div>
							</div>
						</form>
					</div>
				</div>
		
	</div>
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script>
	 $(function(){
		 $("#home>li:nth-child(2)").addClass("active");
		 $("#signupForm").validate({
			 rules:{
				 code:"required",
				 name:"required",
				 tel:"required"
			 },
			 messages:{
				 code:"请输入编号：",
				 name:"请输入姓名：",
				 tel:"请输入电话："
			 },
			 errorElements:"span"
		 });
	 });
	</script>
</body>
</html>
