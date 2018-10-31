<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/bootstrap.css"	type="text/css">
<!-- 구글폰트 -->
<link	href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Nanum+Myeongjo" 	rel="stylesheet">

<style type="text/css">
#logo{
    width:  150px;
    height: 50px;
}
.reg_form {
	width: 400px;
	margin: 40px auto;
}
.item {
	width: 150px;	
	line-height : 30px;
	vertical-align: middle;
}

.contents {
	width: 250px;
}
.title{
	text-align: center;
}
.btn{
	margin-left: 150px;
}


</style>
</head>
<body>
	<div>
		<img src="${pageContext.request.contextPath}/img/logo1.png" id="logo">
	</div>

	<div class="reg_form">
	<div class="title"><h3>회원가입</h3></div>
	
		<form method="post" enctype="multipart/form-data">
			<table class="table">
				<tr>
					<td class="item">아이디</td>
					<td class="contents"><input type="email" class="form-control"
						name="userId" placeholder="이메일을 입력하세요"></td>
				</tr>
				<tr>
					<td class="item">비밀번호</td>
					<td class="contents"><input type="password" class="form-control" name="userPassword" placeholder="암호를 입력하세요"></td>
				</tr>
				<tr>
					<td class="item">이름</td>
					<td class="contents"><input type="text" class="form-control"
						name="userName" placeholder="이름을 입력하세요"></td>
				</tr>
				<tr>
					<td class="item">프로필사진</td>
					<td class="contents"><input type="file"	name="photoFile"></td>
				</tr>
				<tr>
					<td class="item">자기소개</td>
					<td class="contents"><textarea rows="5" cols="30"
							class="form-control" name="userIntro" placeholder="자기소개를 해주세요"></textarea></td>
				</tr>
				<tr>
					<td class="item">계정공개여부</td>
					<td class="contents">
						<input type="radio" name="userBlock" value="1" checked="checked">공개  &nbsp
						<input type="radio" name="userBlock" value="0">비공개</td>
				</tr>
				<!-- <tr>
					<td class="item">계정구분</td>
					<td class="contents">
					 	<input type="radio" name="manager" value="0" checked="checked">사용자 &nbsp
					 	<input type="radio" name="manager" value="1">관리자</td>
				</tr> -->
				<tr>
					<td colspan="2"><input type="submit" class="btn btn-default" value="가입하기"></td>
				</tr>
			</table>
		</form>
		
	</div>
</body>
</html>