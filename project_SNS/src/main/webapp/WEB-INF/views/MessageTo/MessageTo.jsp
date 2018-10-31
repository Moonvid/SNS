<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width" initial-scale="1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/loginCSS.css"
	type="text/css">
<!-- 구글폰트 -->
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Nanum+Myeongjo"
	rel="stylesheet">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/common/layout_top.jsp"%>
	<%@ include file="/WEB-INF/views/common/layout_right.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<h1>받은 메세지 출력</h1>
	<table border="1">
		<tr>
			<td>보낸사람</td>
			<td>받은사람</td>
			<td>메세지 내용</td>
			<td>보낸 시간</td>
			<td>메세지 확인 유무</td>
			<td>확인 버튼</td>
		</tr>
		<c:forEach var="messageInfo" items="${messageInfo}">
			<tr class="checkMessage">
				<td>${messageInfo.sendId }</td>
				<td>${messageInfo.recvId }</td>
				<td>${messageInfo.messageCont }</td>
				<td>${messageInfo.sendDate }</td>
				<td id="unique${messageInfo.messageNum}" class="${messageInfo.messageNum}">${messageInfo.checkMessage }</td>
				<td><button class="ReadMessage"	value="${messageInfo.messageNum}">[읽음]</button></td>				
				<td><button  value="${messageInfo.messageNum},${messageInfo.recvId }" class="DeleteMessage" 
				onclick="MessageDelete(this)">[삭제]</button></td>
			</tr>
		</c:forEach>
	</table>
	<a href="../">[메인으로]</a>
	<!-- 왜 data 받을때 그냥 messageNum으로 받으면 값 안넘어가는지는 잘 모르겠다. 질문하자 -->
	<!--경로도 왜 contextPath까지 다 써줘야하나?-->
	<script>
	/* 삭제 버튼 눌렀을 때 삭제 할지 말지 confirm뜸 */
	function MessageDelete(obj){
		var param = $(obj).val().split(',');
		var con = confirm('삭제하시겠습니까?');
		if(con){
			var url ="/tp/MessageDelete?messageNum="+param[0]+"&recvId="+param[1];
			location.href = url;
		}
	}
	
	/* 페이지 로드 될떄 읽음 버튼 누른애들은 버튼 비활성화 */
		$(document).ready(function() {
			$('.checkMessage').filter(function(text) {
				/* this==text */
				$(this).filter(function(test) {
					var secondthis = $(this);
					/* this==test */
					$(this).find('td[id*="unique"]').each(function(index, item) {
						if (item.innerHTML == "true") {
							secondthis.find('.ReadMessage').attr('disabled', true);
						}
					});
				});
			});
		});
		/* 읽음 버튼 누른애들 비활성화+메세지 읽음 처리 */
		$('.ReadMessage').click(function(kk) {
			var messageNum = $(this).val();
			var attribute = $(this);
			/* 루트기준 절대경로 */
			var url = '/tp/ReadMessage';
			var checkMessage = '#unique' + messageNum;
			$.ajax({
				url : url,
				data : {
				/* 파라미터 넘기는것 '?num=ttt' */
					"messageNum" : messageNum
				}, 
				success : function(response) {
					if (response == 1) {
						$(checkMessage).text('true');
						attribute.attr('disabled', true);
					}
				}
			});
		});
	</script>
</body>
</html>