<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
	<c:when test="${sessionScope.id==null}">
	<script>alert("회원등록하세요");
		location.href="index.jsp?page=loginform";
	</script>	
	</c:when>
</c:choose>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	background-image: url("resources/images/winter1.jpg");
	background-repeat: repeat;
}
div#board{
  position: absolute;
  top:184px; left:99px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div id="board">
		<form action="boardWrite.boa" method="post">
			<input type="hidden" name="icon" value="header_logo.gif">
			<fieldset>
				<legend>글쓰기폼</legend>
				<ul>
					<li>
						<label for="제목">제목</label> 
						<input type="text" name="title" size="50" placeholder="제목을 입력하세요" required="required"></li>
					<li>
						<label for="작성자">작성자</label> 
						<input type="text" name="author" size="50" placeholder="작성자입력" required="required">
					</li>
					<br>
					<li> 
						<textarea rows="12" cols="80"name="content" placeholder="내용을 입력하세요" required="required">
						</textarea>
					</li>
					<li>
						<label for="날짜">날짜</label> <input type="date" name="nal">
					</li>
					<li>
						<input type="image" src="resources/images/pen.png" width="30px">
					</li>
				</ul>
			</fieldset>
		</form>
	</div>
</body>
</html>