<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-image: url("resources/images/winter1.jpg");
	background-repeat: repeat;
}
#all {
	position: absolute;
	top: 237px;
	left: 107px;
}
.writeAndSearch{
	position:absolute;
	top:467px;
	left:135px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<table id="all" cellspacing="0" cellpadding="0" border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>내용</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${list}" var="board">
			<tr>
				<td><a href="getlist.boa?no=${board.no}">${board.no }</a></td>
				<td>${board.title }</td>
				<td>${board.author }</td>
				<td>${board.content }</td>
				<td>${board.nal }</td>
				<td>${board.readcount }</td>
				<td><a href="boardDelete.boa?no=${board.no }">삭제</a></td>
			</tr>
			<div class="writeAndSearch">
				<a href="index.jsp?page=boardwrite">글쓰기</a> 
				<a href="list.boa">목록으로</a>
				<form action="boardSearch.boa">
					<br> 
					<input type="text" name="title" required="required" placeholder="제목입력"> 
					<input type="image" src="resources/images/search.jpg" width="20px">
				</form>
			</div>
		</c:forEach>
		<tr>
			<td colspan="5">
			<jsp:include page="page.jsp" flush="true" /></td>
		</tr>
	</table>
</body>
</html>