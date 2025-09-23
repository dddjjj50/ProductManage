<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧②</title>
</head>
<body>

<jsp:include page="/WEB-INF/header.jsp" />

<h3>商品一覧②</h3>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 選択したカテゴリで商品がない場合 -->
<c:if test="${empty productList}">
	<p>選択したカテゴリで商品の登録はありません。</p>
</c:if>

<c:if test="${not empty productList}">
	<table border="1">
		<tr>
			<th>ID</th>
			<th>商品名</th>
			<th>価格</th>
			<th>在庫数</th>
		</tr>
		<c:forEach var="product" items="${productList}">
			<tr>
				<td>${product.id}</td>
				<td>${product.productName}</td>
				<td>${product.price}</td>
				<td>${product.stock}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<br/>

<!-- カテゴリ選択ページに戻る -->
<a href="${pageContext.request.contextPath}/ProductsList1Servlet">カテゴリ選択ページへ戻る</a>

<br><br>

▷<a href="${pageContext.request.contextPath}/AddProductservlet">商品登録の場合はこちら</a>
<br><br><br>
<!-- フッター -->
<jsp:include page="/WEB-INF/footer.jsp" />


</body>
</html>