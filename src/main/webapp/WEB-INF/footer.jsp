/*
フッター
home.jspへのリンク、ログアウトボタンを表示する
jspファイルでの呼び出しは
<!-- %@ include file="WEB-INF/login_input.jsp" % -->
*/


<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- welcome.jspへのリンク -->

<div>
	<a href="HomeServlet">ホームへ移動</a> 
</div>

<br/>

<form action="LogOutServlet" method="post">
	<p>
		<input type="submit" value="ログアウト">
	</p>
</form>

