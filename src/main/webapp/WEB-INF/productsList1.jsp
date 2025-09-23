<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧①</title>
</head>
<body>

<jsp:include page="/WEB-INF/header.jsp" />

<h3>商品一覧</h3>

<p>表示するカテゴリを選んでください</p>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="ProductsList2Servlet" method="post">
	<select name="choiceCategory">
		<option value="" disabled selected>---選択してください---</option>
		<option value="0">☆全て☆</option>
		<c:forEach var="category" items="${categoryList}">
			<option value="${category.id}">${category.categoryName}</option>
		</c:forEach>
	</select>
	<br/>
	<input type="submit" value="選択したカテゴリの商品一覧を見る">
</form>

<br><br>

▷<a href="${pageContext.request.contextPath}/AddProductservlet">商品登録の場合はこちら</a>
<br><br><br>
<!-- フッター -->
<jsp:include page="/WEB-INF/footer.jsp" />


メモ！あとで消す！ある程度できたらファイルをWEB-INFに移動する
</body>
</html>