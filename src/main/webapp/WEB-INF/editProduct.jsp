<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報の編集</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/header.jsp" />
<h3>商品情報の編集</h3>

<p>編集する項目のみ入力してください</p>

<%--エラーメッセージ --%>
<c:if test="${not empty errorMsg}">
	<p style="color: red">${errorMsg}</p>
</c:if>

<br/>

<form action="EditProduct2Servlet" method="post">
	
	<div>
		■商品名<br/>
		<span style="font-size:0.8em; color:gray">現在：${product.productName}</span><br/>
		<input type="text" id="name" name="name" value="">
	</div><br/>
	
	<div>
		■価格<br/>
		<span style="font-size:0.8em; color:gray">現在：${product.price}</span><br/>
		<input type="number" name="price" min="0" step="1" value="">
	</div><br/>
	
	<div>
		■在庫数<br/>
		<span style="font-size:0.8em; color:gray">現在：${product.stock}</span><br/>
		<input type="number" name="stock" min="0" step="1" value="">
	</div><br/>
	
	<div>
		■カテゴリ<br/>
		<span style="font-size:0.8em; color:gray">現在：${product.categoryName}</span><br/>
		<select name="categoryId">
			<option value="" disabled selected>---選択してください---</option>
			<c:forEach var="choiceCategory" items="${categoryList}">
				<option value="${choiceCategory.id}">${choiceCategory.categoryName}</option>
			</c:forEach>
	</select>
	</div><br/>
	
	<input type="hidden" name="id" value="${product.id}">
	
	<input type="submit" value="編集実行☆"> &nbsp;
	<input type="reset" value="リセット">
	
</form>

<%--フッター --%><jsp:include page="/WEB-INF/footer.jsp" />

</body>
</html>