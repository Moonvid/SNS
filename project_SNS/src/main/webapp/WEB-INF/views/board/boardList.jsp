<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function reportNo() {

		if (confirm('신고하시겠습니까?')) {
			return true;
		} else {
			return false;
		}
	}
</script>
<style>
#boardSection {
	width: 60%;
}

.userBoard {
	padding: 10px;
	margin: 10px;
	border: 1px solid;
	
}

</style>

</head>
<body>
	<%@ include file="/WEB-INF/views/common/layout_top.jsp"%>
	<%@ include file="/WEB-INF/views/common/layout_right.jsp"%>
	<section id="boardSection">
	<c:forEach items="${viewData.boardList}" var="board">
		<div class="userBoard">
			<div>#번호: <c:out value="${board.boardNo }" /> 로그인 userno: <c:out value="${loginInfo.userNo }" /></div>
			<div>사진: <img src="<c:url value='/uploadfile/${board.boardPhotoFile}' />"><%-- <c:out value="${board.boardPhotoFile }" /> --%></div>
			<div>내용: <c:out value="${board.boardContent }" /></div>
			<div>해시태그: <c:out value="${board.hashTag }" /></div>
			<div>등록일: <fmt:formatDate pattern="yyyy-MM-dd" value="${board.boardDate }" /></div>
			<div><a href="<%=request.getContextPath()%>/board/edit?boardno=<c:out value="${board.boardNo}"/>">수정</a>
				<a href='<%=request.getContextPath()%>/board/delete?boardno=<c:out value="${board.boardNo}" />&userid=<c:out value="${loginInfo.userId }" />'>삭제</a></div>
			<div><a href="report?boardNo=${board.boardNo }&userNo=${loginInfo.userNo}" Onclick="javascript:reportNo()">신고하기</a></div>
		</div>
	</c:forEach>
	</section>

	<!-- 해당페이지로 가게 넘버링 해주기 -->
	<c:forEach var="num" begin="1" end="${viewData.pageTotalCount}">
		<a
			href='boardList?page=${num}&userid=<c:out value="${loginInfo.userId }" />'>[${num}]</a>
	</c:forEach>


</body>
</html>