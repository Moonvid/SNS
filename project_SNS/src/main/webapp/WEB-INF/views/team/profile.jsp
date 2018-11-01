<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h2, td {
	padding: 10px;
}


#memberPhoto {
	background-image: url('<%=request.getContextPath()%>/uploadfile/userphoto/${loginInfo.userProfilePhoto}');
	background-size: 100%;
	width: 200px;
	height: 200px;
	border: 1px solid #333333;
	border-radius: 75%;
	margin: 20px 0;
}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/common/layout_top.jsp"%>
	<%@ include file="/WEB-INF/views/common/layout_right.jsp"%>
	
<div class="wrapper">
	<h1>내 프로필</h1>
	<div id="memberPhoto"></div>
	
	<form>
		<table>
			<tr>
				<td>아이디</td>
				<td>${loginInfo.userId}</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td></td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${loginInfo.userName}</td>
			</tr>
			<tr>
				<td>내 소개</td>
				<td>${loginInfo.userIntro}</td>
			</tr>
			<tr>
				<td colspan="2"><a href="profileEdit?userId=${loginInfo.userId}"><input type="button" value="수정하기"></a></td>
			</tr>

		</table>

	</form>
	</div>

</body>
</html>