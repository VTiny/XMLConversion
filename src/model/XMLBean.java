package model;

import util.StringUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: liuxiao
 * Created: 2017/10/3 09:50
 * Description: XMLBean，应当将.csv文件转化此数据结构，通过此结构生成xml文件
 */
public class XMLBean {

    private String name;
    private List<XMLBean> elementList;
    private List<XMLAttribute> attributeList;
    private String content;

    public XMLBean(String name) {
        this.name = StringUtil.removeBlank(StringUtil.removeBracket(name));
        this.elementList = new LinkedList<>();
        this.attributeList = new LinkedList<>();
        this.content = "";
    }

    public XMLBean(String name, String content) {
        this(name);
        this.content = content;
    }

    public void addElement(XMLBean bean) {
        elementList.add(bean);
    }

    public void addAttribute(XMLAttribute attribute) {
        attributeList.add(attribute);
    }

    public String getName() {
        return name;
    }

    public List<XMLBean> getElementList() {
        return elementList;
    }

    public List<XMLAttribute> getAttributeList() {
        return attributeList;
    }

    public String getContent() {
        return content;
    }

    public class XMLAttribute {
        private String name;
        private String content;

        public XMLAttribute(String name, String content) {
            this.name = name;
            this.content = content;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }


}
