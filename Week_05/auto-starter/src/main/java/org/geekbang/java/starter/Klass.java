package org.geekbang.java.starter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/11/17
 * @Modify
 * @since
 */
public class Klass {

    private int id;
    private String name;
    private List<Student> studentList = new ArrayList<>();

    public Klass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }


    @Override
    public String toString() {
        return "Klass{" +
                "studentList=" + studentList .toString()+
                '}';
    }
}
