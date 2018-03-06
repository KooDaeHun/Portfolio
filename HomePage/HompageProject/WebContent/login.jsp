<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	background-image: url("resources/images/winter1.jpg");
	background-repeat: repeat;
}
#reset {
	position: relative;
	top: -1px;
	width: 103px;
	height: 39px;
	background-image: url("resources/images/Reset1.png");
	background-size: 96px;
	background-repeat: no-repeat;
}

#all {
	position: absolute;
	top: 200px;
	left: 100px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div id="all">
		<h1>회원가입</h1>
		<form action="login.member" method="post">
			<fieldset>
				<legend>회원가입</legend>
				<ul>
					<li>
						<label for="아이디">아이디</label>
						<input type="text" name="id" required="required" placeholder="아이디입력">
						<input type="button" value="아이디중복확인" onClick="openId(this.form)">
					</li>
					<li>
						<label for="패스워드">패스워드</label>
						<input type="password" name="pw" required="required" placeholder="패스워드입력">
					</li>
					<li>
						<label for="패스워드">패스워드확인</label>
						<input type="password" name="pwch" required="required" placeholder="패스워드체크">
					</li>
					<li>
						<label for="이름">이름</label>
						<input type="text" name="irum" required="required" placeholder="이름">
					</li>
					<li>
						<label for="닉네임">닉네임</label>
						<input type="text" name="nickName" required="required" placeholder="닉네임입력">
					</li>
					<li>
						<label for="이메일">이메일</label>
						<input type="text" name="email" required="required" placeholder="이메일입력">
					</li>
					<li>
						<label for="정보수신허용">정보수신허용</label>
						<select name="emailcheck">
							<option value="yes">예</option>
							<option value="no">아니오</option>
						</select>
					</li>
					<li>
						<label for="sms수신허용">sms수신허용</label>
						<select name="smscheck">
							<option value="yes">예</option>
							<option value="no">아니오</option>
						</select>
					</li>
					<li>
						<input type="image" src="resources/images/login.png" width="100px">
						<input type="reset" value=" " id="reset">
					</li>
				</ul>
			</fieldset>
		</form>
	</div>
	<script type="text/javascript">
		function openId(myform) {
			url = "idcheck.member?id="+myform.id.value;
			window.open(url, "win01", "width=300 height=300");
		}
	</script>
</body>
</html>