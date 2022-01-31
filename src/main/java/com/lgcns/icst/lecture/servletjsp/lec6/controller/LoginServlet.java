package com.lgcns.icst.lecture.servletjsp.lec6.controller;

import com.lgcns.icst.lecture.servletjsp.lec6.model.biz.MemberBiz;
import com.lgcns.icst.lecture.servletjsp.lec6.constant.SessionKey;
import com.lgcns.icst.lecture.servletjsp.lec6.model.dto.MemberDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginServlet-lec6", urlPatterns = "/lec6/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/lec6/loginForm.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memberId = req.getParameter("memberId");
        String password = req.getParameter("password");

        MemberBiz memberBiz = new MemberBiz();
        try {
            MemberDTO member = memberBiz.login(memberId, password);

            HttpSession session = req.getSession();
            session.setAttribute(SessionKey.MEMBER_NAME, member.getMemberName());
            session.setAttribute(SessionKey.MEMBER_ID, member.getMemberId());

            resp.sendRedirect(req.getContextPath() + "/lec6/free-board-list");

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/lec6/errorPage.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
