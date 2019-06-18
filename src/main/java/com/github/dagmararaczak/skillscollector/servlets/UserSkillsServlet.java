package com.github.dagmararaczak.skillscollector.servlets;

import com.github.dagmararaczak.skillscollector.model.dao.UserDao;
import com.github.dagmararaczak.skillscollector.model.entities.Skill;
import com.github.dagmararaczak.skillscollector.model.entities.User;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(urlPatterns = "/user/skills")
public class UserSkillsServlet extends HttpServlet {

    UserDao userDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user =(User) req.getSession().getAttribute("user");

       req.setAttribute("skills", getUserSkills(user));

       req.getRequestDispatcher("/WEB-INF/views/user-skills.jsp").forward(req,resp);



    }

/*
    private Map<Skill,Integer> getUserSkills(User user) {
        List<Skill> allUserSkills = userDao.getSkills(user);
        Map<Skill,Integer> userSkills = new HashMap<>();

        for (Skill skill : allUserSkills){

            if(!userSkills.containsKey(skill)){
                userSkills.put(skill,1);
            }else if(userSkills.containsKey(skill)){
                int skillscount = userSkills.get(skill);
                skillscount++;
                userSkills.put(skill,skillscount);


            }

        }

        return userSkills;
    }*/



    @Override
    public void init() throws ServletException {

        SessionFactory sessionFactory =(SessionFactory) getServletContext().getAttribute("session_factory");

        userDao = new UserDao(sessionFactory);

    }

    private Map<Skill,Integer> getUserSkills(User user) {
        List<Skill> allUserSkills = userDao.getAllUserSkills(user.getUsername());
        Map<Skill,Integer> userSkills = new TreeMap<>();

        for (Skill skill : allUserSkills){

            if(!userSkills.containsKey(skill)){
                userSkills.put(skill,0);
            }else{
                int skillscount = userSkills.get(skill);
                skillscount++;
                userSkills.put(skill,skillscount);

            }

        }

        return userSkills;
    }
}
