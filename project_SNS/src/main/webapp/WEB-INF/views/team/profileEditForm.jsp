<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/layout_top.jsp"%>
	<%@ include file="/WEB-INF/views/common/layout_right.jsp"%>

	<form method="post" enctype="multipart/form-data">
		<table border=1>
			<tr>
				<td style="width: 150px;">아이디</td>
				<td style="width: 150px;">비밀번호</td>
				<td style="width: 150px;">이름</td>
				<td style="width: 150px;">사진</td>
				<td style="width: 150px;">내 소개</td>
			</tr>
			<tr>
				<td><input type="text" name="userId"
					value="${memberInfo.userId}" /></td>
				<td><input type="text" name="userPassword"
					value="${memberInfo.userPassword}" /></td>
				<td><input type="text" name="userName"
					value="${memberInfo.userName}" /></td>
				<td><input type="file" name="photoFile"
					value="${memberInfo.userProfilePhoto}" /></td>
				<td><input type="text" name="userIntro"
					value="${memberInfo.userIntro}" /></td>
			</tr>

			<tr>
				<td colspan="5"><input type="submit" value="수정하기"></td>
			</tr>
		</table>
	</form>

</body>
</html>