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


@WebServlet(name = "AdminServlet", value = "/welcomeAdmin")
public class AdminServlet extends HttpServlet {
    JdbcUserDao userDao;
    JdbcRoleDao roleDao;
    String roleName = "admin";

    @Override
    public void init() {
        userDao = (JdbcUserDao) getServletContext().getAttribute("userDao");
        roleDao = (JdbcRoleDao) getServletContext().getAttribute("roleDao");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("usersList", userDao.findAll());
        request.getSession().setAttribute("roleName", roleDao.findByName(roleName));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/admin-page.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
