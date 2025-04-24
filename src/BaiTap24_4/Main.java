package BaiTap24_4;

import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String toString() {
        return name + " - " + score;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Nhập số lượng học sinh: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Học sinh " + (i + 1) + ":");
            System.out.print("  Tên: ");
            String name = scanner.nextLine();
            System.out.print("  Điểm: ");
            int score = Integer.parseInt(scanner.nextLine());
            students.add(new Student(name, score));
        }

        Optional<Student> topStudent = students.stream()
                .max(Comparator.comparingInt(Student::getScore));
        topStudent.ifPresent(s -> System.out.println("\nBài 1 - Học sinh điểm cao nhất: " + s));

        double average = students.stream()
                .mapToInt(Student::getScore)
                .average()
                .orElse(0.0);
        System.out.println("Bài 2 - Điểm trung bình: " + average);

        Map<String, List<Student>> grouped = students.stream()
                .collect(Collectors.groupingBy(s -> s.getScore() >= 50 ? "Pass" : "Fall"));

        System.out.println("Bài 3 - Nhóm Pass:");
        grouped.getOrDefault("Pass", Collections.emptyList()).forEach(System.out::println);

        System.out.println("Bài 3 - Nhóm Fall:");
        grouped.getOrDefault("Fall", Collections.emptyList()).forEach(System.out::println);
    }
}

