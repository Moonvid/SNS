<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원리스트</title>
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
	function deleteMember(userNo) {

		if (confirm('회원을 탈퇴하시겠습니까?')) {
			return location.href="delete_member?userNo="+userNo;
		}
	}
</script>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<c:if test="${members.isEmpty()}">
		<h1 id="title">가입된 회원이 없습니다.</h1>
	</c:if>

	<c:if test="${!members.isEmpty()}">
		<div id="wrap">
			<h1 id="title" style="text-align: center;">회원목록</h1><br>

			<form>
				<table class="table table-hover">
					<tr>
						<th>회원번호</th>
						<th>아이디</th>
						<th>이름</th>
						<th>비밀번호</th>
						<th>회원소개</th>
						<th>관리</th>
					</tr>
					<c:forEach var="member" items="${members}">
						<tr>
							<td>${member.userNo}</td>
							<td>${member.userId}</td>
							<td>${member.userName}</td>
							<td>${member.userPassword}</td>
							<td>${member.userIntro}</td>
							<td>
							<input type="button" class="btn btn-default" onclick="javascript:location.href='edit_member?userNo='+${member.userNo}" value="수정">
							<input type="button" class="btn btn-default" Onclick="deleteMember(${member.userNo})" value="탈퇴">
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</c:if>

</body>
</html>