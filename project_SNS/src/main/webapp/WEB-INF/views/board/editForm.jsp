<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post">
	<!-- page 값 전달용 -->
	<input type="hidden" name="page" value=1>

	<!-- 사용자 관련 내용은 hidden으로 바꿔야함 -->
	사용자no: <input type="text" name="userNo" value='<c:out value="${loginInfo.userNo }" />' readonly="readonly"><br>
	사용자id: <input type="text" name="userId" value='<c:out value="${loginInfo.userId }" />' readonly="readonly"><br>
	게시글no: <input type="text" name="boardNo" value='<c:out value="${board.boardNo }" />' readonly="readonly"><br>
	내용: <textarea name="boardContent"><c:out value="${board.boardContent }" /></textarea><br>
	해시태그: <input type="text" name="hashTag" value='<c:out value="${board.hashTag }" />' ><br>
	<button type="submit">수정하기</button>
</form>

</body>
</html>