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

@WebServlet(name = "htmlServlet", urlPatterns = "/html")
public class HtmlServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setHeader("Content-Type", "text/html;charset=utf-8");
        resp.setContentType(MediaType.TEXT_HTML_VALUE); // resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name()); // resp.setCharacterEncoding("utf-8");

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>HTML 응답</head>");
        writer.println("<body>");
        writer.println("<b>Hello Servlet!</b>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
