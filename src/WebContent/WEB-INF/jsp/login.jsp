<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>物知りプラス | ログイン</title>
<link rel="icon" href="img/favicon.ico">
<link rel="stylesheet" href="/buster_moon/css/login.css">
</head>
<body>
<div class="wrapper">
<!-- ヘッダー（ここから） -->
  <h1 id="logo">
    <img src="/buster_moon/img/ロゴ.jpg" width="100" height="100" alt="物知りプラス">物知りプラス
  </h1>
 <h2>ログイン</h2>
 <hr>
 <!-- ヘッダー（ここまで） -->
 <!-- メイン（ここから） -->
  <form id="login_form" method="POST" action="/buster_moon/LoginServlet">
    <table id = "LOGIN">
      <tr>
        <td>
          <label>
          <input type="text" name="MAIL_ADDRESS" id="MAIL_ADDRESS" placeholder="メールアドレス">
          </label>
        </td>
      </tr>
      <tr>
        <td>
          <label>
          <input type="password" name="PASSWORD" id="PASSWORD" placeholder="パスワード">
          </label>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" name="LOGIN" value="ログイン">
          <a href="/buster_moon/New_memberServlet">新規登録</a>
          <span id="error_message"></span>
        </td>
      </tr>
    </table>
   </form>
   <!-- メイン（ここまで） -->
   <!-- フッター -->
<footer>
<div id="footer">
    <p>Copyright 2023 &copy; buster moon</p>
</div>
</footer>
<!-- フッターここまで -->

</div>
</body>
</html>