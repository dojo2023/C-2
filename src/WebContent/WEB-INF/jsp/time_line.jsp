<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タイムライン</title>
<link rel="icon" href="img/favicon.ico">
<link rel="stylesheet" href="/buster_moon/css/time_line.css">
</head>
<body>
<div class="wrapper">
<div id="ranks">
<h2 id="ranksH2">ポイントランキング</h2>
<c:forEach var="p" items="${profilesList}">
		<table id = junni>
			<tr>
			    <td>｜${p.name}</td>
				<td></td>
				<td>${p.t_point+p.g_point+p.c_point}pt</td>
			</tr>
		</table>
</c:forEach>
</div>
<!-- メニューバーの表示 -->
	<nav class="menubar">
		<ul>
			<li class="menu1"><a href="/buster_moon/Time_lineServlet"></a></li>
			<li class="menu2"><a href="/buster_moon/PostServlet"></a></li>
			<li class="menu3"><a href="/buster_moon/SearchServlet"></a></li>
			<li class="menu4"><a href="/buster_moon/GatherServlet"></a></li>
			<li class="menu5"><a href="/buster_moon/My_profileServlet"></a></li>
		</ul>
	</nav>
<br>
<c:forEach var="e" items="${postsList}">
<div class="posts">
	<div></div>
	<div>　${e.name}さんの投稿 ${e.date}</div>
	<hr class="ename">
	<div>　店名：${e.restaurant}</div>
		<div id="post_inf">
		<table>
			<tr class="con">
			<td>　ジャンル:</td>
				<td>
					<c:if test="${e.genre==1}">
					中華
					</c:if>
					<c:if test="${e.genre==2}">
					ラーメン屋
					</c:if>
					<c:if test="${e.genre==3}">
					イタリアン
					</c:if>
					<c:if test="${e.genre==4}">
					和食・定食
					</c:if>
					<c:if test="${e.genre==5}">
					カフェ
					</c:if>
					<c:if test="${e.genre==6}">
					そば・うどん
					</c:if>
					<c:if test="${e.genre==7}">
					ハンバーガー
					</c:if>
					<c:if test="${e.genre==8}">
					スペイン料理
					</c:if>
					<c:if test="${e.genre==9}">
					フレンチ
					</c:if>
					<c:if test="${e.genre==10}">
					カレー
					</c:if>
					<c:if test="${e.genre==11}">
					韓国料理
					</c:if>
					<c:if test="${e.genre==12}">
					東南アジア料理
					</c:if>
					<c:if test="${e.genre==13}">
					沖縄料理
					</c:if>
				</td>
			</tr>
			<tr class="con"><td>徒歩時間:</td><td>${e.walk}分</td></tr>
			<tr class="con"><td>提供時間:</td><td>${e.serve}分</td></tr>
			<tr class="con"><td>価格:</td><td>${e.price}円</td></tr>
		</table>
		<hr class="ename">
		<div>　${e.text}</div>
		<div>　<img src="${'/buster_moon/img/'+=e.photo}" id="photo"></div>
	</div>
	<form method="POST" action="/buster_moon/Time_lineServlet">
	<input type="hidden" name="ID" value="${e.id} ">
	<input type="submit" name="SUBMIT" value="コメント表示" class="post_button">
	</form>
</div>
<hr>
</c:forEach >
<br>
<br>
<br>
<br>
<br>
</label>

<div id="popup">
    <h3>投稿に対するコメント</h3>
	<c:if test="${commentsList!=null}">

	<c:forEach var="c" items="${commentsList}">
		<form method="POST" action="/buster_moon/Time_lineServlet" >
			<hr>
			<table>
			<tr>
				<td>
				${c.name}
				${c.date}
				</td>
			</tr>
			<input type="hidden" name="ID" value="${c.id}">
			<input type="hidden" name="POSTS_ID" value="${c.posts_id}">
			<input type="hidden" name="USERS_ID" value="${c.users_id}" >
			<tr>
				<td>${c.text}</td>
				<td>
					<c:if test="${users_id.equals(c.users_id) }">
					<input type="submit" name="SUBMIT" value="削除" class="post_button">
					</c:if>
				</td>
			</tr>


			</table>
		</form>
	</c:forEach>
	<form method="POST" action="/buster_moon/Time_lineServlet" >
		<c:if test="${commentsList!=null}">
				<hr>
				<h3>コメント入力欄</h3>
				<input type="hidden" name="POSTS_ID" value="${posts_id}">
				<input type="text" name="TEXT" placeholder="コメント入力">
				<input type="submit" name="SUBMIT" value="送信" class="post_button">
		</c:if>
	</form>
			<form method="POST" action="/buster_moon/Time_lineServlet" id = "close">
			<input type="submit" name="SUBMIT" value="コメント欄を閉じる" class="post_button">
		</form>
	</c:if>
</div>
</div>
</body>
</html>