package com.lgcns.icst.lecture.servletjsp.lec2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "methodTestServlet", urlPatterns = "/method")
public class MethodTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MethodTest.doGet");

        String method = req.getMethod();
        System.out.println("method = " + method);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MethodTest.service");

        String method = req.getMethod();
        System.out.println("method = " + method);
    }
}
