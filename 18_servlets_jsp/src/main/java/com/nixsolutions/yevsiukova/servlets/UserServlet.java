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


@WebServlet(name = "UserServlet", value = "/welcomeUser")
public class UserServlet extends HttpServlet {
    JdbcUserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = (JdbcUserDao) getServletContext().getAttribute("userDao");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = "user";
        request.getSession().setAttribute("firstName", userDao.findByLogin(login).getFirstName());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/user-page.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}

