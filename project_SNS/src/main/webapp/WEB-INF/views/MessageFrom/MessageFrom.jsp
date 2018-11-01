<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메세지 보내기</title>
<meta name="viewport" content="width=device-width" initial-scale="1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/loginCSS.css"
	type="text/css">
<!-- 구글폰트 -->
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Nanum+Myeongjo" rel="stylesheet">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/layout_top.jsp"%>
<%@ include file="/WEB-INF/views/common/layout_right.jsp"%>

	<h1>보낼 메세지 입력</h1>
	<form method="post">
		메세지 보내는 사람 : <input type="text" name="sendId" value="${messageWriteInfo.sendid }" readonly="readonly"/><br>
		 메세지 받는 사람 :<input type="text" name="recvId" value="${messageWriteInfo.recvid }" readonly="readonly"/><br> 
		 메세지 내용 :<textarea name="messagecont" cols="30" rows="10"></textarea>
		<input type="submit" value="보내기" />
	</form>
</body>
</html>