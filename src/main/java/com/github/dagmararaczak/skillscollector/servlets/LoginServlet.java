package com.github.dagmararaczak.skillscollector.servlets;

import com.github.dagmararaczak.skillscollector.model.dao.UserDao;
import com.github.dagmararaczak.skillscollector.model.entities.User;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        SessionFactory sessionFactory =(SessionFactory) req.getServletContext().getAttribute("session_factory");

        UserDao userDao = new UserDao(sessionFactory);
        List<User> users = userDao.getAllByUsernameAndPassword(username, password);

        if (users.size() == 1){
            User user = users.get(0);
            HttpSession session = req.getSession();
            session.invalidate();
            session = req.getSession(true);
            session.setAttribute("user",user);
            resp.sendRedirect("/user/skills");
        } else{
            req.setAttribute("error","bledne dane logowania");
        }



    }
}
