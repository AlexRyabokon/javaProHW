package org.example;

import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class StudentDAO {
    public void addStudent(Student student) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }
    }

    public void updateStudent(Student student) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        }
    }

    public void deleteStudent(Student student) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
        }
    }

    public List<Student> getAllStudents() {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        }
    }

    public Student getStudentById(int id) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            return session.get(Student.class, id);
        }
    }
}

