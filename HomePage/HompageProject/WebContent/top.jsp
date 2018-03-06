<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>대구대학교</title>
<script src="resources/js/jquery-1.10.2.js"></script>
<style>
#ALL {
	width: 700px;
	margin: 30px auto;
	background: #FFF;
	padding: 20px;
	position: fixed;
	background-color:rgba(255,255,255,0);
	float:left;
}

.topmenu {
	height: 45px;
	background: orange;
}

.topmenu ul {
	list-style: none;
	padding: 0;
	margin: 0;
}

.topmenu ul li {
	float: left;
	overflow: hidden;
	text-align: center;
	line-height: 45px;
}

.topmenu ul li a {
	position: relative;
	display: block;
	width: 110px;
	height: 45px;
	color: #FFF;
	font-family: Arial;
	font-size: 11px;
	font-weight: bold;
	letter-spacing: 1px;
	text-transform: uppercase;
	text-decoration: none;
	cursor: pointer;
}

.topmenu ul li a span {
	position: absolute;
	top: 0px;
	left: 0;
	width: 110px;
}

.topmenu ul li a span.over {
	top: -45px;
}

.topmenu ul li a span.over {
	background: yellow;
	color: green;
}

.loginDiv{
	width:700px;
	float:right;
}
#loginImg{
	width:50px;
	height:20px;
}
.A{
	float:right;
}
#logout{
	width:50px;
	height:20px;
}
.blank{
	display:inline;
	width:61px; 
	height:28px; 
	float:left;
}
</style>
</head>
<body>
	<div id="ALL">
		<div class="logoDiv">
			<a href="index.jsp"><img src="resources/images/header_logo.gif"></a>
			<div class="A">
				<a href="index.jsp?page=login" id="loginA"><img id="loginImg" src="resources/images/login.png"></a>
				<a href="index.jsp?page=idpwsearch" id="loginA"><img id="loginImg" src="resources/images/search_idpw.png"></a>
				<a href="index.jsp?page=loginform" id="loginA"><img id="loginImg" src="resources/images/login2.png"></a>
				<form class="A" action="logout.member">
					<input id="logout" type="image" src="resources/images/logout.png">
				</form>
				<br>
				<c:choose>
					<c:when test="${sessionScope.id!=null}">
							<div class="blank"></div>${sessionScope.id}님 환영합니다.
							<a href="updateconfirm.member">
								<img width="20px" height="20px" src="resources/images/mypage.png">
							</a>
					</c:when>
				</c:choose>

			</div>
		</div>
		<div class="topmenu">
			<ul>
				<li><a href="index.jsp">메인화면</a></li>
				<li><a href="index.jsp?page=test1">jquery</a></li>
				<li><a href="#">jquery ui</a></li>
				<li><a href="#">jquery mobile</a></li>
				<li><a href="#">javascript</a></li>
				<li><a href="list.boa">게시판</a></li>
			</ul>
		</div>
	</div>
	<script>
		$(function() {
/* 			<!-- <li><a href="#"><span class="out">학사소개</span></a></li> -->
			<!-- <li><a href="#"><span class="out">jquery</span></a></li> -->
			<!-- <li><a href="#"><span class="out">jquery ui</span></a></li> -->
			<!-- <li><a href="#"><span class="out">jquery mobile</span></a></li> -->
			<!-- <li><a href="#"><span class="out">javascript</span></a></li> -->
			<!-- <li><a href="#"><span class="out">대구대학교</span></a></li> -->
			
			<!-- <li><a href="#"><span class="over">학사소개</span></a></li> -->
			<!-- <li><a href="#"><span class="over">jquery</span></a></li> -->
			<!-- <li><a href="#"><span class="over">jquery ui</span></a></li> -->
			<!-- <li><a href="#"><span class="over">jquery mobile</span></a></li> -->
			<!-- <li><a href="#"><span class="over">javascript</span></a></li> -->
			<!-- <li><a href="#"><span class="over">대구대학교</span></a></li> --> */

			$(".topmenu li a").wrapInner('<span class="out"></span>');
			$(".topmenu li a").each(
				function() {
					$('<span class="over">' + $(this).text() + '</span>').appendTo(this);
				}
			);
			/* 		  호버됐을 때       마우스 뗐을 때 */
			/* hover(function, function) */
			$(".topmenu li a").hover(
				function() {
					$(".out", this).stop().animate({'top' : '45px'}, 200);
					$(".over", this).stop().animate({'top' : '0px'}, 200);
				}, 
				function() {
					$(".out", this).stop().animate({'top' : '0px'}, 200);
					$(".over", this).stop().animate({'top' : '-45px'}, 200);
				}
			);
		});
	</script>
</body>
</html>
