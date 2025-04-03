package QLSV_VKU;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        System.out.print("Nhập email để đăng nhập: ");
        String emailInput = scanner.nextLine();
        if (!emailInput.endsWith("@vku.udn.vn")) {
            System.out.println("Email không hợp lệ!");
            return;
        }

        System.out.println("Đăng nhập thành công! Chào mừng đến với hệ thống quản lý sinh viên VKU.");

        while (true) {
            System.out.println("\nChọn chức năng:");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Xóa sinh viên");
            System.out.println("3. Hiển thị danh sách sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên theo lớp");
            System.out.println("5. Đăng xuất");
            System.out.print("Nhập lựa chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập tuổi: ");
                    int age = scanner.nextInt();
                    System.out.print("Nhập GPA: ");
                    double gpa = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ dòng trống
                    System.out.print("Nhập tên lớp học: ");
                    String className = scanner.nextLine();
                    manager.addStudent(id, name, age, gpa, className);
                    break;
                case 2:
                    System.out.print("Nhập ID sinh viên cần xóa: ");
                    String removeID = scanner.nextLine();
                    manager.removeStudent(removeID);
                    break;
                case 3:
                    System.out.println("\nDanh sách sinh viên:");
                    manager.showStudents();
                    break;
                case 4:
                    System.out.print("Nhập tên lớp học: ");
                    String searchClass = scanner.nextLine();
                    manager.showStudentsByClass(searchClass);
                    break;
                case 5:
                    System.out.println("Đăng xuất thành công. Hẹn gặp lại!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
