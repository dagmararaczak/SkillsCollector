package com.github.dagmararaczak.skillscollector.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Set;

import com.github.dagmararaczak.skillscollector.model.dao.SourceDao;
import com.github.dagmararaczak.skillscollector.model.dao.UserDao;
import com.github.dagmararaczak.skillscollector.model.entities.Source;
import com.github.dagmararaczak.skillscollector.model.entities.User;
import org.hibernate.SessionFactory;

@WebServlet(urlPatterns = "/user/add-source")
public class AddSourceServlet extends HttpServlet {

    private SourceDao sourceDao;
    private UserDao userDao;



    @Override
    @Transactional
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");

        sourceDao.save(new Source(name,description));

        User user =(User) req.getSession().getAttribute("user");

        Set<Source> unknownSources =(Set<Source>) req.getSession().getAttribute("unknownSources");


        unknownSources.add(new Source(name,description));


        resp.sendRedirect("/user/unknown-sources");

    }

    @Override
    public void init() throws ServletException {

        SessionFactory sessionFactory =(SessionFactory) getServletContext().getAttribute("session_factory");

        sourceDao = new SourceDao(sessionFactory);
        userDao = new UserDao(sessionFactory);

    }
}
