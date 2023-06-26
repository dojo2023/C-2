/**
 *
 */

 'use strict';

 //パスワードの確認


function cancelsubmit() {
	var pw = document.getElementById("PW").value;
	var pwc = document.getElementById("PWC").value;

	if (document.getElementById("MD").value == ""){
		alert("メールアドレスが空欄です。");
		return false;
	} else if (pw == "") {
		alert("パスワードが空欄です。");
		return false;
	} else if(pw != pwc) {
		alert("パスワードが異なっています。");
		return false;
	}
}
