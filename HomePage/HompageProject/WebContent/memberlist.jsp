<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#memberlist{
 position: absolute;
 top:200px; left:50px;  
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div id="memberlist">
		<h1>회원목록</h1>
		<table border="1" cellspacing="0" cellpadding="0">
			<tr>
				<td>회원ID</td>
				<td>회원이름</td>
			</tr>
			
			<c:forEach var="memberlist" items="${memberList}">
				<td>
					${memberlist.id}
				</td>
				<td>
					${memberlist.irum}
				</td>
			</tr>
			</c:forEach>
			
		</table>
	</div>
</body>
</html>