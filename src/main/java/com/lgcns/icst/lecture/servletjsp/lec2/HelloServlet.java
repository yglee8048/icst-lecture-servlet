package com.lgcns.icst.lecture.servletjsp.lec2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL = " + requestURL);
        String requestURI = req.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        PrintWriter writer = resp.getWriter();
        writer.println("Hello Servlet!");
    }
}
