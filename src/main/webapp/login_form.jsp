<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインフォーム</title>

<!-- 
	セッションが生きていれば、
	IDとパスの入力を省略してwelcom.jspに飛ぶ
 -->
<%
String user = (String) session.getAttribute("user");
if (user != null) {
    response.sendRedirect("HomeServlet");
    return;
}
%>
</head>
<body>

<h1>ログインフォーム</h1>

<br/>

<!-- ログイン失敗時やセッション切れのときにメッセージを表示 -->
<%
String alert = (String) request.getAttribute("alert");
if(alert != null){
%>
	<p style="color:red"><%= alert %></p>
<%
}
%>

<form action="LoginFormServlet" method="post">
	<p>
		ID:
		<input type="text" name="id">
	</p>
	<p>
		PASSWORD:
		<input type="password" name="pass">
	</p>
	
	<br/>
	
	<p>
		<input type="submit" value="ログイン！★">
		<input type="reset" value="リセット">
	</p>
</form>

</body>
</html>