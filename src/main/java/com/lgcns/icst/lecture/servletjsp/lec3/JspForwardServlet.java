package com.lgcns.icst.lecture.servletjsp.lec3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "jspForwardServlet", urlPatterns = "/forward")
public class JspForwardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int savings = 1000000;
        long savingsAfter5years = savings * 5 * 12;
        System.out.println("savingsAfter5years = " + savingsAfter5years);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lec3/forwardJSP.jsp");
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet-jsp/lec3/forwardJSP.jsp");   // 404 에러 발생!
        requestDispatcher.forward(req, resp);
    }
}
