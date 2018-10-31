<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>header</title>
<style>
#right {
	width: 400px;
	height: 800px;
	float: right;
	border: 1px solid;
	position: relative;
}

#icon {
	position: absolute;
}

#icon a {
	text-decoration: none;
}

#icon li {
	list-style-type: none;
	float: left;
	padding: 0 15px;
	margin: 0 auto;
}

#setting img {
	width: 30px;
	float: right;
	margin-right: 30px;
}

#profile {
	position: relative;
	height: 700px;
	margin-top: 90px;
}

#img {
	background-image: url('${pageContext.request.contextPath}/img/logo.jpg');
	background-size: 100%;
	width: 200px;
	height: 200px;
	border: 1px solid #333333;
	border-radius: 70%;
	margin: 0 auto;
	position: relative;
}

#info {
	margin: 0 auto;
	width: 200px;
	text-align: center;
	margin-top: 50px;
}<
</style>
</head>

<body>
	<div id="right">
		<div id="icon">
			<ul>
				<li><a href="#">글쓰기</a></li>
				<li><a href="#">친구목록</a></li>
				<li><a href="#">쪽지함</a></li>
				<li><a href="#">프로필</a></li>
			</ul>
		</div>
		<div id="profile">
			<div id="setting">
				<img src="${pageContext.request.contextPath}/img/setting.png">
			</div>
			<div id="img"></div>
			<div id="info">
				<p>ID: solsol</p>
				<p>닉네임:또리짱</p>
				<p>
					내소개: <br> 웹개발스프링 프로젝트 준비중입니다 ^_^
				</p>
			</div>
		</div>
	</div>
</body>
</html>
