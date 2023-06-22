<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/buster_moon/css/gather.css">
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
<form method="POST" action="/buster_moon/GatherServlet">
	<div class="gather_board">
	<div class="dropdown">

        <input type="button" name="gather" class="dropdown__btn" id="dropdown__btn" value="一緒にどう？">
        <div class="dropdown__body">
          <ul class="dropdown__list">
            <li class="dropdown__item">
                お店：<input type="text" name="RESTAURANT_NAME"><br>
            </li>
            <li class="dropdown__item">
                時間：<select name="TIME">
                      <option value=1>12:00</option>
                      <option value=2>12:05</option>
                      <option value=3>12:10</option>
                      </select><br>
            </li>
            <li class="dropdown__item">
                場所：<!-- 集合場所プルダウン -->
				<select name="PLACE">
				<option value=1>エレベーター前</option>
				<option value=2>玄関前</option>
				</select>
            </li>
            <li>
               
               <input type="submit"  name="SUBMIT" value="送信"  class="button1">
               
            </li>
          </ul>
        </div>
    </div>
	</div>
</form>
<!-- 募集を呼びかける掲示板画面のための/div -->
</div>

<!-- 一緒にどう？送信ここまで -->
<!-- メインここまで -->

<script src="/buster_moon/js/gather.js"></script>
</body>
</html>