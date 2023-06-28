<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/buster_moon/css/my_profile.css">
<link rel="icon" href="img/favicon.ico">
<title>MYプロフィール｜物知りプラス</title>
</head>
<body>

<!-- ヘッダー？ -->
<!-- メニューバーの表示 -->
<div class="wrapper">
<h1>マイプロフィール</h1>
<nav>
  <ul>
  	<li class="menu1"><a href="/buster_moon/Time_lineServlet"></a></li>
 	<li class="menu2"><a href="/buster_moon/PostServlet"></a></li>
 	<li class="menu3"><a href="/buster_moon/SearchServlet"></a></li>
  	<li class="menu4"><a href="/buster_moon/GatherServlet"></a></li>
	<li class="menu5"><a href="/buster_moon/My_profileServlet"></a></li>
  </ul>
</nav>
<!-- ヘッダー？ここまで -->

<!-- ここからアイコン・名前・編集・ポイント -->
<div class="profile-box">
<c:forEach var="profile" items="${profilesList}">
    <input type="text" name="name" value="${profile.name}" class="profile-name">
      <div class="edit-button">
      <form action="Profile_editServlet" method="GET">
      <input type="submit" value="編集">
      </form>
      </div>
      <input type="text" name="introduction" value="${profile.introduction}" class="profile-introduction">
      <input type="text" name="sumpoint" value="${profile.t_point + profile.g_point + profile.c_point}" class="profile-point">
</c:forEach>
</div>
<!-- アイコン・名前・編集・ポイントここまで -->

<!--ここから 投稿一覧 -->
<div class="post-box">
 <form id="post_form">
  <table>
    <c:forEach var="post" items="${postsList}">
      <tr>
        <th class="tenmei">店名</th>
          <td>${post.restaurant}</td>
        <th>ジャンル</th>
          <td><c:if test="${post.genre==1}">
						中華
						</c:if>
						<c:if test="${post.genre==2}">
						ラーメン屋
						</c:if>
						<c:if test="${post.genre==3}">
						イタリアン
						</c:if>
						<c:if test="${post.genre==4}">
						和食・定食
						</c:if>
						<c:if test="${post.genre==5}">
						カフェ
						</c:if>
						<c:if test="${post.genre==6}">
						そば・うどん
						</c:if>
						<c:if test="${post.genre==7}">
						ハンバーガー
						</c:if>
						<c:if test="${post.genre==8}">
						スペイン料理
						</c:if>
						<c:if test="${post.genre==9}">
						フレンチ
						</c:if>
						<c:if test="${post.genre==10}">
						カレー
						</c:if>
						<c:if test="${post.genre==11}">
						韓国料理
						</c:if>
						<c:if test="${post.genre==12}">
						東南アジア料理
						</c:if>
						<c:if test="${post.genre==13}">
						沖縄料理
						</c:if></td>
      </tr>
      <tr>
        <th>徒歩時間</th>
          <td>約${post.walk}分</td>
          <td rowspan="3" colspan="3"><img src="${post.photo}" alt="料理の写真" class="post-photo"></td>
      </tr>
      <tr>
        <th>提供時間</th>
          <td>約${post.serve}分</td>
      </tr>
      <tr>
        <th>価格</th>
          <td>約${post.price}円</td>
      </tr>
      <tr>
        <th>レビュー</th>
          <td>${post.text}</td>
      </tr>
    </c:forEach>
  </table>
 </form>
</div>




<!-- 投稿一覧ここまで -->


<!-- アイコン・名前・編集 -->
</div>
</body>
</html>