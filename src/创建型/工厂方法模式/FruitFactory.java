package 创建型.工厂方法模式;

public abstract class FruitFactory<T extends Fruit> {
    public abstract T getFruit(String type);
}

