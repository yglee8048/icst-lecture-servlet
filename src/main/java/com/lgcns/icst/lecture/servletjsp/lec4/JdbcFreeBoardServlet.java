package com.lgcns.icst.lecture.servletjsp.lec4;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "jdbcFreeBoardServlet-lec4", urlPatterns = "/lec4/free-board-jdbc")
public class JdbcFreeBoardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 게시글 조회
        FreeBoardDataAccess freeBoardDataAccess = new FreeBoardDataAccess();
        List<FreeBoardEntity> freeBoards = freeBoardDataAccess.findAllFreeBoards();

        // 데이터 보관
        req.setAttribute("freeBoards", freeBoards);

        // forward
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lec4/freeBoardList.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = req.getParameter("content");
        String writerId = req.getParameter("writerId");

        FreeBoardDataAccess freeBoardDataAccess = new FreeBoardDataAccess();
        boolean success = freeBoardDataAccess.insertFreeBoard(content, writerId);

        String url;
        if (success) {
            url = "/lec4/writeSuccess.jsp";
        } else {
            url = "/lec4/errorPage.jsp";
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(url);
        requestDispatcher.forward(req, resp);
    }
}
