<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int no = 0;
	String age = null;
	String irum = null;
	String subject = null;
	
	ResultSet rs = null;
	boolean result = false;
	String name = request.getParameter("irum");
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","skazm12","dkdlxl");
	
	String sql = "SELECT no, age, irum, subject FROM professor WHERE irum ='"+name+"'";
	Statement stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
	while(rs.next()){
		no = rs.getInt("no");
		age = rs.getString("age");
		irum = rs.getString("irum");
		subject = rs.getString("subject");
		result=true;
	}
%>
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
	<%if(result) {%>
	<form action="professorUpdate.do">
		<fieldset>
			<legend>교수 세부 수정폼</legend>
			<ul>
				<li><label for="번호">번호</label></li>
				<li><input type="number" name="no" value="<%=no%>" readonly="true"></li>
				<li><label for="나이">나이</label></li>
				<li><input type="text" name="age" value="<%=age%>"></li>
				<li><label for="이름">이름</label></li>
				<li><input type="text" name="irum" value="<%=irum%>"></li>
				<li><label for="과목">과목</label></li>
				<li><input type="text" name="subject" value="<%=subject%>"></li>
				<li><input type="submit" value="수정하기"></li>
			</ul>
		</fieldset>
	</form>
	<%}else {%>
	<h1>찾을 이름이 없습니다.</h1>
	<a href="index.jsp">메인으로</a>
	<%}%>
</body>
</html>