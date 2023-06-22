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
<ul class="nav">
  <li><a href="/buster_moon/Time_lineServlet"><img src="/buster_moon/img/timeLine.ico" alt=""></a></li>
  <li><a href="/buster_moon/PostServlet"><img src="/buster_moon/img/post.ico" alt=""></a></li>
  <li><a href="/buster_moon/GatherServlet"><img src="/buster_moon/img/gather.ico" alt=""></a></li>
  <li><a href="/buster_moon/SerchServlet"><img src="/buster_moon/img/search.ico" alt=""></a></li>
  <li><a href="/buster_moon/ProfileServlet"><img src="/buster_moon/img/profile.ico" alt=""></a></li>
  </ul>
  <hr>



<form method="POST" action="/buster_moon/RestaurantServlet">
<c:forEach var="r" items="${restaurantList}" >
	<h1>${r.RESTAURANT}</h1>
		<img src="${shousaiList.PHOTO}" alt="">


	<table class="restaurantTable">
		<tr>
		<th>ジャンル</th><td>${r.GENRE}</td>

		</tr>
		<tr>
		<th>徒歩時間</th><td>約${r.WALK}分</td>
		</tr>
		<tr>
		<th>提供時間</th><td>約${r.SERVE}分</td>
		</tr>
		<tr>
		<th>価格</th><td>約${r.PRICE}円</td>
		</tr>
	</table>

	<h2>レビュー</h2>
	<p>・${shousaiList.TEXT}</p>
</c:forEach>
</form>
</body>
</html>