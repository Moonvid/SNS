<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>받은 메세지</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/loginCSS.css"
	type="text/css">
<!-- 구글폰트 -->
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Nanum+Myeongjo"
	rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/views/common/layout_top.jsp"%>
	<%@ include file="/WEB-INF/views/common/layout_right.jsp"%>
	<br>
	<br>
	<br>
	<h1>${messageInfo.recvid }의 확인 안 한 메세지 개수: ${messageInfo.count }개 입니다.</h1>
	<a href="<c:url value="/MessageTo/MessageTo?recvid=${messageInfo.recvid}" />">메세지 확인</a>
</body>
</html>