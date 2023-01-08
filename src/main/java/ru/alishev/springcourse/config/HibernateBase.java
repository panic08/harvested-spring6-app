package ru.alishev.springcourse.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.alishev.springcourse.models.Person;

public class HibernateBase {
    public static void main(String[] args) {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.configure();


        try (SessionFactory sessionFactory = configuration.buildSessionFactory();


             Session session = sessionFactory.openSession()) {
                session.beginTransaction();
            System.out.println("OK");
            Person person = Person.builder()
                    .id(13)
                    .name("Tommi")
                    .build();
            session.save(person);

            session.getTransaction().commit();
        }

    }
}
