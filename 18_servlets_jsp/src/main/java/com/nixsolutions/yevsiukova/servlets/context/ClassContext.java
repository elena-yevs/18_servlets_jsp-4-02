package com.nixsolutions.yevsiukova.servlets.context;

import com.nixsolutions.yevsiukova.servlets.jdbc.dao.dml.JdbcRoleDao;
import com.nixsolutions.yevsiukova.servlets.jdbc.dao.dml.JdbcUserDao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ClassContext implements ServletContextListener {
    @Override
    public void contextInitialized(javax.servlet.ServletContextEvent sce) {
        JdbcUserDao userDao = new JdbcUserDao();
        JdbcRoleDao roleDao = new JdbcRoleDao();
        sce.getServletContext().setAttribute("roleDao", roleDao);
        sce.getServletContext().setAttribute("userDao", userDao);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
