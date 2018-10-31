<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>header</title>
<style>
.img {
	width: 100px;
}

#logo {
	width: 100px;
	position: absolute;
}

#search {
	width: 500px;
	position: absolute;
	margin-left: 600px;
}

#wrap {
	width: 100%;
	position: relative;
}
</style>
</head>
<body>
	<div id="wrap">
		<div id="logo">
			<img src="${pageContext.request.contextPath}/img/logo.jpg" class="img">
		</div>
		<div id="search">
			<input type="text" placeholder="검색어를 입력하세요.">
			<button>검색</button>
		</div>
	</div>
</body>

</html>
