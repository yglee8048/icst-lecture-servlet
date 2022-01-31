package com.lgcns.icst.lecture.servletjsp.lec4;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "jdbcLoginServlet", urlPatterns = "/login-jdbc")
public class JdbcLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lec4/loginFormSession.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println("id = " + id);
        String password = req.getParameter("password");
        System.out.println("password = " + password);

        SelectMember selectMember = new SelectMember();
        MemberEntity memberEntity = selectMember.findMemberByIdAndPassword(id, password);
        if (memberEntity != null) {
            req.setAttribute("memberName", memberEntity.getMemberName());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lec4/loginSuccessCookie.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lec4/errorPage.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
