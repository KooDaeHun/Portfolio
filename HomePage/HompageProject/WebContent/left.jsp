<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<style>
ul#leftmenu {
	position: fixed;
	top: 200px;
	left: 0px;
	z-index: 9999;
	list-style: none;
	margin: 0px;
	padding: 0px;
}

ul#leftmenu li {
	width: 100px;
	margin-bottom: 2px;
}

ul#leftmenu li a {
	background-color: #ccc;
	color: #fff;
	text-decoration: none;
	display: block;
	width: 90px;
	padding: 10px 0 10px 10px;
	-webkit-border-bottom-right-radius: 20px;
	-webkit-border-top-right-radius: 20px;
	margin-left: -1px;
	opacity: 0.6;
}

ul#leftmenu .daegu1 a {
	background: #DD2B2F;
}

ul#leftmenu .daegu2 a {
	background: #FF8102;
}

ul#leftmenu .daegu3 a {
	background: #FFCC00;
}

ul#leftmenu .daegu4 a {
	background: #00CC99;
}

ul#leftmenu .daegu5 a {
	background: #3399CC;
}

ul#leftmenu .daegu6 a {
	background: #9900CC;
}

ul#leftmenu .daegu7 a {
	background: #CC99FF;
}

ul#leftmenu .daegu8 a {
	background: #000000;
}
</style>
<title>대구대학교 jquery</title>
<script src="resources/js/jquery-1.10.2.js"></script>
<link rel="stylesheet" href="css/left.css">
</head>
<body>
	<ul id="leftmenu">
		<li class="daegu1"><a href="index.jsp">메인화면</a></li>
		<li class="daegu2"><a href="index.jsp?page=test1">jquery</a></li>
		<li class="daegu3"><a href="">jquery ui</a></li>
		<li class="daegu4"><a href="">jquery mobile</a></li>
		<li class="daegu5"><a href="">javascript</a></li>
		<li class="daegu6"><a href="">대구대학</a></li>
	</ul>
	<script>
		$(function() {
			$('#leftmenu a').css('marginLeft', '-85px');
			$('#leftmenu li').hover(function() {
				$('a', $(this)).stop().animate({
					'marginLeft' : '-1px'
				}, 300);
			}, function() {
				$('a', $(this)).stop().animate({
					'marginLeft' : '-85px'
				}, 300);
			});
		});
	</script>
</body>
</html>
