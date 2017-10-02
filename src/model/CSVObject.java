package model;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: liuxiao
 * Created: 2017/10/2 18:18
 * Description:
 */
public class CSVObject {

    private List<String> headerList;
    private List<List<String>> dataList;

    public CSVObject() {
        headerList = new LinkedList<>();
        dataList = new LinkedList<>();
    }

    public void setHeaderList(List<String> headerList) {
        this.headerList = headerList;
    }

    public void addData(List<String> data) {
        dataList.add(data);
    }

    public List<String> getHeaderList() {
        return headerList;
    }

    public List<List<String>> getDataList() {
        return dataList;
    }
}
