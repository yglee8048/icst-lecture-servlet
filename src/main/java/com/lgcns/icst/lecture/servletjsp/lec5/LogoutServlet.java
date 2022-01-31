package com.lgcns.icst.lecture.servletjsp.lec5;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "logoutServlet", urlPatterns = "/lec5/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // session 로그아웃 하기
        HttpSession session = req.getSession();
        session.invalidate();
        System.out.println("로그 아웃!");

        // cookie 로그아웃 하기
        Cookie cookie = new Cookie("memberName", null);
        cookie.setMaxAge(0);
        resp.addCookie(cookie);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lec5/logout.html");
        requestDispatcher.forward(req, resp);
    }
}
