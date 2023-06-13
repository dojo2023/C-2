<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ランキング</h1>

<c:forEach var="e" items="リスト名">
<div class="post">
	<div><img>(投稿者アイコン)</div>
	<div>店名：（投稿表から取り出して表示のみ）</div>
		<div id="post_inf">
		<table>
			<tr><td>ジャンル:</td><td value="${e.genre}">（投稿表から取り出して表示のみ）</td></tr>
			<tr><td>徒歩時間:</td><td value="${e.walk}">（投稿表から取り出して表示のみ）</td></tr>
			<tr><td>提供時間:</td><td value="${e.serve}">（投稿表から取り出して表示のみ）</td></tr>
			<tr><td>価格:</td><td value="${e.price}">（投稿表から取り出して表示のみ）</td></tr>
		</table>
		<div>（投稿表から取り出したテキスト表示）</div>
		<div><img>（投稿表から取り出した写真表示）</div>
	</div>
</div>
</c:forEach>
</body>
</html>