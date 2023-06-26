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
	<nav>
			<ul>
  				<li class="menu1"><a href="/buster_moon/Time_lineServlet"></a></li>
 				<li class="menu2"><a href="/buster_moon/PostServlet"></a></li>
 				<li class="menu3"><a href="/buster_moon/SearchServlet"></a></li>
  				<li class="menu4"><a href="/buster_moon/GatherServlet"></a></li>
				<li class="menu5"><a href="/buster_moon/My_profileServlet"></a></li>
  			</ul>
  	</nav>


		<form method="POST" action="/buster_moon/RestaurantServlet">
			<c:forEach var="r" items="${restaurantList}" >
					<h1>${r.restaurant}</h1>
				<c:forEach var="s" items="${shousaiList}">
					<div class="photo"><img src="${'/buster_moon/img/'+=s.photo}"></div>
				</c:forEach>
				<div class="container">
					<main>
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
					</main>
			</c:forEach>
		</form>
					<aside>
						<p class="review">レビュー</p>
						<c:forEach var="s" items="${shousaiList}">
							<p class="text">${s.text}</p>
						</c:forEach>
					</aside>
				</div>
</div>
</body>
</html>