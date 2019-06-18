package com.github.dagmararaczak.skillscollector.model.dao;

import com.github.dagmararaczak.skillscollector.model.entities.Source;

import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SourceDao extends BaseDao {
    public SourceDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Source get(Long id) {
        return super.produceInTransaction(session -> session.get(Source.class, id));
    }

    public void save(Source source) {
        super.executeInTransaction(session -> session.save(source));
    }

    public void update(Source source) {
        super.executeInTransaction(session -> session.update(source));
    }

    public void delete(Source source) {
        super.executeInTransaction(session -> session.delete(source));
    }

    public Boolean isUsernameAvailable(String sourcename) {
        return super.produceInTransaction(
                session -> session.createQuery("SELECT count(s) FROM Source s WHERE s.sourcename = :sourcename", Long.class)
                        .setParameter("sourcename", sourcename)
                        .getSingleResult() <= 0
        );
    }

    public List<Source> getAll() {
        return super.produceInTransaction(
                session -> session.createQuery("SELECT s FROM Source s", Source.class)
                        .getResultList());
    }

    public List<Source> getAllBySourcename(String sourcename) {
        return super.produceInTransaction(
                session -> session.createQuery("SELECT s FROM Source s WHERE s.sourcename = :sourcename", Source.class)
                        .setParameter("sourcename", sourcename)
                        .getResultList());
    }

    public Set<Source> getAllByUsername(String username) {
        return super.produceInTransaction(
                session -> session
                        .createQuery("SELECT DISTINCT source FROM User u JOIN u.knownSources source JOIN FETCH source.attachedSkills skill WHERE u.username = :username", Source.class)
                        .setParameter("username", username)
                        .getResultList().stream().collect(Collectors.toSet()));
    }

    public Set<Source> getAllUnknownSourcesByUsername(String username) {
        return super.produceInTransaction(
                session -> session
                        .createQuery("SELECT DISTINCT source FROM User u JOIN u.unknownSources source JOIN FETCH source.attachedSkills skill WHERE u.username = :username", Source.class)
                        .setParameter("username", username)
                        .getResultList().stream().collect(Collectors.toSet()));
    }




}
