<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カテゴリ情報入力フォーム</title>
</head>
<body>
	<h1>カテゴリ情報入力フォーム</h1>
	
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