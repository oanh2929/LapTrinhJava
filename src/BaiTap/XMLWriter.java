package BaiTap;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class XMLWriter {
    public static void writeXML(String filePath) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Employee Name: ");
        String nameInput = scanner.nextLine();
        System.out.print("Enter Employee Role: ");
        String roleInput = scanner.nextLine();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element rootElement = doc.createElement("company");
        doc.appendChild(rootElement);

        Element employee = doc.createElement("employee");
        employee.setAttribute("id", id);
        rootElement.appendChild(employee);

        Element name = doc.createElement("name");
        name.appendChild(doc.createTextNode(nameInput));
        employee.appendChild(name);

        Element role = doc.createElement("role");
        role.appendChild(doc.createTextNode(roleInput));
        employee.appendChild(role);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource domSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult(new File(filePath));
        transformer.transform(domSource, streamResult);

        System.out.println("XML file written successfully.");
    }
}
