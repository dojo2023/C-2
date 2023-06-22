<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <!-- メニューバーの表示 -->
      <ul class="nav">
        <li><a href="/buster_moon/Time_lineServlet"><img src="/buster_moon/img/timeLine.ico" alt=""></a></li>
        <li><a href="/buster_moon/PostServlet"><img src="/buster_moon/img/post.ico" alt=""></a></li>
        <li><a href="/buster_moon/GatherServlet"><img src="/buster_moon/img/gather.ico" alt=""></a></li>
        <li><a href="/buster_moon/SerchServlet"><img src="/buster_moon/img/search.ico" alt=""></a></li>
        <li><a href="/buster_moon/ProfileServlet"><img src="/buster_moon/img/profile.ico" alt=""></a></li>
      </ul>

      <form method="POST" id="posts_form" action="/buster_moon/PostServlet">

          ジャンル
          <select id="genre" name="genre">
             <option value=""<c:if test="${genre == ''}"> selected</c:if>>選択してください</option>
             <option value=1<c:if test="${genre == '1'}"> selected</c:if>>中華</option>
             <option value=2<c:if test="${genre == '2'}"> selected</c:if>>ラーメン屋</option>
             <option value=3<c:if test="${genre == '3'}"> selected</c:if>>イタリアン</option>
             <option value=4<c:if test="${genre == '4'}"> selected</c:if>>和食・定食</option>
             <option value=5<c:if test="${genre == '5'}"> selected</c:if>>カフェ</option>
             <option value=6<c:if test="${genre == '6'}"> selected</c:if>>そば・うどん</option>
             <option value=7<c:if test="${genre == '7'}"> selected</c:if>>ハンバーガー</option>
             <option value=8<c:if test="${genre == '8'}"> selected</c:if>>スペイン料理</option>
             <option value=9<c:if test="${genre == '9'}"> selected</c:if>>フレンチ</option>
             <option value=10<c:if test="${genre == '10'}"> selected</c:if>>カレー</option>
             <option value=11<c:if test="${genre == '11'}"> selected</c:if>>韓国料理</option>
             <option value=12<c:if test="${genre == '12'}"> selected</c:if>>東南アジア料理</option>
             <option value=13<c:if test="${genre == '13'}"> selected</c:if>>沖縄料理</option>
          </select>
          <input type="submit" name="button" value="店舗検索"><br>
          店名
          <select name="restaurant" id="restaurant_name">
            <option value="" selected>選択してください</option>
            <c:forEach var="e" items="${shiborikomiList}">
            <option  value="${e.restaurant}">${e.restaurant}</option>
            </c:forEach>
          </select><br>
          写真
          <input type="file" name="photo" accept="image/*">
          <br>

          価格帯
          <select name="price">
           <option value="" selected>一番近いものを選択してください</option>
           <option value="500">500円</option>
           <option value="700">700円</option>
           <option value="1000">1000円</option>
           <option value="1500">1500円</option>
           <option value="2000">2000円</option>
         </select><br>

         片道時間
        <select name="walk">
          <option value="" selected>一番近いものを選択してください</option>
          <option value="3">3分</option>
          <option value="5">5分</option>
          <option value="10">10分</option>
          <option value="15">15分</option>
          <option value="20">20分</option>
        </select><br>

        提供時間
        <select name="serve">
         <option value="" selected>一番近いものを選択してください</option>
         <option value="3">3分</option>
         <option value="5">5分</option>
         <option value="10">10分</option>
         <option value="15">15分</option>
         <option value="20">20分</option>
        </select><br>
        <p></p>
        テキスト（140字以内)<br>
         <textarea name="text" onChange="check()"></textarea><br>

       <input type="submit" name="button" value="投稿">
      </form>
    </body>
  </html>

<script>
  'use strict';

  function check(){
	txt = document.posts_form.text.value;
    n = txt.length;
    if(n > 140){
    	console.log(window.confirm('テキストは140字以内で入力してください'));
    }
  }


  var formObj = document.getElementById('posts_form').onsubmit = function() {
	console.log('クリックされました');
  };


</script>


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


