<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>

<jsp:include page="/WEB-INF/header.jsp" />

<h3>ホーム</h3>

<a href="${pageContext.request.contextPath}/ProductsList1Servlet">商品一覧表示</a>
<br/>
<a href="${pageContext.request.contextPath}/AddProductservlet">商品登録</a><br/>

<br/>

<!-- ログアウトボタン -->
<form action="LogOutServlet" method="post">
	<p>
		<input type="submit" value="ログアウト☆彡">
	</p>
</form>

</body>
</html>