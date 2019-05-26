package com.github.dagmararaczak.skillscollector.model.dao;

import com.github.dagmararaczak.skillscollector.model.entities.Skill;
import org.hibernate.SessionFactory;
import java.util.List;

public class SkillDao extends BaseDao {

    public SkillDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Skill get(Long id) {
        return super.produceInTransaction(session -> session.get(Skill.class, id));
    }

    public void save(Skill skill) {
        super.executeInTransaction(session -> session.save(skill));
    }

    public void update(Skill skill) {
        super.executeInTransaction(session -> session.update(skill));
    }

    public void delete(Skill skill) {
        super.executeInTransaction(session -> session.delete(skill));
    }

    public Boolean isSkillnameAvailable(String skillname) {
        return super.produceInTransaction(
                session -> session.createQuery("SELECT count(s) FROM Skill s WHERE s.skillname = :skillname", Long.class)
                        .setParameter("skillname", skillname)
                        .getSingleResult() <= 0
        );
    }

    public List<Skill> getAll() {
        return super.produceInTransaction(
                session -> session.createQuery("SELECT s FROM Skill s", Skill.class)
                        .getResultList());
    }

    public List<Skill> getAllBySkillname(String skillname) {
        return super.produceInTransaction(
                session -> session.createQuery("SELECT s FROM Skill s WHERE s.skillname = :skillname", Skill.class)
                        .setParameter("skillname", skillname)
                        .getResultList());
    }

}
