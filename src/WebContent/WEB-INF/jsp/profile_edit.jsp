<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロフィール編集 | 物知りプラス</title>
<link rel="stylesheet" href="/buster_moon/css/profile_edit.css">
<link rel="icon" href="img/favicon.ico">
</head>
<body>
<div class="container">
  <h1>プロフィール編集</h1>
  <!-- ここからアイコン・名前・自己紹介・パスワードの編集 -->
  <form id="edit_form" method="POST" action="/buster_moon/Profile_editServlet">
    <c:forEach var="profile" items="${profilesList}">
      <div class="table-container">
        <table>
          <tr>
            <td><input type="text" name="name" value="${profile.name}"></td>
          </tr>
          <tr>
            <td><input type="text" name="introduction" value="${profile.introduction}"></td>
          </tr>
          <tr>
            <td>現在のパスワードを入力してください<br><input type="password" name="password"></td>
          </tr>
          <tr>
            <td>新しいパスワードを入力してください<br><input type="password" name="newPassword"></td>
          </tr>
          <tr>
            <td>確認のためもう一度、新しいパスワードを入力してください<br><input type="password" name="newPassword"></td>
          </tr>
          <tr>
            <td>
              <input type="submit" name="SUBMIT" value="変更を完了する" onclick="return confirm('変更内容を保存しますか？')">
            </td>
            <td>
              <input type="submit" name="SUBMIT" value="キャンセル">
            </td>
          </tr>
        </table>
      </div>
    </c:forEach>
  </form><br>
  <!-- アイコン・名前・自己紹介・パスワードの編集ここまで -->

  <!-- ここから自分の投稿の削除・変更完了・キャンセル -->
  <form id="dalete_post" method="POST" action="/buster_moon/Profile_editServlet">
    <c:forEach var="post" items="${postsList}">
      <div class="table-container">
        <table>
          <tr>
            <th class="tenmei">店名</th>
            <td>${post.restaurant}</td>
            <th>ジャンル</th>
            <td>
              <c:if test="${post.genre==1}">
                中華
              </c:if>
              <c:if test="${post.genre==2}">
                ラーメン屋
              </c:if>
              <c:if test="${post.genre==3}">
                イタリアン
              </c:if>
              <c:if test="${post.genre==4}">
                和食・定食
              </c:if>
              <c:if test="${post.genre==5}">
                カフェ
              </c:if>
              <c:if test="${post.genre==6}">
                そば・うどん
              </c:if>
              <c:if test="${post.genre==7}">
                ハンバーガー
              </c:if>
              <c:if test="${post.genre==8}">
                スペイン料理
              </c:if>
              <c:if test="${post.genre==9}">
                フレンチ
              </c:if>
              <c:if test="${post.genre==10}">
                カレー
              </c:if>
              <c:if test="${post.genre==11}">
                韓国料理
              </c:if>
              <c:if test="${post.genre==12}">
                東南アジア料理
              </c:if>
              <c:if test="${post.genre==13}">
                沖縄料理
              </c:if>
            </td>
          </tr>
          <tr>
            <th>徒歩時間</th>
            <td>約${post.walk}分</td>
            <td rowspan="3" colspan="3"><img src="${post.photo}" alt="料理の写真" class="post-photo"></td>
          </tr>
          <tr>
            <th>提供時間</th>
            <td>約${post.serve}分</td>
          </tr>
          <tr>
            <th>価格</th>
            <td>約${post.price}円</td>
          </tr>
          <tr>
            <th>レビュー</th>
            <td>${post.text}</td>
          </tr>
          <tr>
            <td class="delete"><input type="submit" name="SUBMIT" value="削除" onclick="return confirm('削除してもよろしいですか？')"></td>
          </tr>
        </table>
      </div>
    </c:forEach>
  </form>
  <!-- 自分の投稿削除・変更完了・キャンセルここまで -->
</div>
</body>
</html>
