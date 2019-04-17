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
import pojo.Employee;
import util.HibernateUtil;

/**
 *
 * @author nicolaenastas
 */
public class EmployeeDao implements Closeable {

    private Session session;

    public EmployeeDao() {

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        if (!session.isOpen()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
    }

    public void insertEmployee(String name, String address, String phone, String email) {
        try {
            Transaction transacrtion = session.beginTransaction();
            try {
                Employee employee = new Employee();
                employee.setName(name);
                employee.setAddress(address);
                employee.setPhone(phone);
                employee.setEmail(email);
                session.save(employee);

                transacrtion.commit();
            } catch (Exception e) {
                transacrtion.rollback();
                throw e;
            }
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void deleteEmployee(Integer id) {
        try {
            Transaction transacrtion = session.beginTransaction();
            try {
                Employee employee = (Employee) session.load(Employee.class, id);
                session.delete(employee);

                transacrtion.commit();
            } catch (Exception e) {
                transacrtion.rollback();
                throw e;
            }
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void editEmployee(Integer id, String name) {
        try {
            Transaction transacrtion = session.beginTransaction();
            try {
                Employee employee = (Employee) session.load(Employee.class, id);
                employee.setName(name);

                transacrtion.commit();
            } catch (Exception e) {
                transacrtion.rollback();
                throw e;
            }
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public Employee findById(Integer id) {
        try {
            Transaction transacrtion = session.beginTransaction();
            try {
                Employee student = (Employee) session.get(Employee.class, id);

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
