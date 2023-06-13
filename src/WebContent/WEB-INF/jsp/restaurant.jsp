<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <li><a href="/buster_moon/Time_lineServlet"><img src="/buster_moon/img/タイムライン.png" alt=""></a></li>
  <li><a href="/buster_moon/PostServlet"><img src="/buster_moon/img/投稿.png" alt=""></a></li>
  <li><a href="/buster_moon/GatherServlet"><img src="/buster_moon/img/募集.jpeg" alt=""></a></li>
  <li><a href="/buster_moon/SerchServlet"><img src="/buster_moon/img/検索.png" alt=""></a></li>
  <li><a href="/buster_moon/ProfileServlet"><img src="/buster_moon/img/プロフィール.png" alt=""></a></li>
  </ul>
  <hr>


	<%-- 店舗情報を表示するテーブル　
	　　　<c:forEach var="e" items="${}" > --%>

	<table class="restaurantTable">
		<tr>
		<th>店名</th><td>${e.}</td>
		<th>写真</th><td colspan="6">${e.}</td>
		</tr>
		<tr>
		<th>ジャンル</th><td>${e}</td>
		<th>徒歩時間</th><td>${e.}</td>
		</tr>
		<tr>
		<th>提供時間</th><td>${e.}</td>
		<th>価格</th><td>${e.}</td>
		<th>テキスト一覧</th><td>${e.}</td>
		</tr>
	</table>
		<hr>
  </ul>
</body>
</html>