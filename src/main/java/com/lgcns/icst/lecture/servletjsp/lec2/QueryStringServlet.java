package com.lgcns.icst.lecture.servletjsp.lec2;

import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "queryStringServlet", urlPatterns = "/query")
public class QueryStringServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println("name = " + name);
        String age = req.getParameter("age");
        System.out.println("age = " + age);
        int intAge = Integer.parseInt(age);
        System.out.println("intAge = " + intAge);

        resp.setContentType(MediaType.TEXT_HTML_VALUE);
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("Query String 사용하기");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("이름 = " + name + "<br/>");
        writer.println("나이 = " + age + "<br/>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
