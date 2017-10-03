import model.XMLBean;
import util.CSVUtil;
import util.XMLUtil;

import java.io.File;

/**
 * Author: liuxiao
 * Created: 2017/10/2 20:36
 * Description:
 */
public class Hello {

    public static void main(String[] args) {
//        CSVObject csvObject = CSVUtil.parseFromFile(new File("data1.csv"));
//        XMLUtil.writeToFile(csvObject, "result1.xml");
        XMLBean xmlObject = CSVUtil.parseToXMLBeanFromCSVFile(new File("data1.csv"));
        XMLUtil.writeToFile(xmlObject,"res.xml");

    }
}
