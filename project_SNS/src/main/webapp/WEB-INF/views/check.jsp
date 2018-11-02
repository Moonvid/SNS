<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width" initial-scale="1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginCSS.css" type="text/css">
<!-- 구글폰트 -->   
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Nanum+Myeongjo" rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/layout_top.jsp"%>
	<%@ include file="/WEB-INF/views/common/layout_right.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<h2>${search}를 검색하였습니다!</h2><br>
		<hr>
		<c:if test=""></c:if>
		<a href="${pageContext.request.contextPath}/friend/friendsPage/${dataVo.userno }">유저 번호 : ${dataVo.userno} <br>유저아이디:{userVO.userId}<br> 유저 이름:${userVO.userName }<br></a>
		<hr>
	<c:forEach var="dataVo" items="${dataVO }">
		<a href="${pageContext.request.contextPath}/friend/friendsPage/${dataVo.userno }">Userno:${dataVo.userno }</a><br>
		Boardcontent:${dataVo.boardcontent }<br>
		Hashtag:${dataVo.hashtag }<br>
		<hr>
	</c:forEach>
</body>
</html>