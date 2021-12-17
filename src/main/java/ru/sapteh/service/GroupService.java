package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Group;
import ru.sapteh.model.Student;

import java.util.List;

public class GroupService implements Dao<Group,Integer> {
    private final SessionFactory factory;

    public GroupService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Group findById(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Group.class,id);
        }
    }

    @Override
    public List<Group> findAll() {
        try(Session session = factory.openSession()) {
            return session.createQuery("from Group",Group.class).list();
        }
    }

    @Override
    public void save(Group group) {
        try(Session session = factory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.save(group);
            transaction.commit();
        }
    }

    @Override
    public void update(Group group) {
        try(Session session = factory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.update(group);
            transaction.commit();
        }
    }

    @Override
    public void delete(Group group) {
        try(Session session = factory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.delete(group);
            transaction.commit();
        }
    }

}
