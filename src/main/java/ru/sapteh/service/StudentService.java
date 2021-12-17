package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Group;
import ru.sapteh.model.Student;

import javax.persistence.Query;
import java.util.List;

public class StudentService implements Dao<Student,Integer> {
    private final SessionFactory factory;

    public StudentService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Student findById(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Student.class,id);
        }
    }

    @Override
    public List<Student> findAll() {
        try(Session session = factory.openSession()) {
            return session.createQuery("from Student",Student.class).list();
        }
    }

    @Override
    public void save(Student student) {
        try(Session session = factory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }
    }

    @Override
    public void update(Student student) {
        try(Session session = factory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        }
    }

    @Override
    public void delete(Student student) {
        try(Session session = factory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
        }
    }


}

