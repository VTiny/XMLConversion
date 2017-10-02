package util;

import model.CSVObject;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.List;

/**
 * Author: liuxiao
 * Created: 2017/10/2 16:52
 * Description:
 */
public class XMLUtil {

    public static Document parse2XML(Object object) {
//        Class clazz = object.getClass();
//        clazz.get
        return null;
    }

    public static void write2File(CSVObject csvObject, String path) {
        writeToFile(parse2XML(csvObject), path);
    }

    private static Document parse2XML(CSVObject csvObject) {
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

    private static void writeToFile(Document doc, String path) {
        if (path == null || path.length() == 0) {
            return;
        }
        writeToFile(doc, new File(path));
    }

    private static void writeToFile(Document doc, File file) {
        if (file == null) {
            return;
        }
        OutputFormat format = OutputFormat.createPrettyPrint();
        //设置输出编码
        format.setEncoding("UTF-8");
        //创建需要写入的File对象
        //生成XMLWriter对象，构造函数中的参数为需要输出的文件流和格式
        XMLWriter writer = null;
        try {
            writer = new XMLWriter(new FileOutputStream(file), format);
            //开始写入，write方法中包含上面创建的Document对象
            writer.write(doc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}