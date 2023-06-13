<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿</title>
<link rel="logo" href="img/logo.png">
<link rel = "stylesheet" href = /buster_moon/css/common.css>
<link rel = "stylesheet" href = /buster_moon/css/post.css>
</head>
<body>
<a href="/buster_moon/Time_lineServlet">タイムラインボタン</a><br>
<a href="/buster_moon/SearchServlet">検査ボタン</a><br>
<a href="/buster_moon/GatherServlet">一緒にどう？ボタン</a><br>
<a href="/buster_moon/My_profileServlet">プロフィールボタン</a><br>
<a href="/buster_moon/PostServlet"></a><br>

店名
<select name="restaurant_name"></select><br>
ジャンル
<select name="genre"></select><br>
写真
<form action="/buster_moon/RestaurantServlet" method="post" enctype="multipart/form-data">
  <input type="file" name="photo" accept="image/*">
</form><br>
価格
<select name="price"></select><br>
徒歩時間
<select name="walk"></select><br>
提供時間
<select name="serve"></select><br>
テキスト
<textarea name="text"></textarea><br>
<input type="submit" name="post_button" value="投稿">
</body>
</html>