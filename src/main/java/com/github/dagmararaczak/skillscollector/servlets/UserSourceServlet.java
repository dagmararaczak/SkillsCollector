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
import java.util.Set;

@WebServlet(urlPatterns = "/user/sources")
public class UserSourceServlet extends HttpServlet {

UserDao userDao;
SourceDao sourceDao;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user =(User) req.getSession().getAttribute("user");

        Set<Source> allByUsername = sourceDao.getAllByUsername(user.getUsername());

        req.getSession().setAttribute("sources",allByUsername);

        req.getRequestDispatcher("/WEB-INF/views/user-sources.jsp").forward(req,resp);
    }

    @Override
    public void init() throws ServletException {
        SessionFactory session =(SessionFactory) getServletContext().getAttribute("session_factory");
        userDao = new UserDao(session);
        sourceDao = new SourceDao(session);
    }
}
