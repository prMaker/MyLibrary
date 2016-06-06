<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		<div class="bs-example" data-example-id="bordered-table"
			style="margin: 30px">
			<div style="float: right;">
				<a type="button" class="btn btn-primary" href="/bookadd">新增图书</a>
			</div>

			<div style="float: left;">
				<form class="navbar-form navbar-left" role="search"
					action="/bookhome" method="get">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="编号，书名，作者，出版社"
							name="wd">
					</div>
					<button type="submit" style="float: right" class="btn btn-default">搜索</button>
				</form>
			</div>


			<table class="table table-bordered">
				<thead>
					<tr>
						<th>id</th>
						<th>编号</th>
						<th>书名</th>
						<th>作者</th>
						<th>出版社</th>
						<th>总数量</th>
						<th>剩余数量</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${requestScope.list}">

						<tr>
							<th scope="row">${b.id}</th>
							<td>${b.code}</td>
							<td>${b.title}</td>
							<td>${b.author}</td>
							<td>${b.publishing}</td>
							<td>${b.total}</td>
							<td>${b.count}</td>
							<td>
								<button data="${b.id}" type="button"
									class="btn btn-danger btn-sm">删除</button>
								<button data="${b.id}" type="button"
									class="btn btn-success btn-sm">修改</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			$("#home>li:nth-child(3)").addClass("active");
			$(".btn-danger").click(function() {
				if (confirm("确定删除？")) {
					var id = $(this).attr("data");
					location.href = "/bookdel?id=" + id;
				}
			});
			$(".btn-success").click(function() {
				var id = $(this).attr("data");
				location.href = "/bookupdate?id=" + id;
			});
		});
	</script>
</body>
</html>
