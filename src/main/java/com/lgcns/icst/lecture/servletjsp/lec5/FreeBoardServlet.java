package com.lgcns.icst.lecture.servletjsp.lec5;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "freeBoardServlet-lec5", urlPatterns = "/lec5/free-board")
public class FreeBoardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FreeBoardDataAccess freeBoardDataAccess = new FreeBoardDataAccess();
        List<FreeBoardEntity> freeBoards = freeBoardDataAccess.findAllFreeBoards();

        req.setAttribute("freeBoards", freeBoards);

//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lec5/freeBoardListCookie.jsp");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lec5/freeBoardListSession.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String memberName = (String) session.getAttribute(SessionKey.MEMBER_NAME);
        if (memberName == null) {
            System.out.println("로그인 되지 않은 사용자");
            resp.sendRedirect(req.getContextPath() + "/lec5/login-v6");
            return;
        }

        String content = req.getParameter("content");

        FreeBoardDataAccess freeBoardDataAccess = new FreeBoardDataAccess();
        boolean result = freeBoardDataAccess.insertFreeBoard(content, memberName);

        if (result) {
            resp.sendRedirect(req.getContextPath() + "/lec5/free-board");
        } else {
            resp.sendRedirect(req.getContextPath() + "/lec5/errorPage.jsp");
        }
    }
}
