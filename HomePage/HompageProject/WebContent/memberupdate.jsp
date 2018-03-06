<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
ul{
	list-style:none;
}
a{
	text-decoration:none;
	color:red;
}
body {
	background-image: url("resources/images/winter1.jpg");
	background-repeat: repeat;
}
#memberview{
    position: absolute;
    top:250px; left:100px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div id="memberview">
		<form action="update.member" method="post">
			<fieldset>
				<legend>회원상세정보</legend>
				<ul>
					<li>
						<label for="아이디">아이디</label> 
						<input type="text" name="id" required="required" value="${memeberDTO.id}" readonly="readonly">
					</li>
					<li>
						<label for="패스워드">패스워드</label> 
						<input type="password" name="pw" required="required" value="${memberDTO.pw }">
					</li>
					<li>
						<label for="패스워드확인">패스워드확인</label> 
						<input type="password" name="pwch" required="required" value="${memberDTO.pwch}">
					</li>
					<li>
						<label for="이름">이름</label> 
						<input type="text" name="irum" required="required" value="${memberDTO.irum}">
					</li>
					<li>
						<label for="닉네임">닉네임</label> 
						<input type="text" name="nickname" required="required" value="${memberDTO.nickname}">
					</li>
					<li>
						<label for="이메일">이메일</label> 
						<input type="email" name="email" required="required" value="${memberDTO.email}">
					</li>
					<li>
						<input type="submit" value="멤버수정">
					</li>
					<li>
						<label for="회원탈퇴"></label> 
						<a href='leave.member'>회원탈퇴</a>
					</li>
				</ul>
			</fieldset>
		</form>
	</div>
</body>
</html>