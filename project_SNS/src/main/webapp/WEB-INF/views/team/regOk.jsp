<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OpenProject</title>
<link rel="stylesheet" href="../CSS/default.css">

</head>
<body>
   <%-- <%@ include file="/WEB-INF/views/common/header.jsp"%> --%>
   <!-- 커넥션타입 : 디스패처서블릿인 스프링컨테이너를 호출하여  memberInfo 객체를 저장하여 
   사용자의 요청을 자동으로 바인딩한후 메서드 호출시(memberReg()) resource타입으로 데이터를 공유한다. -->
   <div id="contents">
      <h2>회원가입</h2>
      <table>
         <tr>
            <td>아이디(이메일)</td>
            <td>${memberInfo.userId}</td>
         </tr>
         <tr>
            <td>비밀번호</td>
            <td>${memberInfo.password}</td>
         </tr>
         <tr>
            <td>이름</td>
            <td>${memberInfo.userName}</td>
         </tr>
         <tr>
            <td>사진</td>
            <td>${memberInfo.userPhoto}</td>
         </tr>
      </table>
   </div>
   
</body>
</html>