<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<form action="studentUpdate.do" method="post">
		<fieldset>
			<legend>학생 세부 수정폼</legend>
			<ul>
				<li><label for="번호">번호</label></li>
				<li><input type="number" name="no" value="${studentDTO.no}" readonly="true"></li>
				<li><label for="나이">나이</label></li>
				<li><input type="text" name="age" value="${studentDTO.age}"></li>
				<li><label for="이름">이름</label></li>
				<li><input type="text" name="irum" value="${studentDTO.irum}"></li>
				<li><label for="학번">학번</label></li>
				<li><input type="text" name="hakbun" value="${studentDTO.hak}"></li>
				<li><input type="submit" value="수정하기"></li>
			</ul>
		</fieldset>
	</form>
</body>
</html>