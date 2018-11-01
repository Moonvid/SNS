<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.team.springsns.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 구글폰트 -->
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Nanum+Myeongjo"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">
#logo_fin{
	height: 50px;
	padding-right: 30px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header active">
				<a href="<c:url value='/board/boardList?userId=${loginInfo.userId }' />"><img
					src="${pageContext.request.contextPath}/images/logo_fin2.png"
					id = "logo_fin"></a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value='/notice/list' />">공지사항</a></li>
				<li><a href="#">마이페이지</a></li>
				<c:choose>
					<c:when test="${empty loginInfo}">
						<li><a href="<c:url value='/loginForm' />">로그인</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="<c:url value='/team/logout' />">로그아웃</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
			<form class="navbar-form navbar-center" action="${pageContext.request.contextPath}/check">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search" name="search">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>
		</div>
	</nav>

</body>
</html>