package com.github.dagmararaczak.skillscollector.model.dao;


import com.github.dagmararaczak.skillscollector.model.entities.Skill;
import com.github.dagmararaczak.skillscollector.model.entities.Source;
import com.github.dagmararaczak.skillscollector.model.entities.User;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao {

    public UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public User get(Long id) {
        return super.produceInTransaction(session -> session.get(User.class, id));
    }

    public void save(User user) {
        super.executeInTransaction(session -> session.save(user));
    }

    public void update(User user) {
        super.executeInTransaction(session -> session.update(user));
    }

    public void delete(User user) {
        super.executeInTransaction(session -> session.delete(user));
    }

    public Boolean isUsernameAvailable(String username) {
        return super.produceInTransaction(
                session -> session.createQuery("SELECT count(u) FROM User u WHERE u.username = :username", Long.class)
                        .setParameter("username", username)
                        .getSingleResult() <= 0
        );
    }

    public List<User> getAll() {
        return super.produceInTransaction(
                session -> session.createQuery("SELECT u FROM User u", User.class)
                        .getResultList());
    }

    public List<User> getAllByUsername(String username) {
        return super.produceInTransaction(
                session -> session.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                        .setParameter("username", username)
                        .getResultList());
    }

    public List<User> getAllByUsernameAndPassword(String username, String password) {
        return super.produceInTransaction(
                session -> session.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class)
                        .setParameter("username", username)
                        .setParameter("password", password)
                        .getResultList());
    }

    public  List<Skill> getAllUserSkills(String username){
        User user = getAllByUsername(username).get(0);
        List<Skill> userSkillsList = new ArrayList<>();
        for(Source source : user.getKnownSources()){
            userSkillsList.addAll(source.getAttachedSkills());
        }

        return userSkillsList;
    }


    public List<Source> getAllUserSources(String username){
        return super.produceInTransaction(
                session -> session.createQuery("select s from Source s\n " +
                        "inner join users_known_sources uks on so.id = uks.source_id\n" +
                        "inner join users u on uks.user_id = u.id\n" +
                        "Where u.username = :username",Source.class)
                        .setParameter("username",username)
                .getResultList());

    }

   public List<Skill> getSkills(User user){
      return  super.produceInTransaction(
                session -> session.createQuery("Select s\n" +
                        "From Skill s\n" +
                        "Inner Join sources_attached_skills as sas on s.id = sas.skill_id\n" +
                        "Inner Join Source so on sas.source_id = so.id\n" +
                        "Inner Join users_known_sources uks on so.id = uks.source_id\n" +
                        "Inner Join users u on uks.user_id = u.id\n" +
                        "Where u.username = :username", Skill.class)
                        .setParameter("username",user.getUsername())
                .getResultList());

    }
}
