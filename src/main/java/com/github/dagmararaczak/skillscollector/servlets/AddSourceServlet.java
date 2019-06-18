package com.github.dagmararaczak.skillscollector.servlets;

import com.github.dagmararaczak.skillscollector.model.dao.SourceDao;
import com.github.dagmararaczak.skillscollector.model.dao.UserDao;
import com.github.dagmararaczak.skillscollector.model.entities.Source;
import com.github.dagmararaczak.skillscollector.model.entities.User;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns ="user/add-source")
public class AddSourceServlet extends HttpServlet {

/*    SourceDao sourceDao;
    UserDao userDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String description = req.getParameter("description");

        Source source = new Source();

        sourceDao.save(source);

        User user = (User) req.getSession().getAttribute("user");
        userDao.getAllUserSources(user.getUsername()).add(source);
        userDao.getAllByUsername(user.getUsername()).get(0).getUnknownSources().add(source);

        resp.sendRedirect("/user/unknown-sources");


    }

    @Override
    public void init() throws ServletException {

        SessionFactory sessionFactory =(SessionFactory) getServletContext().getAttribute("session_factory");

        sourceDao = new SourceDao(sessionFactory);
        userDao = new UserDao(sessionFactory);

    }*/
}
