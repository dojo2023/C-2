<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/buster_moon/css/time_line.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- メニューバーの表示 -->
<ul class="nav">
  <li><a href="/buster_moon/Time_lineServlet">タイムライン</a></li>
  <li><a href="/buster_moon/PostServlet">投稿</a></li>
  <li><a href="/buster_moon/SerchServlet">検索</a></li>
  <li><a href="/buster_moon/GatherServlet">一緒にどう？</a></li>
  <li><a href="/buster_moon/ProfileServlet">プロフィール></a></li>
</ul>

<div id="ranks">
<h2>ランキング</h2>
<c:forEach var="p" items="${profilesList}">
		<table>
			<tr>
			    <td>${p.name}</td>
				<td><img src="${'/buster_moon/img/'+=p.icon}"></td>
				<td>${p.t_point+p.g_point+p.c_point}</td>
			</tr>
		</table>
</c:forEach>
</div>
<label>
<c:forEach var="e" items="${postsList}">
<hr>
<div class="posts">
	<div><img src="${'/buster_moon/img/'+=e.icon}"></div>
	<div>(投稿者名)${e.name}</div>
	<div>店名：${e.restaurant}</div>
		<div id="post_inf">
		<table>
			<tr><td>ジャンル:</td><td>${e.genre}</td></tr>
			<tr><td>徒歩時間:</td><td>${e.walk}</td></tr>
			<tr><td>提供時間:</td><td>${e.serve}</td></tr>
			<tr><td>価格:</td><td>${e.price}</td></tr>
		</table>
		<div>${e.text}</div>
		<div><img src="${'/buster_moon/img/'+=e.photo}"></div>
	</div>
	<form method="POST" action="/buster_moon/Time_lineServlet">
	<input type="text" name="ID" value="${e.id} ">
	<input type="submit" name="SUBMIT" value="コメント表示" >
	</form>
</div>
<hr>
</c:forEach >
</label>

<div id="popup">
	<h2>この投稿にされたコメント</h2>
	<c:forEach var="c" items="${commentsList}">
		<form method="POST" action="/buster_moon/Time_lineServlet" >
			<hr>
			<table>
			<tr>
				<td>
				<img src="${'/buster_moon/img/'+=c.icon}">
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
					<input type="submit" name="SUBMIT" value="削除" >
					</c:if>
				</td>
			</tr>


			</table>
		</form>
	</c:forEach>
	<form method="POST" action="/buster_moon/Time_lineServlet" >
		<c:if test="${commentsList!=null}">
				<hr>
				<h2>コメント入力欄</h2>
				<input type="hidden" name="POSTS_ID" value="${posts_id}">
				<input type="text" name="TEXT" value="コメント入力">
				<input type="submit" name="SUBMIT" value="送信" >
		</c:if>
	</form>
</div>
</body>
<style>
#popup {
  background: #fff;
  display: inline;
  bottom: 0;
  left: 0;
  padding: 20px;
  position: fixed;
  width: 100%;
}
#ranks {
  background: #fff;
  display: block;
  top: 0;
  left: 0;
  padding: 5px;
  position: fixed;
  width: 100%;
}
</style>
</html>