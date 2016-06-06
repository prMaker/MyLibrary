<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



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
						<h3 class="panel-title">新增图书</h3>
					</div>
					<div class="panel-body">
						<form id="signupForm" method="post" class="form-horizontal" action="/bookadd" novalidate="novalidate">
							<div class="form-group">
								<label class="col-sm-4 control-label" for="code">编号</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="code" name="code" placeholder="请输入编号：">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-4 control-label" for="title">书名</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="title" name="title" placeholder="请输入书名：">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-4 control-label" for="author">作者</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="author" name="author" placeholder="请输入作者：">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-4 control-label" for="publishing">出版社</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="publishing" name="publishing" placeholder="请输入出版社：">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-4 control-label" for="total">总数量</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="total" name="total" placeholder="请输入总数量：">
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-9 col-sm-offset-4">
									<button type="submit" class="btn btn-primary" name="signup" value="新增">新增</button>
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
	 $(function(){
		 $("#home>li:nth-child(3)").addClass("active");
		 $("#signupForm").validate({
			 rules:{
				 code:"required",
				 title:"required",
				 author:"required",
				 publishing:"required",
				 total:{
					 required:true,
					 digits:true,
				 }
			 },
			 messages:{
				 code:"请输入编号：",
				 title:"请输入书名：",
				 author:"请输入作者：",
				 publishing:"请输入出版社：",
				 total:"请输入总数量："
			 },
			 errorElements:"span"
		 });
	 });
	</script>
</body>
</html>
