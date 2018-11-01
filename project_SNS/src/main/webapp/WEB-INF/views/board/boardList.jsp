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

</head>
<body>
	<%@ include file="/WEB-INF/views/common/layout_top.jsp"%>
	<%@ include file="/WEB-INF/views/common/layout_right.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<br>
	<table border="1" class="table">
		<tr>
			<td>#번호</td>
			<td>로그인한 사용자no</td>
			<td>사진</td>
			<td>내용</td>
			<td>해시태그</td>
			<td>작성일</td>
			<td>관리</td>
			<td>신고</td>
		</tr>

		<!-- 		<script>console.log(${loginInfo});</script> -->

		<c:forEach items="${viewData.boardList}" var="board">
			<tr>
				<td><c:out value="${board.boardNo }" /></td>
				<td><c:out value="${loginInfo.userNo }" /></td>
				<td><%-- <c:out value="${board.boardPhotoFile }" /> --%><img src="<c:url value='/uploadfile/${board.boardPhotoFile}' />"></td>
				<td><c:out value="${board.boardContent }" /></td>
				<td><c:out value="${board.hashTag }" /></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd"
						value="${board.boardDate }" /></td>
				<c:if test="${!board.hashTag.isEmpty()}">
					<td>
					<a href="<%=request.getContextPath()%>/board/edit?boardno=<c:out value="${board.boardNo}"/>">수정</a>
					<a href='<%=request.getContextPath()%>/board/delete?boardno=<c:out value="${board.boardNo}" />&userid=<c:out value="${loginInfo.userId }" />'>삭제</a>
					</td>
					<td><a href="report?boardNo=${board.boardNo }&userNo=${loginInfo.userNo}"
						Onclick="javascript:reportNo()">신고하기</a></td>
				</c:if>
			</tr>
		</c:forEach>

	</table>


	<!-- 해당페이지로 가게 넘버링 해주기 -->
	<c:forEach var="num" begin="1" end="${viewData.pageTotalCount}">
		<a
			href='boardList?page=${num}&userid=<c:out value="${loginInfo.userId }" />'>[${num}]</a>
	</c:forEach>


</body>
</html>