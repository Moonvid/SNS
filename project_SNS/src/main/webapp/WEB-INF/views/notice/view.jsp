<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
td {
	width: 200px;
	text-align: center;
}

#title {
	margin-left: 20px;
	margin-bottom: 10px;
}

#wrap {
	width: 1500px;
	margin: 0 auto;
}
</style>
<script>
	function deleteNo(noticeNo) {

		if (confirm('삭제하시겠습니까?')) {
			location.href="delete?noticeNo=" + noticeNo;
		} 
	}
</script>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/layout_top.jsp"%>

	<h1 id="title" style="text-align: center;">게시글 보기</h1><br>
	<div id="wrap">
		<form method="get" enctype="multipart/form-data">
			<table class="table table-bordered">
				<tr>
					<c:set var="i" value="${viewData}" />
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성날짜</th>
				</tr>
				<tr>
					<td>${i.noticeNo}</td>
					<td>${i.noticeTitle}</td>
					<td>${i.noticeWriter}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
							value="${i.noticeDate}" /></td>
				</tr>
				<tr>
					<td colspan="4"><c:set var="img" value="${i.noticePhoto}" />
						<c:if test="${img != null}">
							<br>
							<img src="${pageContext.request.contextPath}/uploadfile/userphoto/${i.noticePhoto}">
							<br>
						</c:if> 
						${i.noticeCont}</td>
				</tr>

				<c:if test="${loginInfo.manager}">
					<tr>
						<td colspan="4" style="text-align: right">
						
						<input type="button" class="btn btn-default" onclick="javascript:location.href='edit?noticeNo=' + ${i.noticeNo}" value="수정">
							<input type="button" class="btn btn-default" Onclick="deleteNo(${i.noticeNo})" value="삭제">
						
						<%-- <a
							href="edit?noticeNo=${i.noticeNo}">수정하기</a> <a
							href="delete?noticeNo=${i.noticeNo}"
							Onclick="javascript:deleteNo()">삭제하기</a> --%>
							</td>
					</tr>
				</c:if>
				<tr>
					<td colspan="4" style="text-align: center"><a href="list">목록보기</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>