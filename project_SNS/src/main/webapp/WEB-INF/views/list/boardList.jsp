<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글리스트</title>
<link rel="stylesheet" href="../css/default.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
td, th {
	width: 150px;
	height: 30px;
}

#wrap {
	width: 1500px;
	margin: 0 auto;
}
</style>
<script>
	function deleteBoard(boardNo){

		if (confirm('게시글을 삭제하시겠습니까?')) {
			location.href="delete_board?boardNo="+boardNo;
		}
	}
</script>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<c:if test="${boards.isEmpty()}">
		<h1 id="title">작성된 게시글이 없습니다.</h1>
	</c:if>

	<c:if test="${!boards.isEmpty()}">
		<div id="wrap">
			<h1 id="title" style="text-align: center;">게시글 목록</h1><br>

			<form>
				<table class="table table-hover">
					<tr>
						<th>게시글 번호</th>
						<th>게시자 번호</th>
						<th>내용</th>
						<th>해시태그</th>
						<th>작성시간</th>
						<th>관리</th>
					</tr>
					<c:forEach var="board" items="${boards}">
						<tr>
							<td>${board.boardNo}</td>
							<td>${board.userNo}</td>
							<td>${board.boardContent}</td>
							<td>${board.hashTag}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${board.boardDate}" /></td>
							<td>
							<input type="button" class="btn btn-default" onclick="javascript:location.href='edit_board?boardNo='+${board.boardNo}" value="수정">
							<input type="button" class="btn btn-default" Onclick="deleteBoard(${board.boardNo})" value="삭제">
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</c:if>

</body>
</html>