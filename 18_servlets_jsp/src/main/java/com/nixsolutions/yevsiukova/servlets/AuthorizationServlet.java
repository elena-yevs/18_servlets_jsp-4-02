package com.nixsolutions.yevsiukova.servlets;

import com.nixsolutions.yevsiukova.servlets.jdbc.dao.dml.JdbcRoleDao;
import com.nixsolutions.yevsiukova.servlets.jdbc.dao.dml.JdbcUserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.Objects;


@WebServlet(name = "AuthorizationServlet", value = "/welcome")
public class AuthorizationServlet extends HttpServlet {
    JdbcUserDao userDao;
    JdbcRoleDao roleDao;

    @Override
    public void init() {
        userDao = (JdbcUserDao) getServletContext().getAttribute("userDao");
        roleDao = (JdbcRoleDao) getServletContext().getAttribute("roleDao");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/authorization.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminPassword = "admin";
        String userPassword = "user";
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        boolean isAuthorized = userDao.findByLogin(login) != null;

        if (isAuthorized && Objects.equals(password, adminPassword)) {
            request.getSession().setAttribute(login.trim(), password.trim());
            response.sendRedirect("/welcomeAdmin");
        } else if (isAuthorized && Objects.equals(password, userPassword)) {
            request.getSession().setAttribute(login.trim(), password.trim());
            response.sendRedirect("/welcomeUser");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/authorization.jsp");
            dispatcher.forward(request, response);
        }
    }
}


