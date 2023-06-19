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

<!-- アイコン -->
<img src="${e.icon}" alt="アイコン">

<!-- 名前 -->
<input type="text" name="name" value="${e.name}">

<!-- 編集ボタン -->
<input type="submit" name="edit" value="編集">

<!-- 自己紹介 -->
<input type="text" name="introduction" value="${introduction}">

<!-- ポイント合計 -->


<!-- 投稿一覧 -->
<c:forEach var="e" items="${profilesList}">
    <img src="${e.icon}" alt="アイコン">
    <input type="text" name="name" value="${e.name}">
</c:forEach>

<!-- アイコン・名前・編集 -->

</body>
</html>