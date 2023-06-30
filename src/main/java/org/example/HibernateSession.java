package org.example;

import org.example.entities.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



class HibernateSession {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            configuration.addAnnotatedClass(Student.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}

