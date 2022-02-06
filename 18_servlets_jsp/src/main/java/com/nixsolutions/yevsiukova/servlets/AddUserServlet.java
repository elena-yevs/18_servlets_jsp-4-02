package com.nixsolutions.yevsiukova.servlets;

import com.nixsolutions.yevsiukova.servlets.jdbc.dao.dml.JdbcUserDao;
import com.nixsolutions.yevsiukova.servlets.jdbc.entity.UserEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "AddUserServlet", value = "/addUser")
public class AddUserServlet extends HttpServlet {
    JdbcUserDao userDao;
    UserEntity userEntity = new UserEntity();

    @Override
    public void init() {
        userDao = (JdbcUserDao) getServletContext().getAttribute("userDao");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/add-user.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        if (request.getParameter("role").equals("admin")) {
            userEntity.setRoleId(1L);
        } else {
            userEntity.setRoleId(2L);
        }
        //  userEntity.setRoleId(Long.valueOf(request.getParameter("role"))); //roleName
        userEntity.setLogin(request.getParameter("login"));
        userEntity.setPassword(request.getParameter("password"));
        userEntity.setEmail(request.getParameter("email"));
        userEntity.setFirstName(request.getParameter("firstname"));
        userEntity.setLastName(request.getParameter("lastname"));
        userEntity.setBirthday(java.sql.Date.valueOf(request.getParameter("birthday")));
        userDao.create(userEntity);
        response.sendRedirect("/welcomeAdmin");
    }


}
