<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.daegu.board.BoardDTO"%>
<%@page import="kr.co.daegu.board.BoardDAO"%>
<%
	BoardDAO boardDAO = new BoardDAO();
	BoardDTO boardDTO = new BoardDTO();
	String no = request.getParameter("no");
	boardDTO.setNo(Integer.parseInt(no));
	ArrayList<BoardDTO> boardList = boardDAO.boardContent(boardDTO);
	boardDTO = boardList.get(0);
	boardDAO.boardReadCount(boardDTO);
	boardDAO.boardClose();
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	background-image: url("resources/images/winter1.jpg");
	background-repeat: repeat;
}
.contentForm{
    position: absolute;
    top:186px; left:101px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<fieldset class="contentForm">
		<legend>글수정폼</legend>
		<form action="boardUpdate.boa" method="post">
			<input type="hidden" name="no" value="<%=boardDTO.getNo() %>">
			<ul>
				<li>
					<label for="제목">제목</label> 
					<input type="text" name="title" size="50" value="<%=boardDTO.getTitle() %>">
				</li>
				<li>
					<label for="작성자">작성자</label> <input type="text"
					name="author" size="50" value="<%=boardDTO.getAuthor() %>">
				</li>
				<li>
					<textarea rows="12" cols="80" name="content">
						<%=boardDTO.getContent() %>
        			</textarea>
				</li>
				<li>
					<label for="날짜">날짜</label> <input type="text" name="nal"
					value="<%=boardDTO.getNal() %>">
				</li>
				<li>
					<input type="submit" value="수정하기"> 
					<a href="list.boa">목록으로</a>
				</li>
			</ul>
		</form>
		<form action="boardDelete.boa" method="post">
			<input type="hidden" name="no" value="<%=boardDTO.getNo() %>">
			<input type="image" src="resources/images/delete.jpg" width="50px" id="delete">
		</form>
	</fieldset>
</body>
</html>