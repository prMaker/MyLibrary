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
			style="margin: 50px">
			<div style="float: right;">
				<a type="button" class="btn btn-primary" href="/cardadd">新增图书卡</a>
			</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>id</th>
						<th>编号</th>
						<th>姓名</th>
						<th>电话</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${requestScope.list}">
						<tr>
							<th scope="row">${c.id}</th>
							<td>${c.code}</td>
							<td>${c.name}</td>
							<td>${c.tel}</td>
							<td>
								<button data="${c.id}" type="button"
									class="btn btn-danger btn-sm">删除</button>
								<button data="${c.id}" type="button"
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
			$("#home>li:nth-child(2)").addClass("active");
			$(".btn-danger").click(function() {
				if (confirm("确定删除？")) {
					var id = $(this).attr("data");
					location.href = "/carddel?id=" + id;
				}
			});
			$(".btn-success").click(function() {
				var id = $(this).attr("data");
				location.href = "/cardupdate?id=" + id;
			});
		});
	</script>
</body>
</html>
