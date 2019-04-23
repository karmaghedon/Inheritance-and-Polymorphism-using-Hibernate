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
import pojo.Student;
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

    public int insertEmployee(String name, String address, String phone, String email) {
        try {
            Transaction transacrtion = session.beginTransaction();
            try {
                Employee employee = new Employee();
                employee.setName(name.substring(1,name.length()-1));
                employee.setAddress(address.substring(1,address.length()-1));
                employee.setPhone(phone.substring(1,phone.length()-1));
                employee.setEmail(email.substring(1,email.length()-1));
                session.save(employee);

                transacrtion.commit();
                return employee.getId();
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
