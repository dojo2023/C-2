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
       <nav>
			<ul>
  				<li class="menu1"><a href="/buster_moon/Time_lineServlet"></a></li>
 				<li class="menu2"><a href="/buster_moon/PostServlet"></a></li>
 				<li class="menu3"><a href="/buster_moon/SearchServlet"></a></li>
  				<li class="menu4"><a href="/buster_moon/GatherServlet"></a></li>
				<li class="menu5"><a href="/buster_moon/My_profileServlet"></a></li>
  			</ul>
  	</nav>

      <form method="POST" id="posts_form" action="/buster_moon/PostServlet" enctype="multipart/form-data" id="postForm">
		  <c:if test="${bonus!=null}">
      	  	  <input type="submit" name="button" value="x">
			  <div><img src="${bonus}"><audio controls><source src="${bonus2}"></audio></div>
		  </c:if>
		  <input type="hidden" id="bonus" name="bonus" value="${bonus}">
	      <input type="hidden" id="bonus2" name="bonus2" value="${bonus2}">
		  <input type="submit" name="button" value="店舗検索">
          <select name="restaurant" id="restaurant_name">
            <option value="" selected>店名</option>
            <c:forEach var="e" items="${shiborikomiList}">
            <option  value="${e.restaurant}">${e.restaurant}</option>
            </c:forEach>
          </select>
          <select id="genre" name="genre">
             <option value=""<c:if test="${genre == ''}"> selected</c:if>>ジャンル</option>
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
          <input type="submit" name="button" value="店舗検索">
          <input type="submit" name="button" value="投稿" id="post_button">
          <br>
          写真 ※ファイル名は30文字以下の半角英数字で入力してください。
          <input type="file" name="photo" accept="image/*" id=photo>
          <br>

        <div class= "pull_down">
          <select name="price" id="price">
           <option value="" selected>価格</option>
           <option value="500">500円</option>
           <option value="700">700円</option>
           <option value="1000">1000円</option>
           <option value="1500">1500円</option>
           <option value="2000">2000円</option>
         </select>
         <br>

        <select name="walk" id="walk">
          <option value="" selected>片道時間</option>
          <option value="3">3分</option>
          <option value="5">5分</option>
          <option value="10">10分</option>
          <option value="15">15分</option>
          <option value="20">20分</option>
        </select><br>

        <select name="serve" id="serve">
         <option value="" selected>提供時間</option>
         <option value="3">3分</option>
         <option value="5">5分</option>
         <option value="10">10分</option>
         <option value="15">15分</option>
         <option value="20">20分</option>
        </select>
        </div>
        <br>
        <p></p>
        <br>
         <textarea name="text" onChange="check()" placeholder="テキスト" id="textBox"></textarea><br>
      </form>
    </body>
  </html>

<script>
  'use strict';

  document.getElementById("post_button").onclick=function check() {
	  if(window.confirm('この内容でよろしいですか？')) {

//		  let a=360;
//		  let b=1152;
//		  let c=1944:
//		  let d=2544;

		  //講師毎の確率の画像音声表示
		  let r=Math.floor(Math.random()*3600)+1;

		  //寺井
		  if(r<360){
			  document.getElementById("bonus").value="/buster_moon/img/terai.jpg";
			  document.getElementById("bonus2").value="/buster_moon/img/terai.mp3";
		  }

		  //大石
		  else if(r>=360&&r<1152){
			  document.getElementById("bonus").value="/buster_moon/img/ooisi.jpg";
			  document.getElementById("bonus2").value="/buster_moon/img/ooisi.mp3";
		  }

		  //末永
		  else if(r>=1152&&r<1944){
			  document.getElementById("bonus").value="/buster_moon/img/suenaga.jpg";
			  document.getElementById("bonus2").value="/buster_moon/img/suenaga.mp3";
		  }

		  //富原
		  else if(r>=1944&&r<2544){
			  document.getElementById("bonus").value="/buster_moon/img/tomihara.JPG";
			  document.getElementById("bonus2").value="/buster_moon/img/tomihara.mp3";
		  }

		  //矢沢
		  else{
			  document.getElementById("bonus").value="/buster_moon/img/yazawa.PNG";
			  document.getElementById("bonus2").value="/buster_moon/img/yazawa.mp3";
		  }

		  return true;
	  } else {
	      window.alert('キャンセルしました。')
	      return false;
	  }
	};

</script>
  <%--
    function check(){
	txt = document.posts_form.text.value;
    n = txt.length;
    if(n > 140){
    	console.log(window.confirm('テキストは140字以内で入力してください'));
    }
  }
--%>

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


