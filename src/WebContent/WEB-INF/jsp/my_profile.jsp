<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYプロフィール｜物知りプラス</title>
</head>
<body>

<!-- ヘッダー？ -->
<h5 id="logo">
  <img src="/buster_moon/img/logo.png" width=3% height=3% alt="MONOSHIRI+">
</h5>
<hr>
<!-- ヘッダー？ここまで -->

<!-- アイコン・名前・編集 -->

<table>
  <tr>
    <td><img src="${e.icon}" alt="アイコン"></td>
    <td><input type="text" name="name" value="${e.name}"></td>
    <td><input type="submit" name="edit" value="編集"></td>
    <td><input type="text" name="introduction" value="${e.introduction}"></td>
  </tr>
</table>

<!-- ポイント合計 -->


<!-- 投稿一覧 -->
<c:forEach var="profile" items="${profilesList}">
  <img src="${profile.icon}" alt="アイコン">
  <c:forEach var="post" items="${postsList}">
    <input type="text" name="restaurant" value="${post.restaurant}">
    <input type="text" name="genre" value="${post.genre}">
    <input type="text" name="walk" value="${post.walk}">
    <input type="text" name="serve" value="${post.serve}">
    <input type="text" name="price" value="${post.price}">
    <input type="text" name="text" value="${post.text}">
    <img src="${post.photo}" alt="料理の写真">
  </c:forEach>
</c:forEach>

<!-- アイコン・名前・編集 -->

</body>
</html>