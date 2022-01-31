package com.lgcns.icst.lecture.servletjsp.lec6.controller;

import com.lgcns.icst.lecture.servletjsp.lec6.model.biz.FreeBoardBiz;
import com.lgcns.icst.lecture.servletjsp.lec6.constant.SessionKey;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "freeBoardWriteServlet-lec6", urlPatterns = "/lec6/free-board-write")
public class FreeBoardWriteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/lec6/freeBoardWriteForm.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = req.getParameter("content");

        HttpSession session = req.getSession();
        String memberName = (String) session.getAttribute(SessionKey.MEMBER_NAME);

        FreeBoardBiz freeBoardBiz = new FreeBoardBiz();
        try {
            freeBoardBiz.save(content, memberName);

            resp.sendRedirect(req.getContextPath() + "/lec6/free-board-list");

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/lec6/errorPage.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
