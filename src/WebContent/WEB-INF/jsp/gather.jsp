<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper">
<!-- ヘッダーここから -->
<h1>一緒にどう？</h1>
<!-- ヘッダーここまで -->
<!-- メインここから -->
<h2>ここにお店・集合時間・場所を設定してお昼を食べる仲間を募集しよう！</h2>

<!-- ここからメニューバー -->
<nav>
    <ul id="nav">
      <li><a href="/buster_moon/Time_lineServlet">タイムライン</a></li>
      <li><a href="/buster_moon/SearchServlet">検索</a></li>
      <li><a href="/buster_moon/PostServlet">登録</a></li>
      <li><a href="/buster_moon/GatherServlet">一緒にどう？</a></li>
      <li><a href="/buster_moon/My_profileServlet">プロフィール</a></li>
    </ul>
 </nav>
 <!-- メニューバーここまで -->

<!-- ここから募集を表示 -->
<!-- 募集を表示ここまで -->

<!-- ｌここから一緒にどう？送信 -->

<!-- 募集を呼びかける掲示板画面のためのdiv -->
<div class="gather_board">

<!-- ここから募集を表示 -->

<form id="gather_form" method="POST" action="/buster_moon/GatherServlet">

<!-- お店・集合時間・集合場所がまとまった「一緒にどう？」ボタン？ -->
<input type="button" name="gather" value="一緒にどう？">

<!-- 送信ボタン -->
<input type="submit" name="submit" value="送信"><br>


<!-- お店の名前を入力する欄 -->
お店：<input type="text" name="TEXT"><br>

<!-- 集合時間プルダウン -->
時間：<select name="time">
<option>12:00</option>
<option>12:05</option>
<option>12:10</option>
</select><br>

場所：<!-- 集合場所プルダウン -->
<select name="place">
<option>エレベーター前</option>
<option>玄関</option>
</select>

</form>
<!-- 募集を呼びかける掲示板画面のための/div -->
</div>

<!-- 一緒にどう？送信ここまで -->
<!-- メインここまで -->
</div>
</body>
</html>