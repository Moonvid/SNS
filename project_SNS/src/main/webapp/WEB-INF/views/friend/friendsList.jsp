<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<meta name="viewport" content="width=device-width" initial-scale="1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/loginCSS.css"
	type="text/css">
<!-- 구글폰트 -->
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Nanum+Myeongjo" rel="stylesheet">
<style>
#friendmenu{
	padding: 20px;
	text-align: center;
	font-size: 20px;
}
#friendname {
	padding: 20px;
}
#tablesetting{
	text-align: center;
	border: 1px solid black;
	width: 700px;
}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/common/layout_top.jsp"%>
<%@ include file="/WEB-INF/views/common/layout_right.jsp"%>
<br><br>
<h1>친구 목록</h1>

<c:if test="${empty friendsList}">
		등록된 친구가 없습니다.
</c:if>

<c:if test="${!empty friendsList}">
	<div id="showFriend">
	<table id="tablesetting" border=1>
		<tr>
			<td id="friendmenu" colspan="3">친구목록</td>
		</tr>
		<c:forEach var="friends" items="${friendsList}">
			<tr>
				<td id="friendname"><a href="friendsPage/${friends.userNo}">${friends.userName}</a></td>
			
				<td id="friendname"><button class="remove" value="${loginInfo.userNo},${friends.userNo}" onclick="Remove(this)">친구 해제</button></td>
					
				<td><button onclick="location.href='${pageContext.request.contextPath}/MessageFrom/MessageFrom?recvid=${friends.userId }&sendid=${loginInfo.userId }'" >쪽지보내기</button></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</c:if>

<br><br><br><br>
<h1>받은 친구 요청</h1>
<c:if test="${empty requestList}">
		전달  받은 친구신청이 없습니다.
</c:if>

<c:if test="${!empty requestList}">
	<div id="showRequest">
	<table id="tablesetting" border=1>
		<tr>
			<td colspan=3 id="friendmenu">요청목록</td>
		</tr>
		<c:forEach var="request" items="${requestList}">
			<tr>
				<td id="friendname"><a href="#">${request.requestUserName}</a></td>
				<td id="friendname"><button class="accept" value="${loginInfo.userNo},${request.requestUserNo}" onclick="Accept(this)">수락</button></td>
				<td id="friendname"><button class="deny" value="${loginInfo.userNo},${request.requestUserNo}" onclick="deny(this)">거절</button></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</c:if>

<script>

	$(document).ready(function(){
		
		
		
	});
	
	// 친구 해제 했을 때
	
	function Remove(data){
		var userNoArray = $(data).val().split(',');
		var url = '${pageContext.request.contextPath}/friendRemove';
		$.ajax({
			url: url,
			data: {
				"userNo": userNoArray[0],
				"friendNo": userNoArray[1]
			},
			success:function(data){
				location.reload();
			}
		});
	}
	
	// 친구 요청 수락했을 때
	function Accept(data){
		
		var userNoArray = $(data).val().split(',');
		
		var url = '${pageContext.request.contextPath}/friendAccept';

		$.ajax({
			url: url,
			data: {
				"responseUserNo" : userNoArray[0],
				"requestUserNo" : userNoArray[1],
				"userNo" : userNoArray[0],
				"friendNo" : userNoArray[1]
			},
			success:function(data){
			
				location.reload();
			}
		});
		
	}
	
	// 친구 요청 거절했을 때
	function deny(data){
		
		var userNoArray = $(data).val().split(',');
		
		var url = '${pageContext.request.contextPath}/friendDeny';

		$.ajax({
			url: url,
			data: {
				"responseUserNo" : userNoArray[0],
				"requestUserNo" : userNoArray[1]
			},
			success:function(data){
				
				location.reload();
			}
		});
	}
</script>
</body>
</html>