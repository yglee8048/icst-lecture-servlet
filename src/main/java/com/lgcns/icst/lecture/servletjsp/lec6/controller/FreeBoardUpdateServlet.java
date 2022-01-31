package com.lgcns.icst.lecture.servletjsp.lec6.controller;

import com.lgcns.icst.lecture.servletjsp.lec6.model.biz.FreeBoardBiz;
import com.lgcns.icst.lecture.servletjsp.lec6.model.dto.FreeBoardDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "freeBoardUpdateServlet-lec6", urlPatterns = "/lec6/free-board-update")
public class FreeBoardUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bNum = req.getParameter("bNum");

        FreeBoardBiz freeBoardBiz = new FreeBoardBiz();
        try {
            FreeBoardDTO freeBoard = freeBoardBiz.findByBNum(Integer.parseInt(bNum));
            req.setAttribute("freeBoard", freeBoard);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/lec6/freeBoardUpdateForm.jsp");
            requestDispatcher.forward(req, resp);

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/lec6/errorPage.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bNum = req.getParameter("bNum");
        String content = req.getParameter("content");

        FreeBoardBiz freeBoardBiz = new FreeBoardBiz();
        try {
            freeBoardBiz.update(Integer.parseInt(bNum), content);

            resp.sendRedirect(req.getContextPath() + "/lec6/free-board-list");

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/lec6/errorPage.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
