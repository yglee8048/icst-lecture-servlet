package com.lgcns.icst.lecture.servletjsp.lec3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "freeBoardServlet", urlPatterns = "/lec3/free-board")
public class FreeBoardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FreeBoardServlet.doGet");

        // 게시글 조회
        List<FreeBoard> freeBoards = FreeBoardData.findAll();
        req.setAttribute("freeBoards", freeBoards);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lec3/freeBoard.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FreeBoardServlet.doPost");

        String title = req.getParameter("title");
        System.out.println("title = " + title);
        String content = req.getParameter("content");
        System.out.println("content = " + content);
        String createdBy = req.getParameter("createdBy");
        System.out.println("createdBy = " + createdBy);

        // 게시글 추가
        FreeBoardData.addData(title, content, createdBy);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lec3/addComplete.jsp");
        requestDispatcher.forward(req, resp);
    }
}
