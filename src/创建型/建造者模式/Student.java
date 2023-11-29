package 创建型.建造者模式;

import java.util.List;

public class Student {
    int id;
    int age;
    int grade;
    String name;
    String college;
    String profession;
    List<String> awards;
    
    public Student(int id, int age, int grade, String name, String college, String profession, List<String> awards) {
        this.id = id;
        this.age = age;
        this.grade = grade;
        this.name = name;
        this.college = college;
        this.profession = profession;
        this.awards = awards;
    }
    
    public static StudentBuilder builder() {   // 通过builder方法直接获取建造者
        return new StudentBuilder();
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", grade=" + grade +
                ", name='" + name + '\'' +
                ", college='" + college + '\'' +
                ", profession='" + profession + '\'' +
                ", awards=" + awards +
                '}';
    }
    
}
