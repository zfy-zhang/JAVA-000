package org.geekbang.java.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/11/17
 * @Modify
 * @since
 */
@Configuration
@ConditionalOnClass(School.class)
@EnableConfigurationProperties(SchoolConfig.class)
@ConditionalOnProperty(prefix = "school", value = "enabled", havingValue = "true")
@PropertySource("classpath:application.properties")
public class SchoolAutoConfiguration {

    private final SchoolConfig schoolConfig;

    @Autowired
    public SchoolAutoConfiguration(SchoolConfig schoolConfig) {
        this.schoolConfig = schoolConfig;
    }

    @Bean(name = "mySchool")
    public School mySchool() {
        List<Integer> studentIds = schoolConfig.getStudentIds();
        List<String> studentNames = schoolConfig.getStudentNames();
        List<Integer> classIds = schoolConfig.getClassIds();
        List<String> classNames = schoolConfig.getClassNames();
        List<Map<String, Integer>> studentOfClass = schoolConfig.getStudentOfKlass();

        List<Student> students = new ArrayList<>(studentIds.size());

        for (int i=0; i<studentIds.size(); i++) {
            students.add(new Student(studentIds.get(i), studentNames.get(i)));
        }

        List<Klass> myClass = new ArrayList<>();
        for (int i=0; i<classIds.size(); i++) {
            myClass.add(new Klass(classIds.get(i), classNames.get(i)));
        }

        for (Map info: studentOfClass) {
            myClass.get((Integer) info.get("myClassId")).addStudent(students.get((Integer) info.get("studentId")));
        }

        System.out.println(studentIds.toString());
        System.out.println(studentNames.toString());
        System.out.println(classIds.toString());
        System.out.println(classNames.toString());
        System.out.println(studentOfClass.toString());

        return new School(myClass);
    }
}
