<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<html>
<head>
<title>Spring SNS</title>
<style>
* {
	padding: 0;
	margin: 0;
}

#header {
	background-color: gray;
	height: 100px;
}

#content {
	background-color: skyblue;
	float: left;
	width: 70%;
	height: 100%;
}

#rightside {
	float: right;
	width: 30%;
	height: 100%;
}

#icon {
	position: absolute;
}

#icon a {
	text-decoration: none;
}

#icon li {
	list-style-type: none;
	float: left;
	padding: 0 15px;
	margin: 0 auto;
}

#setting img {
	width: 30px;
	float: right;
	margin-right: 30px;
}

#profile {
	position: relative;
	height: 700px;
	margin-top: 90px;
}

#img {
	background-image: url('${pageContext.request.contextPath}/img/logo.jpg');
	background-size: 100%;
	width: 200px;
	height: 200px;
	border: 1px solid #333333;
	border-radius: 70%;
	margin: 0 auto;
	position: relative;
}

#info {
	margin: 0 auto;
	width: 200px;
	text-align: center;
	margin-top: 50px;
}
</style>

<script>
function deleteNo(){
	
	if(confirm('삭제하시겠습니까?')){
		 return true;
	} else {
		return false;
	}
}

</script>
</head>
<body>

	<section id="header">header</section>
	<article>
	<!-- 사용자 정보 가져오기 -->
		<section id="content">
			콘텐츠 표출 부분(사용자 게시글, 검색) : ajax 안가져오고 http://localhost:8090/board와 매핑되게 해놓음~<br>

			<table border="1">
				<tr>
					<td>#번호</td>
					<td>사진</td>
					<td>내용</td>
					<td>해시태그</td>
					<td>작성일</td>
					<td>댓글....</td>
					<td>관리</td>
				</tr>

				<c:forEach items="${viewData.boardList}" var="board">
					<tr>
						<td><c:out value="${board.boardNo }" /></td>
						<td><c:out value="${board.boardPhotoFile }" /></td>
						<td><c:out value="${board.boardContent }" /></td>
						<td><c:out value="${board.hashTag }" /></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd"
								value="${board.boardDate }" /></td>
						<td><a href="">${board.boardNo }에 대한 댓글보기</a></td>
						<td><a
							href="/board/edit?boardno=<c:out value="${board.boardNo }"/>" >수정</a>
							<a
							href="/board/delete?boardno=<c:out value="${board.boardNo }"/>"  Onclick="javascript:deleteNo()">삭제</a>
						</td>
					</tr>
				</c:forEach>

			</table>


			<!-- 해당페이지로 가게 넘버링 해주기 -->
			<c:forEach var="num" begin="1" end="${viewData.pageTotalCount}">
				<a href="?page=${num}">[${num}]</a>
			</c:forEach>

		</section>
		<section id="rightside">
			우측 사이드 부분
			<div id="icon">
				<ul>
					<li><a href="<%=request.getContextPath()%>/board/write">글쓰기</a></li>
					<li><a href="#">친구목록</a></li>
					<li><a href="#">쪽지함</a></li>
					<li><a href="#">프로필</a></li>
				</ul>
			</div>
			<div id="profile">
				<div id="setting">
					<img src="/img/setting.png">
				</div>
				<div id="img"></div>
				<div id="info">
					<p>ID: solsol</p>
					<p>닉네임:또리짱</p>
					<p>
						내소개: <br> 웹개발스프링 프로젝트 준비중입니다 ^_^
					</p>
				</div>
			</div>
		</section>
	</article>



</body>
</html>
