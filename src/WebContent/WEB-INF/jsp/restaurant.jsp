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
<%-- <table class="restaurantTable">
	<c:forEach var="e" items="${shousaiList}","${restaurantList}" >
		<tr>
		<th>店名</th><td>${e.restaurant}</td>
		</tr>
		<tr>
		<th>写真</th><td>${e.photo}</td>
		画像を横並びにするためには、CSSプロパティの「display: flex;」を使用する
		</tr>
		<th>ジャンル</th><td>${e.genre}</td>
		<th>価格</th><td>${e.price}</td>

		</tr>
		<tr>
		<th>提供時間</th><td>${e.serve}</td>
		<th>徒歩時間</th><td>${e.walk}</td>
		</tr>
		<tr>
		<th>レビュー</th><td>${e.text}</td>
		</tr>
	</c:forEach>
	</table> --%>
<style>

.ex1 {
width: 200px;
height: 160px;
}
.ex1 {
display: flex;
padding-right: 5px;
}


</style>


<h1>${e.restaurant}</h1>

<div class="ex1">
	${e.photo}
</div><br>

		<%--画像を横並びにするためには、CSSプロパティの「display: flex;」を使用する --%>


	<table class="restaurantTable">
		<tr>
		<th>ジャンル</th><td>${e.genre}</td>

		</tr>
		<tr>
		<th>徒歩時間</th><td>約${e.serve}分</td>
		</tr>
		<tr>
		<th>提供時間</th><td>約${e.walk}分</td>
		</tr>
		<tr>
		<th>価格</th><td>約${e.price}円</td>
		</tr>
	</table>

<h2>レビュー</h2>
<p>・${e.text}</p>


</body>
</html>