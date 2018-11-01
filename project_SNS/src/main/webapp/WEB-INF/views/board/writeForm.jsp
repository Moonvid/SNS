<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post" enctype="multipart/form-data">
	<!-- 사용자 관련 내용은 hidden으로 바꿔야함 -->
		사용자no: <input type="text" name="userNo" value=${loginInfo.userNo }><br>
		사용자id: <input type="text" name="userId" value=${loginInfo.userId }><br>
		내용: <textarea name="boardContent"></textarea><br> 
 		사진: <input type="file" name="boardPhotoFile"><br> 
		해시태그: <input type="text" name="hashTag"><br>
		<button type="submit">submit button</button>
		<input type=button value="취소" OnClick="javascript:history.back(-1)">
	</form>

</body>
</html>