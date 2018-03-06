<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="pagefile" value="${param.page}"/>
<c:set var="pagefileLen" value="${fn:length(pagefile)}"/>
<c:choose>
	<c:when test="${pagefile==null}">
		<c:set var="pagefile" value="info"/>
	</c:when>
</c:choose>
    
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#bottom {
	position: absolute;
	top: 600px;
	position: fixed;
	background-color: green;
	color: white;
	width: 720px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전체적인 학사관리 프로젝트</title>
</head>
<body>
	
	<jsp:include page="top.jsp" />
	<jsp:include page="left.jsp" />
	<c:choose>
		<c:when test="${pagefileLen > 12}">
			<jsp:include page='${pagefile}'/>
		</c:when>
		<c:otherwise>
			<jsp:include page='${pagefile}.jsp' />
		</c:otherwise>
	</c:choose>
	<div id="bottom">
		<jsp:include page="bottom.jsp" />
	</div>
</body>
</html>
