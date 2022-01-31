<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success</title>
</head>
<body>
<h1 style="color:blue">로그인 성공!</h1><br/>
이름 : <%=request.getAttribute("username")%><br/>
사번 : <%=request.getAttribute("password")%><br/>
</body>
</html>
