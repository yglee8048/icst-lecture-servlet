<%@ page import="java.util.List" %>
<%@ page import="com.lgcns.icst.lecture.servletjsp.lec4.FreeBoardEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        table {
            border-collapse: collapse;
            border: 1px solid black;
        }

        table th {
            font-weight: bold;
            background: lightgray;
            border: 1px solid black;
        }

        table td {
            border: 1px solid black;
        }
    </style>
    <title>게시판</title>
</head>
<body>

<table>
    <th>번호</th>
    <th>내용</th>
    <th>작성시간</th>
    <th>작성자</th>
    <%
        List<FreeBoardEntity> freeBoards = (List<FreeBoardEntity>) request.getAttribute("freeBoards");
        for (FreeBoardEntity freeBoard : freeBoards) {
    %>
    <tr>
        <td><%=freeBoard.getId()%>
        </td>
        <td><%=freeBoard.getContent()%>
        </td>
        <td><%=freeBoard.getWriteDate()%>
        </td>
        <td><%=freeBoard.getWriterId()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
<a href="<%=request.getContextPath()%>/lec4/freeBoardWrite.html">글쓰기</a> <br/>

</body>
</html>
