<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
</head>
<body>
<!-- 혜연언니바보ㅋㅋㅋㅋ -->
	<%@ include file="/WEB-INF/views/common/layout_top.jsp"%>
	<%@ include file="/WEB-INF/views/common/layout_right.jsp"%>
	
	<h1> 댓글 </h1>
	<form method="post">
		아이디: <input type="text" name="userId" value="${loginInfo.userId }" readonly/> <br />
		<input type="hidden" name="userNo" value="${loginInfo.userNo}">
		댓글:<textarea name="commentCont" cols="30" rows="3" ></textarea> <br />
		<input type="submit" value="댓글달기" />
	</form>
</body>
</html>