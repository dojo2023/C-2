<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/buster_moon/css/my_profile.css">
<title>MYプロフィール｜物知りプラス</title>
</head>
<body>

<!-- ヘッダー？ -->
<!-- メニューバーの表示 -->
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
<!-- ヘッダー？ここまで -->

<!-- ここからアイコン・名前・編集・ポイント -->
<div class="centered">
<div class="table-wrapper">
<c:forEach var="profile" items="${profilesList}">
<table>
  <tr>
    <td><img src="${profile.icon}" alt="アイコン"></td>
    <td><input type="text" name="name" value="${profile.name}"></td>
    <td>
      <form action="Profile_editServlet" method="GET">
      <input type="submit" value="編集">
      </form>
     </td>
  </tr>
  <tr>
    <td><input type="text" name="introduction" value="${profile.introduction}"></td>
    <td><input type="text" name="sumpoint" value="${profile.t_point + profile.g_point + profile.c_point}"></td>
  </tr>
</table>
</c:forEach>
<!-- アイコン・名前・編集・ポイントここまで -->

<!--ここから 投稿一覧 -->
<c:forEach var="profile" items="${profilesList}">
    <table>
      <tr>
        <td><img src="${profile.icon}" alt="アイコン"></td>
          <c:forEach var="post" items="${postsList}">
        <td><input type="text" name="restaurant" value="${post.restaurant}"></td>
      </tr>
      <tr>
        <td><input type="text" name="genre" value="${post.genre}"></td>
      </tr>
      <tr>
        <td><input type="text" name="walk" value="${post.walk}"></td>
      </tr>
      <tr>
        <td><input type="text" name="serve" value="${post.serve}"></td>
      </tr>
      <tr>
        <td><input type="text" name="price" value="${post.price}"></td>
        <td><input type="text" name="text" value="${post.text}"></td>
        <td><img src="${post.photo}" alt="料理の写真"></td>
      </tr>
    </c:forEach>
    </table>
  </c:forEach>
  </div>
  </div>
<!-- 投稿一覧ここまで -->


<!-- アイコン・名前・編集 -->
</div>
</body>
</html>