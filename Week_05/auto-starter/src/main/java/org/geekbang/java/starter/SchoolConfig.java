package org.geekbang.java.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/11/17
 * @Modify
 * @since
 */
@ConfigurationProperties(prefix = "school")
public class SchoolConfig {

    private List<Integer> studentIds;
    private List<String> studentNames;
    private List<Integer> classIds;
    private List<String> classNames;
    private List<Map<String, Integer>> studentOfKlass;

    public List<Integer> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<Integer> studentIds) {
        this.studentIds = studentIds;
    }

    public List<String> getStudentNames() {
        return studentNames;
    }

    public void setStudentNames(List<String> studentNames) {
        this.studentNames = studentNames;
    }

    public List<Integer> getClassIds() {
        return classIds;
    }

    public void setClassIds(List<Integer> classIds) {
        this.classIds = classIds;
    }

    public List<String> getClassNames() {
        return classNames;
    }

    public void setClassNames(List<String> classNames) {
        this.classNames = classNames;
    }

    public List<Map<String, Integer>> getStudentOfKlass() {
        return studentOfKlass;
    }

    public void setStudentOfKlass(List<Map<String, Integer>> studentOfKlass) {
        this.studentOfKlass = studentOfKlass;
    }
}
