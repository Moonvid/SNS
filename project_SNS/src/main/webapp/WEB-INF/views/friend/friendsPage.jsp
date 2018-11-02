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
#boardSection {
	width: 60%;
}

.userBoard {
	padding: 10px;
	margin: 10px;
	border: 1px solid;
}

.commentSection {
	padding-left: 20px;
	padding-bottom: 20px;
	background-color: white;
}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/common/layout_top.jsp"%>
<%@ include file="/WEB-INF/views/common/layout_right.jsp"%>

<br><br>
<!--혜연언니바보ㅋㅋㅋㅋ -->
	<h1>친구 페이지</h1>
	<br><br>
	<h4>ID : ${friendInfo.userId}</h4> 
	<h4>이름 : ${friendInfo.userName}</h4>

	<c:forEach var="friendRequestInfo" items="${friendRequestInfo}">
	<input id="loginUser${friendRequestInfo.requestUserNo}" type="hidden" value="${friendRequestInfo.requestAccept }" /></c:forEach>
	
	<c:if test="${chkFriends==0}">
	<span class="${loginInfo.userNo}"><button id="${loginInfo.userNo}" value="${loginInfo.userNo},${loginInfo.userName},${friendInfo.userNo},${friendInfo.userName}" onclick="friendReg(this)">[친구신청]</button></span>
	<script>
		var aarray = $('button[onclick="friendReg(this)"]').val().split(',');
		var cancelRequest1='<td class="1"><button value ="'+aarray[0]+','+aarray[1]+','+aarray[2]+','+aarray[3]+'" onclick="cancelReg(this)">[요청취소]</button></td>';
		console.log($('input[type="hidden"]').val());
		if($('input[type="hidden"]').val()=='false'){
			$('button[onclick="friendReg(this)"]').text('[요청중...]');
			$('button[onclick="friendReg(this)"]').attr('disabled',true);
			$('.${loginInfo.userNo}').after(cancelRequest1);
		}
	</script>
	
	</c:if>
	
	<script>
	/* 로그인 되어있는 상태의 입장이라 생각하고 진행 */
	/* 친구신청 페이지 들어왔을떄 요청 중인지 아닌지 확인하기 위한 코드 */
	
	
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
	
	<!-- ------------------------------------------------------------------------------------------------------------------------------ -->
	
	<!-- 친구 페이지 게시글 표시 -->
	<section id="boardSection">
		<c:forEach items="${viewData.boardList}" var="board">
			<div class="userBoard">
				<div>
					#번호: <c:out value="${board.boardNo }" /> /
					UserNo: <c:out value="${friendInfo.userNo }" />
					<script>
						var test = ${board.boardNo}
						console.log("#태그 용 번호 : " + test);
					</script>
				</div>
				
				<div>
					<c:set var="cont" value="신고접수된 글입니다." />
					<c:set var="boardcont" value="${board.boardContent}" />
					<c:if test="${boardcont ne cont}">
					사진: <img src="<c:url value='${pageContext.request.contextPath}/uploadfile/${board.boardPhotoFile}' />">
						<%-- <c:out value="${board.boardPhotoFile }" /> --%>
					</c:if>
				</div>
				
				<div>
					내용: <c:out value="${board.boardContent }" />
				</div>
				
				<div>
					해시태그: <c:out value="${board.hashTag }" />
				</div>
				
				<div>
					등록일: <fmt:formatDate pattern="yyyy-MM-dd" value="${board.boardDate }" />
				</div>
				
				<div>
					<c:if test="${boardcont ne cont}">
						<a href="${pageContext.request.contextPath}/board/edit?boardno=<c:out value="${board.boardNo}"/>">수정</a>
						<script>
							var test = ${board.boardNo}
							console.log("수정용 번호 : " + test);
						</script>
						<a href='${pageContext.request.contextPath}/board/delete?boardno=<c:out value="${board.boardNo}" />&userid=<c:out value="${friendInfo.userId }" />'>삭제</a>
						<script>
							var test = ${board.boardNo}
							console.log("삭제용 번호 : " + test);
						</script>
					</c:if>
				</div>
				
				<div>
					<c:if test="${boardcont ne cont}">
						<input type="hidden" id="reportChk" value="${board.reportCheck}">
							<button class="btn btn-default" <%-- Onclick="reportNo(${board.boardNo})" --%> value="${board.boardNo }">신고하기</button>
							<script>
								var test = ${board.boardNo}
								console.log("신고 용 번호 : " + test);
							</script>
					</c:if>
				</div>
				
				<span id="isGood_${board.boardNo}">좋아요 : 
					<script>
						var test = ${board.boardNo}
						console.log("좋아요 용 번호 : " + test);
					</script>
					<c:if test="${isGoodList.isEmpty()}">0</c:if> 
					<c:if test="${!isGoodList.isEmpty() }">
						<c:forEach var="isGood" items="${isGoodList}">
							<c:if test="${board.boardNo eq isGood.boardNo}">
								${isGood.isGoodCnt}
							</c:if>
						</c:forEach>
					</c:if>
				</span> 
				
				<span> 
					<c:if test="${boardcont ne cont}">
						<button class="isGoodBnt" value="${board.boardNo}">좋아요!</button>
						<script>
								var test = ${board.boardNo}
								console.log("좋아요 후 번호 : " + test);
						</script>
					</c:if>
				</span><br>
				
				<c:if test="${boardcont ne cont}">
					<span><a href="${pageContext.request.contextPath}/board/comment?boardNo=${board.boardNo}">[댓글달기]</a></span>
					<script>
						var test = ${board.boardNo}
						console.log("댓글 달기용 번호 : " + test);
					</script>
					<br>
					<span>
						<button class="commBtn" value="${board.boardNo}">댓글...댓글을보자!</button></span>
							<script>
								var test = ${board.boardNo}
								console.log("댓글 보기용 번호 : " + test);
							</script>
				</c:if>
				
				<div class="commentSection" id="commHidden_${board.boardNo}" style="display: none;">
					<script>
						var test = ${board.boardNo}
						console.log("댓글 숨기기용 번호 : " + test);
					</script>
				</div>

				</div>
		</c:forEach>
	</section>



	<!-- 해당페이지로 가게 넘버링 해주기 -->
	<c:forEach var="num" begin="1" end="${viewData.pageTotalCount}">
		<a href='${pageContext.request.contextPath}/friend/friendsPage/${friendInfo.userNo}?userId=<c:out value="${friendInfo.userId }" />&page=${num}'>[${num}]</a>
	</c:forEach>
	
		<script>
		$('.commBtn').click(function() {
			   	var userId = '${loginInfo.userId}';
				var bNo = $(this).val();
				console.log(bNo);
				/* alert(bNo); */
				var commList = [];
				var comm = "";
			 	
				status = $('#commHidden_'+bNo).css("display");
				if(status=="none"){
					status = $('#commHidden_'+bNo).css("display", "");
					
					$.ajax({
						type: "GET",
						url: "${pageContext.request.contextPath}/board/viewComment",
						data: {"bNo":bNo},
						dataType: "JSON",
					 	success: function(data){
					 		commList = data;
					 		
					 		if(commList.length==0){
					 			comm += 'NO COMMENT!';
					 		}else{
					 				comm += '<br>총 댓글: '+commList.length+'<br>';
					 			for(var i=0; i<commList.length; i++){
					 				comm += '<br>댓글번호 : '+commList[i].commentNo+' ';
					 				comm += '<a href="editComment?commentNo='+commList[i].commentNo+'">[수정하기]</a>';
					 				comm += '<a href="deleteComment?commentNo='+commList[i].commentNo+'&userId='+userId+'">[삭제하기]</a><br>';
					 				comm += '작성자 : '+commList[i].userId+'<br>';
					 				comm += '코멘트 : '+commList[i].commentCont+'<br>';
					 			}
					 		}
					 		$('#commHidden_'+bNo).empty();
					 		$('#commHidden_'+bNo).append(comm);
					 	}
					});
					
				}else{
					status = $('#commHidden_'+bNo).css("display", "none");
				}
		});
		</script>
		
		<script>
			$('.isGoodBnt').click(function() {
				var boardNo = $(this).val();
				var userNo = ${friendInfo.userNo}
				 $.ajax({
				 	type: "POST",
					url: "${pageContext.request.contextPath}/board/isGoodBoard",
					data: {"boardNo":boardNo, "userNo":userNo},
				 	success: function(data){
				 		$('#isGood_'+boardNo).empty(),
						$('#isGood_'+boardNo).append("좋아요 : "+data);
				 	}                                                             
				});
			});
		</script>
		
		<script>
			$('.btn').click(function() {
				var boardNo = $(this).val();
				var userNo = '${friendInfo.userNo}';
				var chk = confirm('신고하시겠습니까?');
			
				/* 루트기준 절대경로 */
				var url = '${pageContext.request.contextPath}/reportcnt';
				var url2 = '${pageContext.request.contextPath}';
				var url3 = '${pageContext.request.contextPath}/friend/friendsPage/${friendInfo.userNo}';
				$.ajax({
					url : url,
					data : {
						"boardNo" : boardNo
					}, 
					success : function(chk, response) {
						if (response == 1 && chk) {
							$('#reportChk').val('true');
							$('.btn').attr('disabled', true);
						}
					}
				});
				
				$.ajax({
					url : url2,
					data : {
						"boardNo" : boardNo,
						"userNo" : userNo
					},
					success : function reportNo(chk){
						if (chk) {
							location.href='${pageContext.request.contextPath}/board/report?boardNo='+boardNo+'&userNo='+userNo;
							//location.href=url3;
							}
						}
					});
					
				});
		</script>
</body>
</html>