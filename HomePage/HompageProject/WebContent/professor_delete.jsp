<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/blueberry.css" />
<style type="text/css">
	ul{list-style-type: none;}
	a{text-decoration: none;}
</style>
<script src="resources/js/jquery-1.10.2.js"></script>
<script src="resources/js/jquery.innerfade.js"></script>
<script src='resources/js/jquery.elevatezoom.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<h1>
		<img src="resources/images/header_logo.gif">
	</h1>
	<ul id="news">
		<li><a href="#n1">대구대학교</a></li>
		<li><a href="#n2">jquery</a></li>
		<li><a href="#n3">JAVA</a></li>
		<li><a href="#n4">JSP</a></li>
		<li><a href="#n5">CSS3</a></li>
		<li><a href="#n6">JAVASCRIPT</a></li>
		<li><a href="#n7">ORACLE</a></li>
		<li><a href="#n8">큰뜻을 품어라</a></li>
	</ul>
	<form action="professorDelete.do" method="post">
		<fieldset>
			<legend>교수삭제</legend>
			<ul>
				<li><label for="이름">이름</label> <input type="text" name="irum"
					placeholder="이름입력" required="required"></li>
				<li><input type="image" src="resources/images/delete.jpg" width="50px"></li>
			</ul>
		</fieldset>
	</form>
	<img id="zoom_01" src='resources/images/small/daegu1.png'
		data-zoom-image="resources/images/large/daegu1.jpg" /><br>
	<img id="zoom_10" src="resources/images/small/daegu1.png"
		data-zoom-image="resources/images/large/daegu1.jpg" /><br>
	<img id="zoom_07" src="resources/images/small/daegu1.png"
		data-zoom-image="resources/images/large/daegu1.jpg" />
	<script>
		$(function() {
			$('#news').innerfade({
				animationtype : 'slide',
				speed : 750,
				timeout : 2000,
				type : 'sequence',
				containerheight : '1em'
			});
			$('#zoom_01').elevateZoom({
				zoomType : "inner",
				cursor : "crosshair",
				zoomWindowFadeIn : 500,
				zoomWindowFadeOut : 750
			});
			$("#zoom_10").elevateZoom({
				easing : true
			});
			$("#zoom_07").elevateZoom({
				zoomType : "lens",
				lensShape : "round",
				lensSize : 200
			});
		});
	</script>
</body>
</html>