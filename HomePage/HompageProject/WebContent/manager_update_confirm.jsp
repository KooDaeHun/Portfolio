<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
ul{list-style-type: none;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<form action="managerUpdate.do" method="post">
		<fieldset>
			<legend>관리자 세부 수정폼</legend>
			<ul>
				<li><label for="번호">번호</label></li>
				<li><input type="number" name="no" value="${managerDTO.no}" readonly="true"></li>
				<li><label for="나이">나이</label></li>
				<li><input type="number" name="age" value="${managerDTO.age}"></li>
				<li><label for="이름">이름</label></li>
				<li><input type="text" name="irum" value="${managerDTO.irum}"></li>
				<li><label for="부서">부서</label></li>
				<li><input type="text" name="part" value="${managerDTO.part}"></li>
				<li><input type="submit" value="수정하기"></li>
			</ul>
		</fieldset>
	</form>
	<a href="index.jsp">메인으로</a>
</body>
</html>