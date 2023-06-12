<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>物知りプラス | ログイン</title>
<link rel="logo" href="img/logo.png">
<link rel="stylesheet" href="/buster_moon/css/common.css">
<link rel="stylesheet" href="/buster_moon/css/login.css">
</head>
<body>
<div class="wrapper">
<!-- ヘッダー（ここから） -->
  <h1 id="logo">
    <img src="/buster_moon/img/logo.png" width="100" height="100" alt="物知りプラス">物知りプラス
  </h1>
 <!-- ヘッダー（ここまで） -->
 <!-- メイン（ここから） -->
 <h2>ログイン</h2>
  <form id="login_form" method="POST" action="/buster_moon/LoginServlet">
    <table>
      <tr>
        <td>
          <label>ID<br>
          <input type="text" name="ID" id="ID" placeholder="ID(メールアドレス)">
          </label>
        </td>
      </tr>
      <tr>
        <td>
          <label>パスワード<br>
          <input type="password" name="PW" id="PW" placeholder="パスワード">
          </label>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" name="LOGIN" value="ログイン">
          <input type="submit" name="NEW_MEMBER" value="新規登録">
          <span id="error_message"></span>
        </td>
      </tr>
    </table>
   </form>
   <!-- メイン（ここまで） -->
   </div>
</body>
</html>