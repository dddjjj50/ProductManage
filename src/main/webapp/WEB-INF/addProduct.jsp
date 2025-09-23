<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録</title>
</head>
<body>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/header.jsp" />

<h3>商品登録</h3>

<!-- メッセージ表示 -->
<c:if test="${not empty message}">
	<p style="color: blue">${message}</p>
</c:if>

<c:if test="${not empty error}">
	<p style="color: red">${error}</p>
</c:if>

<form action="AddProductservlet" method=post accept-charset="UTF-8">
<table border="1">
	
	<tr>
		<th>商品名</th>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<th>価格</th>
		<td><input type="number" name="price" min="0" step="1">
			<br/>半角数字で入力</td>
	</tr>
	<tr>
		<th>在庫数</th>
		<td><input type="number" name="stock" min="0" step="1">
			<br/>半角数字で入力</td>
	</tr>
	<tr>
		<th>カテゴリ</th>
		<td><select name="categoryId">
			<option value="" disabled selected>---選択してください---</option>
			<c:forEach var="choiceCategory" items="${categoryList}">
				<option value="${choiceCategory.id}">${choiceCategory.categoryName}</option>
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<th>取引会社</th>
		<td><select name="supplierId">
			<option value="" disabled selected>---選択してください---</option>
			<c:forEach var="supplier" items="${supplierList}">
				<option value="${supplier.id}">${supplier.supplierName}</option>
			</c:forEach>
		</select></td>
	</tr>
	
</table>

<br/>

<input type="submit" value="登録！">
<input type="reset" value="リセット">

</form>

<br><br>
<!-- ※商品登録ページのリンク。2にも同じの貼る -->
<a href="">商品登録</a>
<br><br><br>
<!-- フッター -->
<jsp:include page="/WEB-INF/footer.jsp" />


</body>
</html>