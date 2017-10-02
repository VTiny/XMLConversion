import model.CSVObject;
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
        CSVObject csvObject = CSVUtil.parseFromFile(new File("data1.csv"));
        XMLUtil.write2File(csvObject, "result1.xml");
    }
}
