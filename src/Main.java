import 创建型.工厂方法模式.AppleFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println(new AppleFactory().getFruit("苹果"));
    }
}
