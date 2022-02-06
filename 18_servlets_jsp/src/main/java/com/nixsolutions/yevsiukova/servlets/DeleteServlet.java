package com.nixsolutions.yevsiukova.servlets;

import com.nixsolutions.yevsiukova.servlets.jdbc.dao.dml.JdbcRoleDao;
import com.nixsolutions.yevsiukova.servlets.jdbc.dao.dml.JdbcUserDao;
import com.nixsolutions.yevsiukova.servlets.jdbc.entity.UserEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "DeleteServlet", value = "/delete")
public class DeleteServlet extends HttpServlet {
    JdbcUserDao userDao;

    @Override
    public void init() {
        userDao = (JdbcUserDao) getServletContext().getAttribute("userDao");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserEntity deletedUser = userDao.findByLogin(request.getParameter("login"));
        userDao.remove(deletedUser);
        response.sendRedirect("/welcomeAdmin");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
