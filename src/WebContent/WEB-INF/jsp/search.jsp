<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>物知りプラス</title>
<link rel="icon" href="img/favicon.ico">
<link rel="stylesheet" href="/buster_moon/css/search.css">
</head>
<body>
<div class="wrapper">
	<h1>検索</h1>
	<!-- メニューバーの表示 -->

		<nav>
			<ul>
  				<li class="menu1"><a href="/buster_moon/Time_lineServlet"></a></li>
 				<li class="menu2"><a href="/buster_moon/PostServlet"></a></li>
 				<li class="menu3"><a href="/buster_moon/SearchServlet"></a></li>
  				<li class="menu4"><a href="/buster_moon/GatherServlet"></a></li>
				<li class="menu5"><a href="/buster_moon/My_profileServlet"></a></li>
  			</ul>
  		</nav>


 	<!-- 検索の絞り込みの表示 -->
	<form method="POST" action="/buster_moon/SearchServlet">
		<input type="text" style="width: 300px; height: 25px;" name="KEYWORD" placeholder="キーワードを入力してください">
		<input type="submit" name="SEARCH" value="検索" class="button1">
		<div class="table">
  			<table id="kensaku">
    			<tr>
					<td>
						<select name="GENRE">
							<option value=0>ジャンル</option>
							<option value=1>中華</option>
							<option value=2>ラーメン屋</option>
							<option value=3>イタリアン</option>
							<option value=4>和食・定食</option>
							<option value=5>カフェ</option>
							<option value=6>そば・うどん</option>
							<option value=7>ハンバーガー</option>
							<option value=8>スペイン料理</option>
							<option value=9>フレンチ</option>
							<option value=10>カレー</option>
							<option value=11>韓国料理</option>
							<option value=12>東南アジア料理</option>
							<option value=13>沖縄料理</option>
						</select>
					</td>

					<td>
      					<select name="PRICE">
      						<option value=0>価格帯</option>
      						<option value=500>500円</option>
      						<option value=700>700円</option>
      						<option value=1000>1000円</option>
      						<option value=2000>2000円</option>
     					 </select>
     				</td>

     				 <td>
     					 <select name="WALK">
							<option value="0">徒歩時間（片道）</option>
							<option value="3">3分</option>
							<option value="5">5分</option>
							<option value="10">10分</option>
							<option value="15">15分</option>
							<option value="20">20分</option>
						</select>
					</td>

      				<td>
      					<select name="SERVE">
							<option value=0>提供時間</option>
							<option value=3>3分</option>
							<option value=5>5分</option>
							<option value=10>10分</option>
							<option value=15>15分</option>
							<option value=20>20分</option>
						</select>
					</td>
 				</tr>
  				<tr>
     				 <td>
     					 <input type="checkbox" name="RANDOM" value="random">ランダム
     				 </td>

 <!-- 表示順のやつ
      <td>
      <select name="hyouji">
      <option value="display">表示順</option>
      <option value="display">五十音順</option>
      <option value="display">新着順</option>
      </select>
      </td>
-->
  				</tr>
 			</table>
 		</div>

<!-- 検索結果の表示 -->
<!-- ちょい検討中(武部)
<c:if test="${resutaurantList}">
</c:if>
-->
	</form>
		<div id="table">
			<c:forEach var="r" items="${restaurantList}" >
	<form method="POST" action="/buster_moon/RestaurantServlet">
  				<table id="list">
					<tr>
	  					<td class="tenmei">${r.restaurant}<input type="hidden" name="RESTAURANT" value="${r.restaurant}"></td>
					</tr>
					<tr>
						<td>
						<c:if test="${r.genre==1}">
						中華
						</c:if>
						<c:if test="${r.genre==2}">
						ラーメン屋
						</c:if>
						<c:if test="${r.genre==3}">
						イタリアン
						</c:if>
						<c:if test="${r.genre==4}">
						和食・定食
						</c:if>
						<c:if test="${r.genre==5}">
						カフェ
						</c:if>
						<c:if test="${r.genre==6}">
						そば・うどん
						</c:if>
						<c:if test="${r.genre==7}">
						ハンバーガー
						</c:if>
						<c:if test="${r.genre==8}">
						スペイン料理
						</c:if>
						<c:if test="${r.genre==9}">
						フレンチ
						</c:if>
						<c:if test="${r.genre==10}">
						カレー
						</c:if>
						<c:if test="${r.genre==11}">
						韓国料理
						</c:if>
						<c:if test="${r.genre==12}">
						東南アジア料理
						</c:if>
						<c:if test="${r.genre==13}">
						沖縄料理
						</c:if>
						</td>
						<td>価格${r.price}</td>
						<td>徒歩${r.walk}</td>
						<td>提供${r.serve}</td>
					</tr>
					<tr>
						<td>
							<input type="submit" name="SUBMIT" value="店舗詳細表示" >
						</td>
					</tr>
  				</table>
	</form>
  			</c:forEach>

		</div>
</div>

<script>
'use strict';

</script>
</body>
</html>
<!--
  <c:forEach var="r" items="${resutaurantList}" >
	<tr>
	  <td>${r.restaurant}</td>
	</tr>
	<tr>
	  <td><a href="resutaurant.jsp#news">${r.genre}</a></td>
	  <td>${r.price}</td>
	  <td>${r.walk}</td>
	  <td>${r.serve}</td>
	</tr>
  </c:forEach>

var value = ${genre}; // EL式からの値をJavaScriptの変数に代入
if (value === 1) {
  document.getElementById("result").innerHTML = "中華";
}
else if (value === 2) {
	  result = "ラーメン屋";
}
else if (value === 3) {
	  result = "イタリアン";
}
else if (value === 4) {
	  result = "和食・定食";
}
else if (value === 5) {
	  result = "カフェ";
}
else if (value === 6) {
	  result = "そば・うどん";
}
else if (value === 7) {
	  result = "ハンバーガー";
}
else if (value === 8) {
	  result = "スペイン料理";
}
else if (value === 9) {
	  result = "フレンチ";
}
else if (value === 10) {
	  result = "カレー";
}
else if (value === 11) {
	  result = "韓国料理";
}
else if (value === 12) {
	  result = "東南アジア料理";
}
else if (value === 13) {
	  result = "沖縄料理";
}
document.getElementById("result").innerHTML = result;

 -->