<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.CategoryBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カテゴリリスト</title>
</head>
<body>

	<h1>カテゴリリスト</h1>
	<br>

	<table border="1">
		<tr>
			<th>カテゴリID</th>
			<th>カテゴリ名</th>
		</tr>

		<%
		List<CategoryBean> categoriesList = (List<CategoryBean>) request.getAttribute("categoriesList");
		if (categoriesList != null) {
			for (CategoryBean category : categoriesList) {
		%>
		<tr>
			<td><%=category.getId()%></td>
			<td><%=category.getCategoryName()%></td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="2">カテゴリ情報が取得できませんでした。</td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>