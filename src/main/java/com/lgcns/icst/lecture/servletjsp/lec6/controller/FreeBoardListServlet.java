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
import java.util.List;

@WebServlet(name = "freeBoardListServlet-lec6", urlPatterns = "/lec6/free-board-list")
public class FreeBoardListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FreeBoardBiz freeBoardBiz = new FreeBoardBiz();
        try {
            List<FreeBoardDTO> freeBoards = freeBoardBiz.findAll();
            req.setAttribute("freeBoards", freeBoards);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/lec6/freeBoardList.jsp");
            requestDispatcher.forward(req, resp);

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/lec6/errorPage.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
