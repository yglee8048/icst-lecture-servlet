package com.lgcns.icst.lecture.servletjsp.lec2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "postFormServlet", urlPatterns = "/form")
public class PostFormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        System.out.println("method = " + method);

        String contentType = req.getContentType();
        System.out.println("contentType = " + contentType);

        String name = req.getParameter("name");
        System.out.println("name = " + name);
        String age = req.getParameter("age");
        System.out.println("age = " + age);
    }
}
