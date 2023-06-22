<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYプロフィール｜物知りプラス</title>
</head>
<body>

<!-- ヘッダー？ -->
<!-- メニューバーの表示 -->

<ul class="nav">
  <li><a href="/buster_moon/Time_lineServlet"><img src="/buster_moon/img/タイムライン.ico" alt=""></a></li>
  <li><a href="/buster_moon/PostServlet"><img src="/buster_moon/img/投稿.ico" alt=""></a></li>
  <li><a href="/buster_moon/GatherServlet"><img src="/buster_moon/img/募集.ico" alt=""></a></li>
  <li><a href="/buster_moon/SerchServlet"><img src="/buster_moon/img/検索.ico" alt=""></a></li>
  <li><a href="/buster_moon/ProfileServlet"><img src="/buster_moon/img/プロフィール.ico" alt=""></a></li>
  </ul>
<!-- ヘッダー？ここまで -->

<!-- ここからアイコン・名前・編集・ポイント -->
<c:forEach var="profile" items="${profilesList}">
<table>
  <tr>
    <td><img src="${profile.icon}" alt="アイコン"></td>
    <td><input type="text" name="name" value="${profile.name}"></td>
    <td>
      <form action="Profile_editServlet" method="GET">
      <input type="submit" value="編集">
      </form>
     </td>
  </tr>
  <tr>
    <td><input type="text" name="introduction" value="${profile.introduction}"></td>
    <td><input type="text" name="sumpoint" value="${profile.t_point + profile.g_point + profile.c_point}"></td>
  </tr>
</table>
</c:forEach>
<!-- アイコン・名前・編集・ポイントここまで -->

<!--ここから 投稿一覧 -->
<c:forEach var="profile" items="${profilesList}">
  <img src="${profile.icon}" alt="アイコン">
</c:forEach>
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
    </table>
  </c:forEach>
<!-- 投稿一覧ここまで -->


<!-- アイコン・名前・編集 -->

</body>
</html>