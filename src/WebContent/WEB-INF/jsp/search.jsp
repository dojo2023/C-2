<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>物知りプラス</title>
<link rel="stylesheet" href="/buster_moon/css/search.css">
</head>
<body>
<h1>検索</h1>
<!-- メニューバーの表示 -->

<ul class="nav">
  <li><a href="/buster_moon/Time_lineServlet"><img src="/buster_moon/img/タイムライン.ico" alt=""></a></li>
  <li><a href="/buster_moon/PostServlet"><img src="/buster_moon/img/投稿.ico" alt=""></a></li>
  <li><a href="/buster_moon/GatherServlet"><img src="/buster_moon/img/募集.ico" alt=""></a></li>
  <li><a href="/buster_moon/SerchServlet"><img src="/buster_moon/img/検索.ico" alt=""></a></li>
  <li><a href="/buster_moon/ProfileServlet"><img src="/buster_moon/img/プロフィール.ico" alt=""></a></li>
  </ul>


 <!-- 検索の絞り込みの表示 -->
<form method="POST" action="/buster_moon/SearchServlet">
<input type="text" style="width: 300px; height: 25px;" name="KEYWORD" placeholder="キーワードを入力してください">
<input type="submit" name="SEARCH" value="検索" class="button1">
<div class="table">
  <table id="list">
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
      <option value=0>徒歩時間（片道）</option>
      <option value=3>3分</option>
      <option value=5>5分</option>
      <option value=10>10分</option>
      <option value=15>15分</option>
      <option value=20>20分</option>
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

<%= request.getAttribute("restaurantList") %>

<div id="table">
  <table id="list">
  <c:forEach var="r" items="${resutaurantList}" >
	<tr>
	  <td>店名${r.restaurant}</td>
	</tr>
	<tr>
	  <td>ジャンル${r.genre}</td>
	  <td>価格${r.price}</td>
	  <td>徒歩${r.walk}</td>
	  <td>提供${r.serve}</td>
	</tr>
  </c:forEach>
  </table>
  </div>
  </form>
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

 -->