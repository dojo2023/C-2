<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<body>
<title>プロフィール編集</title>

プロフィールアイコン<br>
  <img src="" alt="icon">
  <input type="file" name="photo" accept="image/*">
  <br>
名前
  <input type="text" name="name"><br>
自己紹介
  <textarea name="introduction"></textarea><br>
パスワードの変更<br>
  現在のパスワード<input type="text" name="password"><br>
  新しいパスワード<input type="text" name="new_password"><br>
  新しいパスワード（再入力）<input type="text" name="new_password"><br>
投稿
  <form action="/buster_moon/PostServlet" method="get" enctype=""></form><br>
<input type="submit" name="completion" value="変更を完了する">
<a href="/buster_moon/My_profileServlet">キャンセル</a><br>

</head>

</body>
</html>