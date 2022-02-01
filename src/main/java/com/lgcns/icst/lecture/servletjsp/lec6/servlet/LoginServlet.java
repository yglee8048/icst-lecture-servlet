package com.lgcns.icst.lecture.servletjsp.lec6.servlet;

import com.lgcns.icst.lecture.servletjsp.lec6.MemberDataAccess;
import com.lgcns.icst.lecture.servletjsp.lec6.constant.SessionKey;
import com.lgcns.icst.lecture.servletjsp.lec6.model.entity.MemberEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/lec6/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lec6/loginForm.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        MemberDataAccess memberDataAccess = new MemberDataAccess();
        MemberEntity member = memberDataAccess.findMemberByIdAndPassword(username, password);

        if (member != null) {
            HttpSession session = req.getSession();
            session.setAttribute(SessionKey.MEMBER_NAME, member.getMemberName());

            resp.sendRedirect(req.getContextPath() + "/lec6/free-board");
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lec6/errorPage.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
