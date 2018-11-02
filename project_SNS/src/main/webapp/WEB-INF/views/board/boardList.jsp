<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<section id="boardSection">
		<c:forEach items="${viewData.boardList}" var="board">
			<div class="userBoard">
				<div>
					#번호:
					<c:out value="${board.boardNo }" />
					로그인 userno:
					<c:out value="${loginInfo.userNo }" />
				</div>
				<div>
					<c:set var="cont" value="신고접수된 글입니다." />
					<c:set var="boardcont" value="${board.boardContent}" />
					<c:if test="${boardcont ne cont}">
					사진: <img
							src="<c:url value='/uploadfile/${board.boardPhotoFile}' />">
						<%-- <c:out value="${board.boardPhotoFile }" /> --%>
					</c:if>
				</div>
				<div>
					내용:
					<c:out value="${board.boardContent }" />
				</div>
				<div>
					해시태그:
					<c:out value="${board.hashTag }" />
				</div>
				<div>
					등록일:
					<fmt:formatDate pattern="yyyy-MM-dd" value="${board.boardDate }" />
				</div>
				<div>
					<c:if test="${boardcont ne cont}">
						<a
							href="<%=request.getContextPath()%>/board/edit?boardno=<c:out value="${board.boardNo}"/>">수정</a>
						<a
							href='<%=request.getContextPath()%>/board/delete?boardno=<c:out value="${board.boardNo}" />&userid=<c:out value="${loginInfo.userId }" />'>삭제</a>
					</c:if>
				</div>
				<div>
					<c:if test="${boardcont ne cont}">
					<input type="hidden" id="reportChk" value="${board.reportCheck}">
						<button class="btn2 btn-default2"
							<%-- Onclick="reportNo(${board.boardNo})" --%> value="${board.boardNo }">신고하기</button>
					</c:if>
				</div>
				<span id="isGood_${board.boardNo}">좋아요 : <c:if
						test="${isGoodList.isEmpty()}">0</c:if> <c:if
						test="${!isGoodList.isEmpty() }">
						<c:forEach var="isGood" items="${isGoodList}">
							<c:if test="${board.boardNo eq isGood.boardNo}">
							${isGood.isGoodCnt}
						</c:if>
						</c:forEach>
					</c:if>
				</span> <span> <c:if test="${boardcont ne cont}">
						<button id="is_${board.boardNo}_${loginInfo.userNo}" class="isGoodBnt" value="${board.boardNo}">좋아요!</button>
					</c:if>
				</span><br>
				<c:if test="${boardcont ne cont}">
					<span><a href="comment?boardNo=${board.boardNo}">[댓글달기]</a></span>
					<br>
					<span><button class="commBtn" value="${board.boardNo}">댓글...댓글을
							보자!</button></span>
				</c:if>
				<div class="commentSection" id="commHidden_${board.boardNo}"
					style="display: none;"></div>

			</div>
		</c:forEach>
	</section>

	<!-- 해당페이지로 가게 넘버링 해주기 -->
	<c:forEach var="num" begin="1" end="${viewData.pageTotalCount}">
		<a
			href='boardList?userId=<c:out value="${loginInfo.userId }" />&page=${num}'>[${num}]</a>
	</c:forEach>

<!-- &userid=<c:out value="${loginInfo.userId }" /> -->






<script>
$(document).ready(function(){
	var userNo = ${loginInfo.userNo}
	$.ajax({
 		type: "GET",
		url: "isGood",
		data: {"userNo":userNo},
 		success: function(isGood){
 			if(isGood.length>0){
 				for(var i=0; i<isGood.length; i++){
 					var bNo = isGood[i].boardNo;
 						$('#is_'+bNo+'_'+userNo).empty();
				 		$('#is_'+bNo+'_'+userNo).append("안좋아요");
 					 }
 				}
 			}
	});
});
</script>

	<script>
$('.commBtn').click(function() {
	   	var userId = '${loginInfo.userId}';
		var bNo = $(this).val();
		/* alert(bNo); */
		var commList = [];
		var comm = "";
	 	
		status = $('#commHidden_'+bNo).css("display");
		if(status=="none"){
			status = $('#commHidden_'+bNo).css("display", "");
			
			$.ajax({
				type: "GET",
				url: "viewComment",
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
		if($(this).html()=='좋아요'){
			$(this).html('안좋아요');
		}else{
			$(this).html('좋아요');
		}
		
		var boardNo = $(this).val();
		var userNo = ${loginInfo.userNo}
		 $.ajax({
		 	type: "POST",
			url: "isGoodBoard",
			data: {"boardNo":boardNo, "userNo":userNo},
		 	success: function(data){
		 		$('#isGood_'+boardNo).empty(),
				$('#isGood_'+boardNo).append("좋아요 : "+data);
		 	}                                                             
		});
	});
</script>

<script>

$('.btn2').click(function() {
	var boardNo = $(this).val();
	var userNo = '${loginInfo.userNo}';
	var chk = confirm('신고하시겠습니까?');

	/* 루트기준 절대경로 */
	var url = '/springsns/reportcnt';
	var url2 = '/springsns';
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
				location.href='report?boardNo='+boardNo+'&userNo='+userNo;
				}
			}
		});
		
	});
</script>
</body>
</html>