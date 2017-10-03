package util;

import model.CSVObject;
import model.XMLBean;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Author: liuxiao
 * Created: 2017/10/2 16:52
 * Description:
 */
public class XMLUtil {

    public static void writeToFile(CSVObject csvObject, String path) {
        if (csvObject == null || path == null || path.length() == 0) {
            return;
        }
        writeToFile(parseToXML(csvObject), new File(path));
    }

    public static void writeToFile(XMLBean bean, String path) {
        if (bean == null || path == null || path.length() == 0) {
            return;
        }
        writeToFile(parseToXML(bean), new File(path));
    }

    private static Document parseToXML(XMLBean rootBean) {
        Document document = DocumentHelper.createDocument();
        Element rootElement = document.addElement(rootBean.getName());
        translateToElement(rootElement, rootBean);
        return document;
    }

    private static void translateToElement(Element element, XMLBean bean) {
        if (bean.getElementList().size() == 0) {
            element.setText(bean.getContent());
            return;
        }
        for (XMLBean.XMLAttribute attr : bean.getAttributeList()) {
            element.addAttribute(attr.getName(), attr.getContent());
        }
        for (XMLBean childBean : bean.getElementList()) {
            Element childElement = element.addElement(childBean.getName());
            translateToElement(childElement, childBean);
        }
    }

    private static Document parseToXML(CSVObject csvObject) {
        Document document = DocumentHelper.createDocument();
        Element rootElement = document.addElement("root");

        List<String> headerList = csvObject.getHeaderList();
        List<List<String>> dataList = csvObject.getDataList();
        int id = 0;
        for (List<String> data : dataList) {
            Element cellElement = rootElement.addElement("element");
            cellElement.addAttribute("id", id++ + "");
            for (int i = 0, length = headerList.size(); i < length; i++) {
                Element element = cellElement.addElement(headerList.get(i));
                element.setText(data.get(i));
            }
        }
        return document;
    }

    public static void writeToFile(CSVObject csvObject, File file) {
        writeToFile(parseToXML(csvObject), file);
    }

    private static void writeToFile(Document doc, File file) {
        if (file == null) {
            return;
        }
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        XMLWriter writer;
        try {
            writer = new XMLWriter(new FileOutputStream(file), format);
            writer.write(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}