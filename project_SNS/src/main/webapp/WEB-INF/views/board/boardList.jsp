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
	function reportNo(boardNo) {
		if (confirm('신고하시겠습니까?')) {
			location.href="report?boardNo="+boardNo+"&userNo=<c:out value="${loginInfo.userNo}" />";
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
				<div>
					#번호:
					<c:out value="${board.boardNo }" />
					로그인 userno:
					<c:out value="${loginInfo.userNo }" />
				</div>
				<div>
				<c:set var="cont" value="신고접수된 글입니다." />
				<c:set var="boardcont" value="${board.boardContent}"/>
					<c:if test="${boardcont ne cont}">
					사진: <img
							src="<c:url value='/uploadfile/${board.boardPhotoFile}' />">
						<%-- <c:out value="${board.boardPhotoFile }" /> --%>
					</c:if>
				</div>
				<div>
					내용:
					<c:out value="${board.boardContent }" />
				</div>
				<div>
					해시태그:
					<c:out value="${board.hashTag }" />
				</div>
				<div>
					등록일:
					<fmt:formatDate pattern="yyyy-MM-dd" value="${board.boardDate }" />
				</div>
				<div>
					<c:if test="${boardcont ne cont}">
						<a
							href="<%=request.getContextPath()%>/board/edit?boardno=<c:out value="${board.boardNo}"/>">수정</a>
						<a
							href='<%=request.getContextPath()%>/board/delete?boardno=<c:out value="${board.boardNo}" />&userid=<c:out value="${loginInfo.userId }" />'>삭제</a>
					</c:if>
				</div>
				<div>
					<c:if test="${boardcont ne cont}">
						<input type="button" class="btn btn-default"
							Onclick="reportNo(${board.boardNo})" value="신고하기">
					</c:if>
				</div>
				<span id="isGood_${board.boardNo}">좋아요 : <c:if
						test="${isGoodList.isEmpty()}">0</c:if> <c:if
						test="${!isGoodList.isEmpty() }">
						<c:forEach var="isGood" items="${isGoodList}">
							<c:if test="${board.boardNo eq isGood.boardNo}">
							${isGood.isGoodCnt}
						</c:if>
						</c:forEach>
					</c:if>
				</span> <span> <c:if test="${boardcont ne cont}">
						<button class="isGoodBnt" value="${board.boardNo}">좋아요!</button>
					</c:if>
				</span>
			</div>
		</c:forEach>
	</section>

	<!-- 해당페이지로 가게 넘버링 해주기 -->
	<c:forEach var="num" begin="1" end="${viewData.pageTotalCount}">
		<a
			href='boardList?page=${num}&userid=<c:out value="${loginInfo.userId }" />'>[${num}]</a>
	</c:forEach>



	<script>
	$('.isGoodBnt').click(function() {
		var boardNo = $(this).val();
		var userNo = ${loginInfo.userNo}
		 $.ajax({
		 	type: "POST",
			url: "isGoodBoard",
			data: {"boardNo":boardNo, "userNo":userNo},
		 	success: function(data){
		 		$('#isGood_'+boardNo).empty(),
				$('#isGood_'+boardNo).append("좋아요 : "+data);
		 	}                                                             
		});
	});
</script>
</body>
</html>