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
<a href="/buster_moon/SearchServlet">検索ボタン</a><br>
<a href="/buster_moon/GatherServlet">一緒にどう？ボタン</a><br>
<a href="/buster_moon/My_profileServlet">プロフィールボタン</a><br>
<a href="/buster_moon/PostServlet"></a><br>

<c:forEach var="e" items="${restaurantList}">
ジャンル
<select id="genre">
  <option value="" selected>選択してください</option>
  <option value="1">中華</option>
  <option value="2">ラーメン屋</option>
  <option value="3">イタリアン</option>
  <option value="4">和食・定食</option>
  <option value="5">カフェ</option>
  <option value="6">そば・うどん</option>
  <option value="7">ハンバーガー</option>
  <option value="8">スペイン料理</option>
  <option value="9">フレンチ</option>
  <option value="10">カレー</option>
  <option value="11">韓国料理</option>
  <option value="12">東南アジア料理</option>
  <option value="13">沖縄料理</option>
</select><br>


店名
<select id="restaurant_name">
  <option value="1" selected>選択してください</option>

  <option value="${e.posts_restaurant}"></option>


</select><br>
</c:forEach>

写真
<form action="/buster_moon/RestaurantServlet" method="post" enctype="multipart/form-data">
  <input type="file" name="photo" accept="image/*">
</form><br>
価格帯
<select name="price">
  <option value="" selected>選択してください</option>
  <option value="1">～500円</option>
  <option value="2">500～1000円</option>
  <option value="3">1000～1500円</option>
  <option value="4">1500～2000円</option>
</select><br>

片道時間
<select name="walk">
  <option value="" selected>選択してください</option>
  <option value="1">～5分</option>
  <option value="2">5～10分</option>
  <option value="3">10～15分</option>
  <option value="4">15分～</option>
</select><br>

提供時間
<select name="serve">
  <option value="" selected>選択してください</option>
  <option value="1">～5分</option>
  <option value="2">5～10分</option>
  <option value="3">10～15分</option>
  <option value="4">15分～</option>
</select><br>

テキスト
<textarea name="text"></textarea><br>

<input type="submit" name="post_button" value="投稿">
</body>
</html>


<%--
<script>

var array = new Array();
array[''] = new Array ({cd:"0", label:"選択してください"});
array["1"] = new Array(
		  {cd:"1", label:"登龍"},
		  {cd:"2", label:"三貴苑"},
		  {cd:"3", label:"紅華美楼"}
		);
array["2"] = new Array(
		  {cd:"1", label:"極や"},
		  {cd:"2", label:"天雷軒"},
		  {cd:"3", label:"ソラノイロ"}
		);
array["3"] = new Array(
		  {cd:"1", label:"エリオ・ロカンダ・イタリアーナ"},
		  {cd:"2", label:"Trattoria MUTSUMI"},
		  {cd:"3", label:"cicchetti"}
		);

document.getElementById('genre').onchange = function(){
	restaurant_name = document.getElementById("restaurant_name");
	restaurant_name.options.length = 0
	  var changedGenre = genre.value;
	  for (let i = 0; i < array[changedGenre].length; i++) {
	    var op = document.createElement("option");
	    value = array[changedGenre][i]
	    op.value = value.cd;
	    op.text = value.label;
	    restaurant_name.appendChild(op);
	  }
	}
</script>--%>


