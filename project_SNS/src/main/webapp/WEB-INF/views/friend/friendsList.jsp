<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
table {
	border: 1px solid black;
}
td {
	padding: 20px;
	text-align: center;
}
</style>
</head>
<body>
<h1>친구 목록</h1>

<c:if test="${empty friendsList}">
		등록된 친구가 없습니다.
</c:if>

<c:if test="${!empty friendsList}">
	<table>
		<tr>
			<td>FriendName</td>
		</tr>
		<c:forEach var="friends" items="${friendsList}">
			<tr>
				<td><a href="friendsPage/${friends.userNo}">${friends.userName}</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

<h1>받은 친구 요청</h1>
<c:if test="${empty requestList}">
		전달  받은 친구신청이 없습니다.
</c:if>

<c:if test="${!empty requestList}">
	<table>
		<tr>
			<td>FriendName</td>
		</tr>
		<c:forEach var="request" items="${requestList}">
			<tr>
				<td><a href="#">${request.requestUserName}</a></td>
				<td><button class="accept" value="${loginInfo.userNo},${request.requestUserNo}" onclick="Accept(this)">수락</button></td>
				<td><button class="deny" value="${loginInfo.userNo},${request.requestUserNo}" onclick="deny(this)">거절</button></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

<script>

	$(document).ready(function(){
		
		
		
	});
	
	// 친구 요청 수락 했을 때
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
				if(data == 1){
					alert("수락 성공!");
				}
			}
		});
		
	}
	
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
				if(data == 1){
					alert("거절 성공!");
				}
			}
		});
	}
</script>
</body>
</html>