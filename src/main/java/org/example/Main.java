package org.example;

import org.example.entities.Student;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {


        Student student1 = new Student();
        student1.setName("Alex");
        student1.setEmail("alex@mj.com");

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.addStudent(student1);

        List<Student> students = studentDAO.getAllStudents();
        for (Student student : students) {
            LOGGER.info(student.getName() + " - " + student.getEmail());
        }

        Student studentToDelete = studentDAO.getStudentById(1);
        studentDAO.deleteStudent(studentToDelete);
    }
}
