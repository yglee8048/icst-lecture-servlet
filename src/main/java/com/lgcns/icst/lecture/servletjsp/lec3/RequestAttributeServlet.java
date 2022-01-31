package com.lgcns.icst.lecture.servletjsp.lec3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestAttributeServlet", urlPatterns = "/attribute")
public class RequestAttributeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int savings = 1000000;
        long savingsAfter5years = savings * 5 * 12;
        System.out.println("savingsAfter5years = " + savingsAfter5years);

        req.setAttribute("savingsAfter5years", savingsAfter5years); // set (key, value)
        long getAttribute = (long) req.getAttribute("savingsAfter5years");  // object 로 저장됨
        System.out.println("getAttribute = " + getAttribute);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lec3/forwardAttribute.jsp");
        requestDispatcher.forward(req, resp);
    }
}
