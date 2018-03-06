<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	background-image: url("resources/images/winter1.jpg");
	background-repeat: repeat;
}
#board1 {
	position: absolute;
	top: 200px;
	left: 100px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.id==null}">
			<script>alert("로그인하세요!");
			location.href="index.jsp?page=loginform";
			</script>
		</c:when>
	</c:choose>   
	<div id="board1">
		<br>
		대구게시판
		<table border="1" cellspacing="0" cellpadding="0">
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>사진</td>
				<td>작성자</td>
				<td>날짜</td>
				<td>조회수</td>
			</tr>
			<c:forEach var="board" items="${boardList}">
				<tr>
					<td>${board.no}</td>
					<td><a href='boardContent.jsp?no=${board.no}'>${board.title}</a></td>
					<td><img src='resources/images/${board.icon}' width='50px'></td>
					<td>${board.author}</td>
					<td>${board.nal}</td>
					<td>${board.readcount}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="boardwrite.jsp">글쓰기</a> 
		<a href="boardList.boa">목록으로</a>
		
		<form action="boardSearch.boa">
		<br>
			<input type="text" name="title" required="required" placeholder="제목입력">
			<input type="image" src="resources/images/search.jpg" width="20px"> 
		</form>

	</div>
</body>
</html>
