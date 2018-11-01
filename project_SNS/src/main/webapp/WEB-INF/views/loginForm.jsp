<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.team.springsns.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BitBox</title>
<%-- <meta name="viewport" content="width=device-width" initial-scale="1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css"
	type="text/css"> --%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/loginCSS.css"
	type="text/css">
<!-- 구글폰트 -->
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Nanum+Myeongjo"
	rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>

<style type="text/css">
body {
	background-image:
		url("${pageContext.request.contextPath}/images/back.png");
}

#logo {
	width: 250px;
	margin-left: 30px;
	margin-bottom: 10px;
	padding-top: 10px;
}
</style>

</head>
<body>
	<script>
		$(document).ready(
				function() {

					// 쿠키 생성
					function setCookie(cookieName, value, exdays) {
						var exdate = new Date();
						exdate.setDate(exdate.getDate() + exdays);
						var cookieValue = escape(value)
								+ ((exdays == null) ? "" : "; expires="
										+ exdate.toGMTString());
						document.cookie = cookieName + "=" + cookieValue;
					}
					// 쿠키 가져오기
					function getCookie(cookieName) {
						cookieName = cookieName + '=';
						var cookieData = document.cookie;
						var start = cookieData.indexOf(cookieName);
						var cookieValue = '';
						if (start != -1) {
							start += cookieName.length;
							var end = cookieData.indexOf(';', start);
							if (end == -1)
								end = cookieData.length;
							cookieValue = cookieData.substring(start, end);
						}
						return unescape(cookieValue);
					}

					// 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
					var key = getCookie("key");
					$("#userId").val(key);

					if ($("#userId").val() != "") { // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
						$("#idSaveCheck").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
					}

					$("#idSaveCheck").change(function() { // 체크박스에 변화가 있다면,
						if ($("#idSaveCheck").is(":checked")) { // ID 저장하기 체크했을 때,
							setCookie("key", $("#userId").val(), 7); // 7일 동안 쿠키 보관
							console.log($("#userId").val());
						} else { // ID 저장하기 체크 해제 시,
							deleteCookie("key");
						}
					});

					// ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
					$("#userId").keyup(function() { // ID 입력 칸에 ID를 입력할 때,
						if ($("#idSaveCheck").is(":checked")) { // ID 저장하기를 체크한 상태라면,
							setCookie("key", $("#userId").val(), 7); // 7일 동안 쿠키 보관
						}
					});

					var count = 0;
				});

		function deleteCookie(cookieName) {
			var expireDate = new Date();
			expireDate.setDate(expireDate.getDate() - 1);
			document.cookie = cookieName + "= " + "; expires="
					+ expireDate.toGMTString();
		}
	</script>
	<c:choose>
	<c:when test="${empty loginInfo.userId}">
		<div class="back">
			<!-- <div class="login-form"> -->
			<table>
				<tr>
					<td><a href=#""><img
							src="${pageContext.request.contextPath}/images/logo_fin.png"
							id="logo"></a></td>
				</tr>
				<tr>
					<td>
						<form method="post">
							<div class="form-group">
								<label for="userId">이메일 주소</label> <input type="text"
									class="form-control" id="userId" name="userId"
									placeholder="이메일을 입력하세요">
							</div>
							<div class="form-group">
								<label for="userPassword">암호</label> <input type="password"
									class="form-control" name="userPassword"
									placeholder="암호를 입력하세요">
							</div>
							<div class="checkbox">
								<label> <input type="checkbox" id="idSaveCheck">
									아이디 저장하기
								</label>
							</div>
							<input type="submit" class="btn2 btn" value="로그인">
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<P>
							계정이 없으신가요? <a href="<c:url value='/team/memberReg' />">회원가입</a>
						</P>
					</td>
				</tr>
			</table>
			<!-- 	</div> -->
		</div>
	</c:when>
	<c:otherwise>
	<script>
		location.href='${pageContext.request.contextPath}/board/boardList';
	</script>
	
	</c:otherwise>
</c:choose>
</body>
</html>