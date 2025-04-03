package BaiTap;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class XMLReader {
    public static void readXML(String filePath) throws Exception {
        File file = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        doc.getDocumentElement().normalize();

        System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
        NodeList nodeList = doc.getElementsByTagName("employee");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("ID: " + element.getAttribute("id"));
                System.out.println("Name: " + element.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Role: " + element.getElementsByTagName("role").item(0).getTextContent());
            }
        }
    }
}



