<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録｜物知りプラス</title>
<link rel="logo" href="img/logo.png">
<link rel="stylesheet" href="/buster_moon/css/common.css">
<link rel="stylesheet" href="/buster_moon/css/login.css">
</head>
<body>
<div class = "wrapper">

<!-- ヘッダー？ -->
<h1 id="logo">
  <img src="/buster_moon/img/logo.png" width="100" height="100" alt="物知りプラス">物知りプラス
</h1>
<h2>新規会員登録</h2>
<hr>
<!-- ヘッダー？ここまで -->

<!-- 会員登録のときの入力フォーム -->
<form method="POST" action="/buster_moon/New_memberServlet" onsubmit="return cancelsubmit()">
  <table id="NEW_MEMBER">
      <tr class="ID-PASS">
        <td>
          <label>
            <input type="text" name="MAIL_ADDRESS" id="MD" placeholder="メールアドレス"><br>
          </label>
        </td>
      </tr>

     <tr class="ID-PASS">
        <td>
          <label>
            <input type="password" name="PASSWORD" id="PW" placeholder="パスワード"><br>
          </label>
        </td>
      </tr>

      <tr class="ID-PASS">
        <td>
          <label>
            <input type="text" id="PWC" placeholder="パスワード確認"><br>
          </label>
        </td>
      </tr>

      <tr>
        <td colspan="2">
          <input type="submit" name="REGIST" value="登録" >
        </td>
      </tr>
    </table>
</form>
<!-- 会員登録のときの入力フォームここまで -->


<!-- フッター -->
<footer>
<div id="footer">
    <p>Copyright 2023 &copy; buster moon</p>
</div>
</footer>
<!-- フッターここまで -->

<script src="/buster_moon/js/new_member.js"></script>
</div>
</body>
</html>