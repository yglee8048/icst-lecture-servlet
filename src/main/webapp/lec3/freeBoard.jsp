<%@ page import="com.lgcns.icst.lecture.servletjsp.lec3.FreeBoard" %>
<%@ page import="java.util.List" %>
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
    <th>제목</th>
    <th>내용</th>
    <th>작성자</th>
    <th>작성시간</th>
    <%
        List<FreeBoard> freeBoards = (List<FreeBoard>) request.getAttribute("freeBoards");
        for (FreeBoard freeBoard : freeBoards) {
    %>
    <tr>
        <td><%=freeBoard.getId()%>
        </td>
        <td><%=freeBoard.getTitle()%>
        </td>
        <td><%=freeBoard.getContent()%>
        </td>
        <td><%=freeBoard.getCreatedBy()%>
        </td>
        <td><%=freeBoard.getCreatedAt()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
<br/>

<form action="/servlet-jsp/free-board" method="post">
    <h1>게시글 입력</h1>
    <label> 제목
        <input type="text" name="title" placeholder="제목">
    </label>
    <label> 작성자
        <input type="text" name="createdBy" placeholder="작성자">
    </label><br/>
    <label> 내용
        <input type="text" name="content" placeholder="내용">
    </label><br/>
    <button type="submit">작성</button>
</form>

</body>
</html>
