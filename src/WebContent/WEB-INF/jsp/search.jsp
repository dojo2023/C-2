<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>物知りプラス</title>
<link rel="stylesheet" href="/buster_moon/css/search.css">
</head>
<body>
<h1>検索</h1>
<!-- メニューバーの表示 -->
  
<ul class="nav">
  <li><a href="/buster_moon/Time_lineServlet"><img src="/buster_moon/img/タイムライン.ico" alt=""></a></li>
  <li><a href="/buster_moon/PostServlet"><img src="/buster_moon/img/投稿.ico" alt=""></a></li>
  <li><a href="/buster_moon/GatherServlet"><img src="/buster_moon/img/募集.ico" alt=""></a></li>
  <li><a href="/buster_moon/SerchServlet"><img src="/buster_moon/img/検索.ico" alt=""></a></li>
  <li><a href="/buster_moon/ProfileServlet"><img src="/buster_moon/img/プロフィール.ico" alt=""></a></li>
  </ul>

 
 <!-- 検索の絞り込みの表示 -->
<form method="POST" action="/buster_moon/SearchServlet">  
<input type="text" style="width: 300px; height: 25px;" name="ID" placeholder="キーワードを入力してください">
<input type="submit" name="SEARCH" value="検索" class="button1">
<div class="table">
  <table id="list">    
    <tr>   
      <td>
      <select name="ja">
      <option value="genre">ジャンル</option>
      <option value="genre">中華</option>
      <option value="genre">ラーメン屋</option>
      <option value="genre">イタリアン</option>
      <option value="genre">和食・定食</option>
      <option value="genre">カフェ</option>
      <option value="genre">そば・うどん</option>
      <option value="genre">ハンバーガー</option>
      <option value="genre">スペイン料理</option>
      <option value="genre">フレンチ</option>
      <option value="genre">カレー</option>
      <option value="genre">韓国料理</option>
      <option value="genre">東南アジア料理</option>
      <option value="genre">沖縄料理</option>
      </select>
      </td>
      
      <td>
      <select name="kind">
      <option value="price">価格</option>
      <option value="price">～500円</option>
      <option value="price">500円～1000円</option>
      <option value="price">1000円～1500円</option>
      <option value="price">1500円～</option>
      </select>
      </td>
            
      <td>
      <select name="toho">
      <option value="walk">徒歩時間（片道）</option>
      <option value="walk">～5分</option>
      <option value="walk">5分～10分</option>
      <option value="walk">10分～15分</option>
      <option value="walk">15分～</option>
      </select>
      </td>
      
      <td>
      <select name="teikyo">
      <option value="serve">提供時間</option>
      <option value="serve">～5分</option>
      <option value="serve">5分～10分</option>
      <option value="serve">10分～15分</option>
      <option value="serve">15分～</option>
      </select>
      </td>                  
  </tr>
  <tr>
      <td>
      <input type="checkbox" name="random" value="random">ランダム
      </td>
      <td>
      <select name="hyouji">
      <option value="display">表示順</option>
      <option value="display">五十音順</option>
      <option value="display">新着順</option> 
      </select>     
      </td>
  </tr>
  </table>

<!-- 検索結果の表示 -->
<!--    
  <c:if test="${empty resutaurantList }">
  </c:if>
<c:if test="${empty resutaurantList }">
</c:if>

<div id="table">
  <table id="list">
  <c:forEach var="e" items="${resutaurantList}" >
  <form method="POST" action="/sim/SearchServlet">
	<tr>
	  <td><input class="data" type="text" name="POSTS_RESTAURANT" value="${e.posts_restaurant}"></td>
	</tr>
	<tr>
	  <td><a href="resutaurant.jsp#news"><input class="data" type="text" name="POSTS_GENRE" value="${e.posts_genre}"></a></td>
	  <td><input class="data" type="text" name="PRICE" value="${e.price}"></td>
	  <td><input class="data" type="text" name="WALK" value="${e.walk}"></td>
	  <td><input class="data" type="text" name="SERVE" value="${e.serve}"></td>
	</tr>
  </form>
  </c:forEach>
  </table>
  -->
  </div>
  </form>
</body>
</html>