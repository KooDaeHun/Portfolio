<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<style type="text/css">
body {
	background-image: url("resources/images/winter1.jpg");
	background-repeat: repeat;
}
#all1 {
	position: absolute;
	top: 200px;
	left: 100px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function openId(myform) {
		url = "idsearch.member?irum=" + myform.name.value + "&email="
				+ myform.email.value;
		window.open(url, "win02", "width=300 height=300");
	}
	function openPw(myform) {
		url = "pwsearch.member?id=" + myform.id.value + "&irum="
				+ myform.name.value + "&email=" + myform.email.value;
		window.open(url, "win03", "width=300 height=300");
	}
</script>
</head>
<body>
	<div id="all1">
		<form action="" method="post" id="idpw">
			<fieldset>
				<legend>id찾기</legend>
				<table id="idpwtable">
					<tr>
						<td>이름</td>
						<td><input type="text" name="name" required="required"
							placeholder="찾으실 이름을 입력해 주세요"></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="email" name="email" required="required"
							placeholder="가입한신 이메일을 적어주세요"></td>
					</tr>
					<tr>
						<td><input type="button" value="ID찾기"
							onClick="openId(this.form)">
				</table>
			</fieldset>
		</form>
		<form action="" method="post" id="idpw">
			<fieldset>
				<legend>pw찾기</legend>
				<table id="idpwtable">
					<tr>
						<td>ID</td>
						<td><input type="text" name="id" required="required"
							placeholder="가입하신 ID를 입력해 주세요"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="name" required="required"
							placeholder="찾으실 이름을 입력해 주세요"></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="email" name="email" required="required"
							placeholder="가입한신 이메일을 적어주세요"></td>
					</tr>
					<tr>
						<td><input type="button" value="PW찾기"
							onClick="openPw(this.form)">
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>
