<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カテゴリ追加入力フォーム</title>
</head>
<body>
	<h1>カテゴリ追加入力フォーム</h1>
	
	
	<!-- アラート -->
	<c:if test="${not empty alert}">
		<ul style="color : red; list-style-type: none;">
			<c:forEach var="msg" items="${alert}">
				<li>${msg}</li>
			</c:forEach>
		</ul>
	</c:if>
	
	
	
	<br>
	
	<form action="CategoryRegisterServlet" method="post">
	<table border="1">
		<tr>
			<td><b>id</b></td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td><b>カテゴリ名</b></td>
			<td><input type="text" name="categoryName"></td>
		</tr>
	</table>
	<button type="submit">追加！</button>
	</form>
	

</body>
</html>