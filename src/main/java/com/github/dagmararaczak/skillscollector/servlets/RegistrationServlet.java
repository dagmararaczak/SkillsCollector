package com.github.dagmararaczak.skillscollector.servlets;

import com.github.dagmararaczak.skillscollector.model.dao.UserDao;
import com.github.dagmararaczak.skillscollector.model.entities.User;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String password = req.getParameter("password");
        User user = new User();

        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);

        Boolean usernameAvailable = userDao.isUsernameAvailable(username);

        if (!usernameAvailable){
            req.setAttribute("errorMessage", "Nazwa uzytkownika " + username + " jest juz zajeta");
            req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req,resp);
        } else{
            userDao.save(user);
            resp.sendRedirect("/login");
        }
    }

    @Override
    public void init() throws ServletException {
        SessionFactory sessionFactory =(SessionFactory) getServletContext().getAttribute("session_factory");
            userDao = new UserDao(sessionFactory);

    }
}
