<%@ page import="com.lgcns.icst.lecture.servletjsp.lec5.SessionKey" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success</title>
</head>
<body>
<h3 style="color:blue">로그인 성공!</h3><br/>
<%
    String memberName = (String) session.getAttribute(SessionKey.MEMBER_NAME);
%>
<%= memberName %> 님 환영합니다! <br/>
<a href="<%=request.getContextPath()%>/lec5/free-board">게시판 목록</a>
</body>
</html>
