package util;

import model.CSVObject;
import model.XMLBean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Author: liuxiao
 * Created: 2017/10/2 17:56
 * Description: .csv格式文件工具类，主要用于把.csv格式文件转化为相应的Bean数据类型
 */
public class CSVUtil {
    /**
     * 将.csv格式文件转化为XMLBean
     * @param file
     * @return
     */
    public static XMLBean parseToXMLBeanFromCSVFile(File file) {
        if (!file.exists()) {
            throw new RuntimeException("No such file.");
        }
        XMLBean bean = new XMLBean(StringUtil.removeSuffix(file.getPath()));
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String s;
            s = reader.readLine();
            String[] headerArr = ArrayUtil.removeBlankString(s.split(","));
            while ((s = reader.readLine()) != null) {
                String[] contentArr = ArrayUtil.removeBlankString(s.split(","));
                bean.addElement(parseDataToXMLBean(headerArr, contentArr, "Bean"));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static XMLBean parseToXMLBeanFromCSVFile(String path) {
        if (StringUtil.isEmpty(path)) {
            return null;
        }
        return parseToXMLBeanFromCSVFile(new File(path));
    }

    @Deprecated
    public static CSVObject parseFromFile(File file) {
        if (!file.exists()) {
            throw new RuntimeException("No such file.");
        }
        CSVObject csvObject = new CSVObject();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String s = null;
            s = reader.readLine();
            s = s.substring(0, s.length() - 2);
            csvObject.setHeaderList(Arrays.asList(s.split(",")));
            while ((s = reader.readLine()) != null) {
                s = s.substring(0, s.length() - 2);
                csvObject.addData(Arrays.asList(s.split(",")));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvObject;
    }

    public static void addElementToXMLBean(XMLBean bean, String[] headerArr, String[] contentArr) {
        for (int i = 0, len = contentArr.length; i < len; i++) {
            bean.addElement(new XMLBean(headerArr[i], contentArr[i]));
        }
    }

    /**
     * 将.csv文件的数据行转化为bean
     * @param headerArr
     * @param contentArr
     * @param name
     * @return
     */
    private static XMLBean parseDataToXMLBean(String[] headerArr, String[] contentArr, String name) {
        XMLBean xmlBean = new XMLBean(name);
        for (int i = 0, len = contentArr.length; i < len; i++) {
            xmlBean.addElement(new XMLBean(headerArr[i], contentArr[i]));
        }
        return xmlBean;
    }

}