package QLSV_VKU;

public class Student {
    private String studentID;
    private String name;
    private int age;
    private String email;
    private double gpa;
    private String className;

    public Student(String studentID, String name, int age, double gpa, String className) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.className = className;
        this.email = generateEmail(name);
    }

    public  String getStudentID(){
        return studentID;
    }

    private String generateEmail(String name) {
        String normalized = name.toLowerCase().replaceAll(" ", "");
        return normalized + "@vku.edu.vn";
    }

    public String getClassName() { return className; }

    @Override
    public String toString() {
        return studentID + " - " + name + " - " + age + " tuổi - " + email + " - GPA: " + gpa + " - Lớp: " + className;
    }
}
