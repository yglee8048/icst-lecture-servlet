<%@ page import="com.lgcns.icst.lecture.servletjsp.lec5.FreeBoardEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/lec5/freeBoardList.css">
    <title>게시판</title>
</head>
<body>

<h2>게시판</h2>
<%
    String memberName = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("memberName")) {
                memberName = cookie.getValue();
            }
        }
    }
%>
<div class="col-xs-12">
    <div>
        <p>
            <strong><%= memberName %>
            </strong> 님 안녕하세요.
            <a href="<%=request.getContextPath()%>/lec5/logout">로그아웃</a>
        </p>
    </div>
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>번호</th>
            <th>내용</th>
            <th>작성자</th>
            <th>작성시간</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<FreeBoardEntity> freeBoards = (List<FreeBoardEntity>) request.getAttribute("freeBoards");
            for (FreeBoardEntity freeBoard : freeBoards) {
        %>
        <tr>
            <td><%= freeBoard.getId() %>
            </td>
            <td><%= freeBoard.getContent() %>
            </td>
            <td><%= freeBoard.getWriterId() %>
            </td>
            <td><%= freeBoard.getWriteDate() %>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <button type="button" class="btn btn-primary"
            onclick="location.href='<%=request.getContextPath()%>/lec5/freeBoardWriteForm.html'">글쓰기
    </button>
</div>

</body>
</html>