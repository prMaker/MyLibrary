<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">图书管理系统</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul id="home" class="nav navbar-nav">
				<li><a href="/homepage">主页</a></li>
				<li><a href="/cardhome">借书卡管理系统</a></li>
				<li><a href="/bookhome">图书管理系统</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">${sessionScope.user} <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">个人资料</a></li>
						<li><a href="#">修改密码</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="/userexit">退出系统</a></li>
					</ul></li>
				<li><a href="#">在线人数：${applicationScope.count}</a></li>
			</ul>
		</div>
	</div>
</nav>