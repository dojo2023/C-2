<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>物知りプラス</title>
<link rel="stylesheet" href="/buster_moon/css/search.css">
</head>
<body>
<h1>検索結果</h1>

<ul class="nav">
  <li><a href="/buster_moon/Time_lineServlet"><img src="/buster_moon/img/time_line.png" alt=""></a></li>
  <li><a href="/buster_moon/PostServlet"><img src="/buster_moon/img/search.png" alt=""></a></li>
  <li><a href="/buster_moon/GatherServlet"><img src="/buster_moon/img/gather.png" alt=""></a></li>
  <li><a href="/buster_moon/SerchServlet"><img src="/buster_moon/img/post.png" alt=""></a></li>
  <li><a href="/buster_moon/ProfileServlet"><img src="/buster_moon/img/profile.png" alt=""></a></li>
  </ul>
<div class="table">
  <table id="list">
    <tr>
      <td><input type="text" style="width: 200px; height: 25px;" name="ID" placeholder="キーワードを入力してください"></td>
      <td><input type="submit" name="LOGIN" value="検索" class="button1"></td>
    </tr>
    <tr>
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
      <select name="ja">
      <option value="genre">ジャンル</option>
      <option value="genre">中華</option>
      <option value="genre">ラーメン屋</option>
      <option value="genre">イタリアン</option>
      <option value="genre">ハンバーガー</option>
      </select>
      </td>
  </tr>
  </table>
  </div>
</body>
</html>