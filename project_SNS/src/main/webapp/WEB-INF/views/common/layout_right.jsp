<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/default.css">
<style type="text/css">
body {
	background-color: #E7E7E8;
}

.sidebar {
	width: 380px;
	height:650px;
	float: right;
	margin-right: 10px;
	background-color: white;
	border-radius: 10px;
}

.icon a {
	text-decoration: none;
}

.icon li {
	list-style-type: none;
	float: left;
	margin-left: 13px;
	margin-top: 5px;
}

.menu>button {
	margin: 1px;
	border: none;
}

.edit>img {
	width: 25px;
	height: 25px;
	float: right;
	margin-right: 30px;
	margin-top: 30px;
}

.myphoto {
	background-image:
		url('<%=request.getContextPath()%>/uploadfile/userphoto/${loginInfo.userProfilePhoto}');
	background-size: 100%;
	width: 200px;
	height: 200px;
	border: 1px solid #333333;
	border-radius: 70%;
	margin: 0 auto;
	margin-top: 60px;
	position: relative;
}

#info {
	margin: 0 auto;
	width: 200px;
	text-align: center;
	margin-top: 50px;
}
</style>
<!-- 구글폰트 -->
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Nanum+Myeongjo"
	rel="stylesheet">

</head>
 
<body>
	<div class="sidebar">
		<div class="icon">
			<ul class="nav nav-tabs">
				<li><a href="write">글쓰기</a></li>
				<li><a href="${pageContext.request.contextPath}/friendsList">친구목록</a></li>
				<li><a href="${pageContext.request.contextPath}/MessageTo/WhoRecv?recvid=${loginInfo.userName}">쪽지함</a></li>
				<li><a href="#">프로필</a></li>
			</ul>
		</div>

		<div class="myphoto"></div>

		<div id="info">
			<p>ID : ${loginInfo.userId }</p>
			<p>이름 : ${loginInfo.userName}</p>
			<p>내 소개 : ${loginInfo.userIntro}</p>
		</div>
	</div>
	
</body>