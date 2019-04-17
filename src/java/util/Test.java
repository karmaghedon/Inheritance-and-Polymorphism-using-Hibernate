/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.EmployeeDao;
import dao.StudentDao;

import java.io.IOException;

/**
 *
 * @author nicolaenastas
 */
public class Test {

    public static void main(String[] args) throws IOException {

        try (StudentDao student = new StudentDao();) {
            student.insertStudent("Alex", "Here", "IPhone", "Yahoo");
  //          student.deleteStudent(5);
            //student.editStudent(7, "Jora");
//            Student st = student.findById(7);
//            System.out.print(st.toString());
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }

        try (EmployeeDao employee = new EmployeeDao();) {
            employee.insertEmployee("Nick", "there", "Android", "gmail");
 //           employee.deleteEmployee(6);
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
//
//        StudentDao student = new StudentDao();
//        EmployeeDao employee = new EmployeeDao();
//    student.deleteStudent(1);
//    employee.deleteEmployee(2);

        //student.editStudent(1, "Jora");
    }
}
