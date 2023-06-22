<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>店舗詳細</title>
		<link rel="icon" href="img/favicon.ico">
<link rel="stylesheet" href="/buster_moon/css/restaurant.css">
</head>
<body>
<div class="wrapper">
	<nav class="nav">
	<ul>
  		<li><a href="/buster_moon/Time_lineServlet">タイムライン</a></li>
 		<li><a href="/buster_moon/PostServlet">投稿</a></li>
 		<li><a href="/buster_moon/SerchServlet">検索</a></li>
  		<li><a href="/buster_moon/GatherServlet">一緒にどう？</a></li>
		<li><a href="/buster_moon/ProfileServlet">プロフィール></a></li>
  	</ul>
  	</nav>



	<form method="POST" action="/buster_moon/RestaurantServlet">
		<c:forEach var="r" items="${restaurantList}" >
				<h1>${r.restaurant}</h1>
			<c:forEach var="s" items="${shousaiList}">
				<p class="photo">${s.photo}</p>
			</c:forEach>


				<table>
					<tr>
						<th>ジャンル</th>
						<td>${r.genre}</td>

					</tr>
					<tr>
						<th>徒歩時間</th>
						<td>約${r.walk}分</td>
					</tr>
					<tr>
						<th>提供時間</th>
						<td>約${r.serve}分</td>
					</tr>
					<tr>
						<th>価格</th>
						<td>約${r.price}円</td>
					</tr>

				</table>
				<c:forEach var="s" items="${shousaiList}">
					<p class="text">${s.text}</p>
				</c:forEach>

		</c:forEach>
	</form>
</div>
</body>
</html>