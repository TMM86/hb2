package com.athlone.jpa.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestHibernate {
    private SessionFactory sessionFactory;

    private Session session = null;

    @Before

    public void before() {

        // setup the session factory

        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(User.class);

        configuration.setProperty("hibernate.hbm2ddl.auto", "create");

        sessionFactory = configuration.buildSessionFactory();

        session = sessionFactory.openSession();

    }


    @Test
    public void returnsHerosWithMatchingType() {
        // create the objects needed for testing

        User tiago = new User();
        tiago.setName("Tiago");
        tiago.setSurname("Moreira");
        User filip = new User();
        filip.setName("Filip");
        filip.setSurname("Mamic");
        User krishna = new User();
        krishna.setName("Krishna");
        krishna.setSurname("Kokkula");

        session.beginTransaction();
        session.save(tiago);
        session.save(filip);
        session.save(krishna);
        session.getTransaction().commit();

        session.beginTransaction();
        List result = session.createQuery( "from User" ).list();
        for ( User user : (List<User>) result ) {
            System.out.println( "User: " + user.getName() + " " + user.getSurname());
        }
        session.getTransaction().commit();

    }


    @After
    public void after() {

        session.close();

        sessionFactory.close();

    }

    /*
    @Test
    public void test1() throws Exception {
        fail();
    }*/

}