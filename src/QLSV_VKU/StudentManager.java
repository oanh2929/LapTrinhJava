package QLSV_VKU;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String studentID, String name, int age, double gpa, String className) {
        Student student = new Student(studentID, name, age, gpa, className);
        students.add(student);
        System.out.println("Đã thêm sinh viên: " + student);
    }

    public void removeStudent(String studentID) {
        students.removeIf(student -> student.getStudentID().equals(studentID));
        System.out.println("Đã xóa sinh viên có ID: " + studentID);
    }

    public void showStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void showStudentsByClass(String className) {
        System.out.println("\nDanh sách sinh viên lớp " + className + ":");
        for (Student student : students) {
            if (student.getClassName().equalsIgnoreCase(className)) {
                System.out.println(student);
            }
        }
    }
}
