package 创建型.建造者模式;

public class test {
    public static void main(String[] args) {
        Student student = Student.builder()   // 获取建造者
                .id(1)    // 逐步配置各个参数
                .age(18)
                .grade(3)
                .name("小明")
                .awards("ICPC-ACM 区域赛 金牌", "LPL 2022春季赛 冠军")
                .build();   //
        System.out.println(student.toString());
    }
}
