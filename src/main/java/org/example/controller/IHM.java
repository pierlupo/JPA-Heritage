package org.example.controller;

import org.example.entity.Student;
import org.example.entity.Teacher;
import org.example.impl.StudentDAOImpl;
import org.example.impl.TeacherDAOImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class IHM {


        static Scanner scanner;
        String choice;
        private static TeacherDAOImpl teacherDAO;
        private static StudentDAOImpl studentDAO;
        public IHM() {
            scanner = new Scanner(System.in);
        }
        private static EntityManagerFactory entityManagerFactory;

        public void start() {
            entityManagerFactory = Persistence.createEntityManagerFactory("exo_jpa");
            teacherDAO = new TeacherDAOImpl(entityManagerFactory);
            studentDAO = new StudentDAOImpl(entityManagerFactory);
            do {
                menu();
                choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        addTeacher();
                        break;
                    case "2":
                        addStudent();
                        break;
                    case "0":
                        System.out.println("See you later, bye bye!");

                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }while (!choice.equals("0"));
            entityManagerFactory.close();
        }
        private void menu() {
            System.out.println("-------------------------------");
            System.out.println("TP HéritageJPA");
            System.out.println("-------------------------------");
            System.out.println("***************************************");
            System.out.println("Choose an option :");
            System.out.println("***************************************");
            System.out.println("1 - Teacher menu ");
            System.out.println("2 - Student menu ");
            System.out.println("0 - Quit ");
        }

    private void addTeacher() {
        System.out.println("Enter the teacher's lastname : ");
        String lastname = scanner.nextLine();
        System.out.println("Enter the teacher's firstname : ");
        String firstname = scanner.nextLine();
        System.out.println("Enter his subject : ");
        String subject = scanner.nextLine();
        Teacher teacher = new Teacher(lastname,firstname,subject);
        if(teacherDAO.addTeacher(teacher)){
            System.out.println("Teacher successfully added !");
        }else {
            System.out.println("Error while trying to add a teacher ");
        }
    }

    private void addStudent() {
        System.out.println("Enter the student's lastname : ");
        String lastname = scanner.nextLine();
        System.out.println("Enter the student's firstname : ");
        String firstname = scanner.nextLine();
        System.out.println("Enter his class : ");
        String room = scanner.nextLine();
        Student student = new Student(lastname,firstname,room);
        if(studentDAO.addStudent(student)){
            System.out.println("Student successfully added !");
        }else {
            System.out.println("Error while trying to add a student ");
        }
    }
}
