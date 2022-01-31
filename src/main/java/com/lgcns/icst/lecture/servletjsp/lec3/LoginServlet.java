package com.lgcns.icst.lecture.servletjsp.lec3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lec3/loginFormSession.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forwardURL;

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username.equals("홍길동") && password.equals("12345")) {
            forwardURL = "/lec3/loginSuccessCookie.jsp";

            req.setAttribute("username", username);
            req.setAttribute("password", password);

        } else {
            forwardURL = "/lec3/errorPage.html";
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(forwardURL);
        requestDispatcher.forward(req, resp);
    }
}
