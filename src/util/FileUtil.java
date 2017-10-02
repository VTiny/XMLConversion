package util;

import java.io.*;

/**
 * @Description
 * @Author liuxiao
 * @Date 2017/4/19
 */
public class FileUtil {


    public static StringBuilder readFromFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException("No such file.");
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = reader.readLine()) != null) {
                sb.append(s);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    public static StringBuilder readFromFile(File file) {
        if (!file.exists()) {
            throw new RuntimeException("No such file.");
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = reader.readLine()) != null) {
                sb.append(s);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    public static void writeToFile(String path, String content) {
        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(File file, String content) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
