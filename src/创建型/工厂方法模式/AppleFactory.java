package 创建型.工厂方法模式;

public class AppleFactory extends FruitFactory {
    @Override
    public Apple getFruit(String type) {
        return new Apple();
    }
}
