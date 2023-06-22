<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロフィール編集 | 物知りプラス</title>
</head>
<body>
  <!-- ここからアイコン・名前・自己紹介・パスワードの編集 -->
  <form id="edit_form" method="POST" action="/buster_moon/Profile_editServlet">
  <c:forEach var="profile" items="${profilesList}">
    <table>
      <tr>
        <td>
        <img src="${profile.icon}" alt="アイコン">
        <input type="file" name="photo" accept="image/*">
        </td>
      </tr>
      <tr>
        <td><input type="text" name="name" value="${profile.name}"></td>
      </tr>
      <tr>
        <td><input type="text" name="introduction" value="${profile.introduction}"></td>
      </tr>
      <tr>
        <td><input type="text" name="password" value="現在のパスワードを入力"></td>
      </tr>
      <tr>
        <td><input type="text" name="new_password" value="新しいパスワードを入力"></td>
      </tr>
      <tr>
        <td><input type="text" name="new_password" value="新しいパスワード（再入力）"></td>
      </tr>
    </table>
  </c:forEach>
  <!-- アイコン・名前・自己紹介・パスワードの編集ここまで -->

  <!-- ここから自分の投稿の削除・変更完了・キャンセル -->
  <c:forEach var="post" items="${postsList}">
    <table>
      <tr>
        <td><input type="text" name="restaurant" value="${post.restaurant}"></td>
      </tr>
      <tr>
        <td><input type="text" name="genre" value="${post.genre}"></td>
      </tr>
      <tr>
        <td><input type="text" name="walk" value="${post.walk}"></td>
      </tr>
      <tr>
        <td><input type="text" name="serve" value="${post.serve}"></td>
      </tr>
      <tr>
        <td><input type="text" name="price" value="${post.price}"></td>
        <td><input type="text" name="text" value="${post.text}"></td>
        <td><img src="${post.photo}" alt="料理の写真"></td>
      </tr>
      <tr>
        <td>
          <input type="submit" name="completion" value="変更を完了する" onclick="return confirm('変更内容を保存しますか？')">
        </td>
        <td>
         <input type="submit" value="キャンセル">
        </td>
      </tr>
    </table>
  </c:forEach>
  </form>
  <!-- 自分の投稿削除・変更完了・キャンセルここまで -->

</body>
</html>