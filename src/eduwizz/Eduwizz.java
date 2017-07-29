/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eduwizz;

import java.util.*;

/**
 *
 * @author bhagirath
 */
public class Eduwizz {

    Scanner sc = new Scanner(System.in);
    String name;
    ArrayList<Course> cs = new ArrayList<Course>(1000);
    ArrayList<Student> student = new ArrayList<Student>(1000);
    /**
     * @param args the command line arguments
     */
    Eduwizz(String name) {
        this.name = name;
    }

    Course findCourse(String name) {

        for (int i = 0; i < cs.size(); i++) {
            if (name.equals(cs.get(i).name)) {
                return cs.get(i);
            }
        }
        return null;
    }

    Course getCourse() {

        System.out.println("Enter Course Name");
        String name = sc.next();
        Course cs = findCourse(name);
        if (cs == null) {
            System.out.println("Enter fees of Course  :");
            int fees = sc.nextInt();
            return new Course(name, fees);
        } else {
            System.out.println("Course Allready Available");
            return null;
        }
    }

    void addCourse(Course c) {
        cs.add(c);
    }

    Student findStudent(String name) {

        for (int i = 0; i < student.size(); i++) {
            if (name.equals(student.get(i).name)) {
                return student.get(i);
            }
        }
        return null;
    }

    Student getStudent() {

        System.out.println("Enter Student Name");
        String name = sc.next();
        Student sd = findStudent(name);
        if (sd == null) {
            
            return new Student(name);
        } else {
            System.out.println("This Student Allready Enroll");
            return null;
        }
    }

    void addStudent(Student st) {
        student.add(st);
    }
    
    void enrollStudent(){
        for(int i = 0 ; i < student.size() ; i++){
            System.out.print(i+" " ); 
               student.get(i).print();
        }
        System.out.println("Select id of Student");
        int id = sc.nextInt();
        if(id >= 0  && id < student.size()){
            while(true){
            System.out.println("Choose Course");
            String name = sc.next();
            Course cs = findCourse(name);
            if(cs != null){
               student.get(id).cs.add(cs);
            }
            else{
                System.out.println("Course Not Found");   
            }
            System.out.println("Enter 0 to Exit and Otherwise press any number to add course");
            int ch = sc.nextInt();
            if(ch == 0){
                break;
            }
        }
       } 
        else{
            System.out.println("Enter Correct id of Student");
        }    
    }
    void joinCourseOfStudent(){
        for(int i = 0 ; i < student.size() ; i++){
            System.out.print(i+" " ); 
               student.get(i).print();
        }
        System.out.println("Select id of Student");
        int id = sc.nextInt();
        if(id >= 0 && id < student.size() ){
            student.get(id).printCourse();
        } 
        else{
            System.out.println("En-valid id");
        }
    }
    void joinStudentOfCourse(){
        for(int i = 0 ; i < cs.size() ; i++){
            System.out.print(i+" " ); 
               cs.get(i).print();
        }
        System.out.println("Select Course id");
        int id = sc.nextInt();
        if(id >= 0 && id < cs.size() ){
            for(int i = 0 ; i < student.size() ; i++)
            student.get(i).printStudent(cs.get(id));
        } 
        else{
         System.out.println("En-valid Course id");        
        }
    
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Eduwizz ed = new Eduwizz("Eduwizz");
        Scanner sc = new Scanner(System.in);
        boolean input = true;
        while (input) {
            System.out.println("0. Exit");
            System.out.println("1. Add New Course");
            System.out.println("2. Add New Student");
            System.out.println("3. Enroll student in course");
            System.out.println("4. All courses taken by student");
            System.out.println("5. Print all students enrollrd in course");
            System.out.println("Enter Choice");
            int ch = sc.nextInt();
            switch (ch) {
                case 0: {
                    input = false;
                    break;
                }
                case 1: {
                    Course cs = ed.getCourse();
                    if (cs != null) {
                        ed.addCourse(cs);
                    }
                    break;
                }
                case 2: {
                    Student st = ed.getStudent();
                    if (st != null) {
                        ed.addStudent(st);
                    }
                    break;
                }
                case 3: {
                        ed.enrollStudent();
                    break;
                }
                case 4: {
                        ed.joinCourseOfStudent();
                    break;
                }
                case 5: {
                        ed.joinStudentOfCourse();
                    break;
                }
                default: {
                    System.out.println("4. Print b/w 0 to 5");
                }
            }
        }
    }
}
