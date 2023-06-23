<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録｜物知りプラス</title>
<link rel="logo" href="img/logo.png">
<link rel="stylesheet" href="/buster_moon/css/common.css">
</head>
<body>

<!-- ヘッダー？ -->
<h1>物知りプラス</h1><br>
<h2>新規会員登録</h2>
<hr>
<!-- ヘッダー？ここまで -->

<!-- 会員登録のときの入力フォーム -->
<form method="POST" action="/buster_moon/New_memberServlet" onsubmit="return cancelsubmit()">
  <table id="NEW_MEMBER">
      <tr class="ID-PASS">
        <td>
          <label><b>MAIL ADDRESS</b>
            <input type="text" name="MAIL_ADDRESS" id="MD"><br>
          </label>
        </td>
      </tr>

     <tr class="ID-PASS">
        <td>
          <label><b>PASSWORD</b>
            <input type="password" name="PASSWORD" id="PW"><br>
          </label>
        </td>
      </tr>

      <tr class="ID-PASS">
        <td>
          <label><b>PASSWORD確認</b>
            <input type="text" id="PWC"><br>
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
<div id="footer">
    <p>Copyright 2023 &copy; buster moon</p>
</div>
<!-- フッターここまで -->

<script src="/buster_moon/js/new_member.js"></script>
</body>
</html>