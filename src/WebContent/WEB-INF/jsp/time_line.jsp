<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>ランキング</h1>
<c:forEach var="p" items="${profilesList}">
<div class="ranks">
		<table>
			<tr>
			    <td>${p.name}</td>
				<td>${p.icon}</td>
				<td>${p.t_point+p.g_point+p.c_point}</td>
			</tr>
		</table>
</div>
</c:forEach>
<c:forEach var="e" items="${postsList}">
<hr>
<div class="posts">
	<div><img>(投稿者アイコン)${e.icon}</div>
	<div><img>(投稿者名)${e.name}</div>
	<div>店名：${e.restaurant}</div>
		<div id="post_inf">
		<table>
			<tr><td>ジャンル:</td><td>${e.genre}</td></tr>
			<tr><td>徒歩時間:</td><td>${e.walk}</td></tr>
			<tr><td>提供時間:</td><td>${e.serve}</td></tr>
			<tr><td>価格:</td><td>${e.price}</td></tr>
		</table>
		<div>${e.text}</div>
		<div><img >${e.photo}</div>
	</div>
	<form method="POST" action="/buster_moon/Time_lineServlet">
	<input type="text" name="ID" value="${e.id}">
	<input type="submit" name="SUBMIT" value="コメント表示" >
	</form>
</div>
<hr>
</c:forEach >

<h2>コメント返信表示欄</h2>
<c:forEach var="c" items="${commentsList}">
	<p>アイコン:${c.icon}</p>
	<p>名前:${c.name}</p>
	<p>テキスト:${c.text}</p>
	<p>日付:${c.date}</p>
</c:forEach>
<h2>コメント入力欄</h2>
<form method="POST" action="/buster_moon/Time_lineServlet">
	<input type="text" name="TEXT" value="コメント入力">
	<input type="submit" name="SUBMIT" value="送信" >
</form>

</body>
</html>