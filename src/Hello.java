import model.XMLBean;
import util.CSVUtil;
import util.XMLUtil;

import java.io.File;

/**
 * Author: liuxiao
 * Created: 2017/10/2 20:36
 * Description: 入口，仿照main方法进行通过csv文件生成xml文件的操作
 */
public class Hello {

    public static void main(String[] args) {
        XMLBean xmlObject = CSVUtil.parseToXMLBeanFromCSVFile(new File("data1.csv"));
        XMLUtil.writeToFile(xmlObject,"out/res.xml");

    }
}
