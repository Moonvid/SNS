<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/common/layout_top.jsp"%>
<%@ include file="/WEB-INF/views/common/layout_right.jsp"%>

<br><br>

	<h1>친구 페이지</h1>
	<br><br>
	<h4>ID : ${friendInfo.userId}</h4> 
	<h4>이름 : ${friendInfo.userName}</h4>

	<c:forEach var="friendRequestInfo" items="${friendRequestInfo}">
	<input id="loginUser${friendRequestInfo.requestUserNo}" type="hidden" value="${friendRequestInfo.requestAccept }" /></c:forEach>
	
	<c:if test="${chkFriends==0}">
	<span class="${loginInfo.userNo}"><button id="${loginInfo.userNo}" value="${loginInfo.userNo},${loginInfo.userName},${friendInfo.userNo},${friendInfo.userName}" onclick="friendReg(this)">[친구신청]</button></span>
	</c:if>
	
	<script>
	/* 로그인 되어있는 상태의 입장이라 생각하고 진행 */
	/* 친구신청 페이지 들어왔을떄 요청 중인지 아닌지 확인하기 위한 코드 */
	
	$(document).ready(function(){
		var aarray = $('button[onclick="friendReg(this)"]').val().split(',');
		var cancelRequest1='<td class="1"><button value ="'+aarray[0]+','+aarray[1]+','+aarray[2]+','+aarray[3]+'" onclick="cancelReg(this)">[요청취소]</button></td>';
		console.log($('input[type="hidden"]').val());
		
		if($('input[type="hidden"]').val()=='false'){
			$('button[onclick="friendReg(this)"]').text('[요청중...]');
			$('button[onclick="friendReg(this)"]').attr('disabled',true);
			$('.${loginInfo.userNo}').after(cancelRequest1); 
		}
		
		
		
	});
	
	/* 요청 버튼 누르면 요청중 으로 변경 */
	function friendReg(data){
		var tdClass = "." + ${loginInfo.userNo};
		var tagData = $(data);
		var userNoArray = $(data).val().split(',');
		var cancelRequest = '<td class="1"><button value ="'+userNoArray[0]+','+userNoArray[1]+','+userNoArray[2]+','+userNoArray[3]+'" onclick="cancelReg(this)">[요청취소]</button></td>';
		var url = '${pageContext.request.contextPath}/friendReg';
		
		 $.ajax({
			url: url,
			data:{"requestUserNo":userNoArray[0],
				  "requestUserName":userNoArray[1],
				  "responseUserNo":userNoArray[2],
				  "responseUserName":userNoArray[3]
			},
			success:function(data){
				if(data == 1){
					tagData.text('[요청중...]');
					tagData.attr('disabled',true);
					$(tdClass).after(cancelRequest);
				}
			}
		
		});
	}
	/* 요청 취소 버튼 눌른것 */
	function cancelReg(data){
		var tdClass = "." + ${loginInfo.userNo};
		var buttonid = "#" + ${loginInfo.userNo};
		var tagData = $(data);
		var cancelArray = $(data).val().split(',');
		var url = '${pageContext.request.contextPath}/friendRegCancel';
	
		 $.ajax({
			url:url,
			data:{
				"requestUserNo":cancelArray[0],
				"requestUserName":cancelArray[1],
				"responseUserNo":cancelArray[2],
				"responseUserName":cancelArray[3]
			},
			success:function(data){
				 if(data == 1){
				 	$(buttonid).text('[친구 신청]');
				 	$(buttonid).attr('disabled',false);
				 	$('td[ class="1"]').remove();
				} 
			}
		}); 
		
	}
	
	
	
	</script>

</body>
</html>