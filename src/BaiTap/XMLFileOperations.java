package BaiTap;

import java.util.Scanner;


public class XMLFileOperations {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String filePath = "company.xml";

        System.out.println("Choose an operation: 1 - Write XML, 2 - Read XML, 3 - Delete Node");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                XMLWriter.writeXML(filePath);
                break;
            case 2:
                XMLReader.readXML(filePath);
                break;
            case 3:
                System.out.print("Enter tag name to delete: ");
                String tagName = scanner.nextLine();
                XMLDeleter.deleteNode(filePath, tagName);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}

