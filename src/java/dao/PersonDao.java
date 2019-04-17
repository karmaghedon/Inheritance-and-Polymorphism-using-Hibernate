/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import methods.ProcessResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.Transaction;
import pojo.Person;
import util.HibernateUtil;

/**
 *
 * @author nicolaenastas
 */
public class PersonDao {

    private Session session;

    public PersonDao() {
        try{
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        if (!session.isOpen()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        }catch(SessionException e){
            throw e;
        }
    }

    public List<Person> getAll() {
        try {
            Transaction transacrtion = session.beginTransaction();
            try {
                Query query = session.createQuery(
                        "SELECT a FROM Person a");
                List persons = query.list();

                return persons;
            } catch (Exception e) {
                transacrtion.rollback();
                throw e;
            }
        } finally {
            HibernateUtil.closeSession();
        }

    }

    public Person findById(Integer id) {
        try {
            Transaction transacrtion = session.beginTransaction();
            try {
                Person perosn = (Person) session.get(Person.class, id);

                transacrtion.commit();

                return perosn;
            } catch (Exception e) {
                transacrtion.rollback();
                throw e;
            }
        } finally {
            HibernateUtil.closeSession();
        }
    }

}
