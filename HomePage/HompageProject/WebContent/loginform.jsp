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
#loginform{ position: absolute;
     top:220px; left:100px;
     }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div id="loginform">
		<form action="loginform.member" method="post">
			<fieldset>
				<legend>로그인폼</legend>
				<ul>
					<li>
						<label for="아이디">아이디</label>
						<input type="text" name="id" required="required" placeholder="아이디입력">
					</li>
					<li>
						<label for="패스워드">패스워드</label>
						<input type="password" name="pw" required="required" placeholder="패스워드입력">
					</li>
					<li>
						<input type="submit" value="로그인">
					</li>
				</ul>
			</fieldset>
		</form>
	</div>
</body>
</html>