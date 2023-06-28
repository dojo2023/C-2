<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一緒にどう？</title>
<link rel="icon" href="img/favicon.ico">
<link rel="stylesheet" href="/buster_moon/css/gather.css">
</head>
<body>
<div class="wrapper">
	<!-- ヘッダーここから -->
	<h1 class="h1">一緒にどう？</h1>
	<!-- ヘッダーここまで -->
	<!-- メインここから -->
	<h3 class="h3">ここにお店・集合時間・場所を設定してお昼を食べる仲間を募集しよう！</h3>
	<hr>

<!-- ここからメニューバー -->
	<nav class="menubar">
		<ul>
			<li class="menu1"><a href="/buster_moon/Time_lineServlet"></a></li>
			<li class="menu2"><a href="/buster_moon/PostServlet"></a></li>
			<li class="menu3"><a href="/buster_moon/SearchServlet"></a></li>
			<li class="menu4"><a href="/buster_moon/GatherServlet"></a></li>
			<li class="menu5"><a href="/buster_moon/My_profileServlet"></a></li>
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

               				<input type="submit"  name="SUBMIT" value="送信"  id="gather_button">

            			</li>
          			</ul>
        		</div>
    		</div>
		</div>
	</form>
<!-- 募集を呼びかける掲示板画面のための/div -->
	<div id="table">
  		<table id="list">
  			<c:forEach var="b" items="${gathersList}" >
  		<form method="POST" action="/buster_moon/GatherServlet">
			<table>

			<tr>
			    <td class="name">${b.name}</td>
			</tr>
			<tr>
			    <td>店名:${b.restaurant_name}</td>
			</tr>
			<tr>
				<td>集合時間：
				<c:if test="${b.time==1}">
				12:00
				</c:if>
				<c:if test="${b.time==2}">
				12:05
				</c:if>
				<c:if test="${b.time==3}">
				12:10
				</c:if>
				</td>
			</tr>
			<tr>
				<td>集合場所：
				<c:if test="${b.place==1}">
				エレベーター前
				</c:if>
				<c:if test="${b.place==2}">
				玄関前
				</c:if>
				</td>
			</tr>
			<tr>
				<td>${b.date}</td>
			</tr>
			<tr>
				<td><input type="hidden" name="ID" value=${b.users_id}></td>
			</tr>
			<tr>
				<td><input type="hidden" name="ID" value=${b.id}></td>
			</tr>
			<tr>
				<td><input type="hidden" name="ID" value=${id}></td>
			</tr>
			<!--  <tr>
				<td><input type="submit" name="SUBMIT" value="👍" ></td>
			</tr>-->
			<tr>
				<c:if test="${id.equals(b.users_id) }">
				<td><input type="submit" name="SUBMIT" value="削除" id="gather_button"></td>
				</c:if>
			</tr>
			<hr>
			</table>
		</form>
 		</c:forEach>
  		</table>
	</div>
	<hr>
<!-- 一緒にどう？送信ここまで -->
<!-- メインここまで -->
</div>
<script src="/buster_moon/js/gather.js"></script>
</body>
</html>