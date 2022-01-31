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

@WebServlet(name = "loginServletV5", urlPatterns = "/lec5/login-v5")
public class LoginServletV5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lec5/loginFormV5.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        MemberDataAccess memberDataAccess = new MemberDataAccess();
        MemberEntity member = memberDataAccess.findMemberByIdAndPassword(username, password);

        String forwardUrl;
        if (member != null) {
            HttpSession session = req.getSession();
            session.setAttribute(SessionKey.MEMBER_NAME, member.getMemberName());

            FreeBoardDataAccess freeBoardDataAccess = new FreeBoardDataAccess();
            List<FreeBoardEntity> freeBoards = freeBoardDataAccess.findAllFreeBoards();
            req.setAttribute("freeBoards", freeBoards);
            forwardUrl = "/lec5/freeBoardListSession.jsp";
        } else {
            forwardUrl = "/lec5/errorPage.jsp";
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(forwardUrl);
        requestDispatcher.forward(req, resp);
    }
}
