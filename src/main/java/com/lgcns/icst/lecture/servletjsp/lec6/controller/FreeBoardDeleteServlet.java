package com.lgcns.icst.lecture.servletjsp.lec6.controller;

import com.lgcns.icst.lecture.servletjsp.lec6.model.biz.FreeBoardBiz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "freeBoardDeleteServlet-lec6", urlPatterns = "/lec6/free-board-delete")
public class FreeBoardDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        FreeBoardBiz freeBoardBiz = new FreeBoardBiz();
        try {
            freeBoardBiz.delete(Long.parseLong(id));

            resp.sendRedirect(req.getContextPath() + "/lec6/free-board-list");

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/lec6/errorPage.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
