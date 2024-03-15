package bitlab.techorda.g1.studentgrades.db;

import bitlab.techorda.g1.studentgrades.model.Student;

import java.util.ArrayList;

public class DBManager {

    public static ArrayList<Student> studentList = new ArrayList<>();
    private static Long id = 3L;

    static {
        studentList.add(new Student(1L, "Albina", "Karamatdin", 90, "A"));
        studentList.add(new Student(2L, "Ivan", "Ivanov", 89, "B"));
    }

    //getAllStudents();

    public static ArrayList<Student> getAllStudents(){
        return studentList;
    }

    //addStudent(Student student);

    public static void addStudent(Student student){
        student.setId(id);
        studentList.add(student);
        id++;
        if (student.getExam()>60 && student.getExam()<74){
            student.setMark("C");
        } else if (student.getExam()>90) {
            student.setMark("A");
        } else if (student.getExam()>75 && student.getExam()<89){
            student.setMark("B");
        }else if (student.getExam()>50 && student.getExam()<59){
            student.setMark("D");
        }else {
            student.setMark("F");
        }
    }
}
