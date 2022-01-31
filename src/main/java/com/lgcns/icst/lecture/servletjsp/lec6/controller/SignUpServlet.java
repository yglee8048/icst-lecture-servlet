package com.lgcns.icst.lecture.servletjsp.lec6.controller;

import com.lgcns.icst.lecture.servletjsp.lec6.model.biz.MemberBiz;
import com.lgcns.icst.lecture.servletjsp.lec6.model.dto.MemberDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "signUpServlet-lec6", urlPatterns = "/lec6/sign-up")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/lec6/signUpForm.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memberId = req.getParameter("memberId");
        String password = req.getParameter("password");
        String memberName = req.getParameter("memberName");

        MemberBiz memberBiz = new MemberBiz();
        try {
            memberBiz.signUp(new MemberDTO(memberId, password, memberName));

            resp.sendRedirect(req.getContextPath() + "/lec6/login");

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/lec6/errorPage.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
