/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Closeable;
import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Student;
import util.HibernateUtil;

/**
 *
 * @author nicolaenastas
 */
public class StudentDao implements Closeable {

    private Session session;

    public StudentDao() {

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        if (!session.isOpen()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
    }

    public int insertStudent(String name, String address, String phone, String email) {
        try {
            Transaction transacrtion = session.beginTransaction();
            try {
                Student student = new Student();
                student.setName(name);
                student.setAddress(address);
                student.setPhone(phone);
                student.setEmail(email);
                session.save(student);

                transacrtion.commit();

                return student.getId();
            } catch (Exception e) {
                transacrtion.rollback();
                throw e;
            }
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void deleteStudent(Integer id) {
        try {
            Transaction transacrtion = session.beginTransaction();
            try {
                Student student = (Student) session.load(Student.class, id);
                session.delete(student);

                transacrtion.commit();

            } catch (Exception e) {
                transacrtion.rollback();
                throw e;
            }
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void editStudent(Integer id, String name) {
        try {
            Transaction transacrtion = session.beginTransaction();
            try {
                Student student = (Student) session.load(Student.class, id);
                student.setName(name);

                transacrtion.commit();
            } catch (Exception e) {
                transacrtion.rollback();
                throw e;
            }
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public Student findById(Integer id) {
        try {
            Transaction transacrtion = session.beginTransaction();
            try {
                Student student = (Student) session.get(Student.class, id);

                transacrtion.commit();

                return student;
            } catch (Exception e) {
                transacrtion.rollback();
                throw e;
            }
        } finally {
            HibernateUtil.closeSession();
        }
    }

    @Override
    public void close() throws IOException {

    }
}
