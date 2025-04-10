package BaiTap10_4;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLUtil {
    public static void xuatXML(List<User> danhSach, File file) throws Exception {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        DocumentBuilder b = f.newDocumentBuilder();
        Document doc = b.newDocument();

        Element goc = doc.createElement("nguoidung");
        doc.appendChild(goc);

        for (User u : danhSach) {
            Element userElem = doc.createElement("user");
            userElem.setAttribute("ten", u.getTenDangNhap());
            goc.appendChild(userElem);
        }

        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.transform(new DOMSource(doc), new StreamResult(file));
    }

    public static List<User> nhapXML(File file) throws Exception {
        List<User> danhSach = new ArrayList<>();

        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        DocumentBuilder b = f.newDocumentBuilder();
        Document doc = b.parse(file);

        NodeList ds = doc.getElementsByTagName("user");
        for (int i = 0; i < ds.getLength(); i++) {
            Element e = (Element) ds.item(i);
            String ten = e.getAttribute("ten");
            danhSach.add(new User(ten, ""));
        }

        return danhSach;
    }
}

