<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/blueberry.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="resources/js/jquery-1.10.2.js"></script>
<script src="resources/js/jquery.blueberry.js"></script>
<script src="resources/js/jquery.innerfade.js"></script>

<style>
	ul{list-style-type: none;}
	a{text-decoration: none;}
</style>
<title>교수검색</title>
</head>
<body>
	<h1><img src="resources/images/header_logo.gif"></h1>
	<ul id="news">
		<li>
			<a href="#n1">대구대학교</a>
		</li>
		<li>
			<a href="#n2">jquery</a>
		</li>
		<li>
			<a href="#n3">JAVA</a>
		</li>
		<li>
			<a href="#n4">JSP</a>
		</li>
		<li>
			<a href="#n5">CSS3</a>
		</li>
		<li>
			<a href="#n6">JAVASCRIPT</a>
		</li>
		<li>
			<a href="#n7">ORACLE</a>
		</li>
		<li>
			<a href="#n8">큰 뜻을 품어라</a>
		</li>
	</ul>
	<form action="professorSearch.do" method="post">
		<fieldset>
			<legend>교수검색</legend>
			<ul>
				<li><label for="이름">이름</label> <input type="text" name="irum"
					placeholder="이름입력" required></li>
				<li><input type="image" src="resources/images/search.jpg"
					width="50px"></li>
			</ul>
		</fieldset>
	</form>
	<div class="blueberry">
		<ul class="slides">
			<li><img src="resources/images/daegu1.jpg"/></li>
			<li><img src="resources/images/daegu2.jpg"/></li>
			<li><img src="resources/images/daegu3.jpg"/></li>
		</ul>
	</div>
	<script>
		$(function(){
			$(window).load(function(){
				$('.blueberry').blueberry();
			});
			$('#news').innerfade({
				animationtype:'slide',
				speed:750,
				timeout:2000,
				type:'sequence',
				containerheight:'1em'
			});
		});
	</script>
</body>
</html>