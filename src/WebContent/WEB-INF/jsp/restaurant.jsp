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
			<h1>${r.restaurant}</h1>



		<c:forEach var="s" items="${shousaiList}">
			<table class="restaurantTable">
				<tr>
					<td>${s.photo}</td>
		</c:forEach>
				</tr>
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
				<c:forEach var="s" items="${shousaiList}">
				<tr>
					<th>レビュー</th>
					<td>${s.text}</td>
				</tr>
				</c:forEach>
			</table>


</c:forEach>
</form>
</body>
</html>