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
  <table>
    <c:forEach var="post" items="${postsList}">
      <tr>
        <td><input type="text" name="restaurant" value="${post.restaurant}" class="post-restaurant"></td>
      </tr>
      <tr>
        <td><input type="text" name="genre" value="${post.genre}" class="post-genre"></td>
      </tr>
      <tr>
        <td><input type="text" name="walk" value="${post.walk}" class="post-walk"></td>
      </tr>
      <tr>
        <td><input type="text" name="serve" value="${post.serve}" class="post-serve"></td>
      </tr>
      <tr>
        <td><input type="text" name="price" value="${post.price}" class="post-price"></td>
        <td><input type="text" name="text" value="${post.text}" class="post-text"></td>
        <td><img src="${post.photo}" alt="料理の写真" class="post-photo"></td>
      </tr>
    </c:forEach>
  </table>
</div>




<!-- 投稿一覧ここまで -->


<!-- アイコン・名前・編集 -->
</div>
</body>
</html>