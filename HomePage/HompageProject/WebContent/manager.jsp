<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="resources/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="resources/js/jquery.innerfade.js"></script>
<style type="text/css">
 ul{list-style-type: none;}
 .daegu{width:500px;}
 a{text-decoration: none;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<a href="#n8">큰뜻을 품어라</a>
</li>
</ul>
<form action="managerInsert.do" method="post">
<fieldset>
<legend>관리자등록</legend>
<ul>
    <li><input type="hidden" name="bunho" value="0"></li>
    <li><label for="나이">나이</label>
    <input type="number" name="age" placeholder="나이입력" required="required">
    </li>
    <li><label for="이름">이름</label>
    <input type="text" name="irum" placeholder="이름입력" required="required">
    </li>
    <li><label for="부서">부서</label>
    <input type="text" name="part" placeholder="부서입력" required="required">
    </li>
    <li><input type="submit" value="관리자등록"></li>  
</ul>
</fieldset>
</form>
<ul id="portfolio">
<li>
<img src="resources/images/daegu1.jpg" title="대구대학교" class="daegu"/>
</li>
<li>
<img src="resources/images/daegu2.jpg" title="대구대학교" class="daegu"/>
</li>
<li>
<img src="resources/images/daegu3.jpg" title="대구대학교" class="daegu"/>
</li>
</ul>

<script>
 $(function(){
 $('#portfolio').innerfade({
speed: 'slow',
timeout: 4000,
type: 'sequence',
containerheight: '220px'
}); 
 $('#news').innerfade({
animationtype: 'slide',
speed: 750,
timeout: 2000,
type: 'sequence',
containerheight: '1em'
});
 });
</script>
</body>
</html>