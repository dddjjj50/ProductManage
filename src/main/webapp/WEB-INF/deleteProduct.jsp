<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品削除</title>
</head>
<body>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--ヘッダー --%><jsp:include page="/WEB-INF/header.jsp" />

<h3>商品削除</h3>

<!-- エラーの場合 -->
<c:if test="${product == null}">
	<p style="color:red;">
		<c:out value="${errorMsg}" default="商品情報が取得できませんでした"/>
	</p>
</c:if>

<%--エラーじゃない場合 --%>
<c:if test="${product != null}">
<p style="color:blue;">下記商品を削除します。</p>

<table border="1">
		<tr>
			<th>ID</th>
			<th>商品名</th>
			<th>価格</th>
			<th>在庫数</th>
		</tr>
		<tr> <%--下にJDBCからのデータはめ込む。カテゴリとか取引会社はJOIN使う？ --%>
			<td>${product.id}</td>
			<td>${product.productName}</td>
			<td>${product.price}</td>
			<td>${product.stock}</td>
		</tr>
	</table><br/>

	<%--削除ボタン --%>
	<p>本当に削除してよろしいですか？</p>
	<form action="DeleteProduct2Servlet" method="post">
		<input type="submit" value="はい！">
		<%--隠しフィールドでidを送る --%>
		<input type="hidden" name="id" value="${product.id}">
	</form>
</c:if>

<%--フッター --%><jsp:include page="/WEB-INF/footer.jsp" />

</body>
</html>