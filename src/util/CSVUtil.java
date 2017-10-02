package util;

import model.CSVObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Author: liuxiao
 * Created: 2017/10/2 17:56
 * Description:
 */
public class CSVUtil {

    public static CSVObject parseFromFile(File file) {
        if (!file.exists()) {
            throw new RuntimeException("No such file.");
        }
        StringBuilder sb = new StringBuilder();
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

}