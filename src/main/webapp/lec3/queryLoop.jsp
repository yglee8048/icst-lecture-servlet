<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String age = request.getParameter("age");

    for (int i = 0; i < 3; i++) {
%>
<%=i%> 번째 출력 <br/>
이름 : <%=name%> <br/>
나이 : <%=age%> <br/>
<%
    }
%>
</body>
</html>
