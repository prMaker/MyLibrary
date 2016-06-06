<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.entity.Card" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
			Card card = new Card();
			card.setCode("code");
			card.setName("name");
			card.setTel("5456");
			pageContext.setAttribute("card", card);
			System.out.println(card);
		%>
	<h1>
		${pageScope.card.name}<br />
		${pageScope.card.code}<br/>
		${pageScope.card.tel}<br/>
		
	</h1>
</body>
</html>