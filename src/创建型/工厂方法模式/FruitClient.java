package 创建型.工厂方法模式;

abstract class Fruit {
    private final String name;
    
    protected Fruit(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name + "@" + hashCode();   // 打印一下当前水果名称，还有对象的hashCode
    }
}

abstract class FruitFactory<T extends Fruit> {
    public abstract T getFruit(String type);
}

class Apple extends Fruit {
    protected Apple() {
        super("苹果");
    }
}

class AppleFactory extends FruitFactory {
    @Override
    public Apple getFruit(String type) {
        return new Apple();
    }
}

class Orange extends Fruit {
    protected Orange() {
        super("橘子");
    }
}

class OrangeFactory extends FruitFactory {
    @Override
    public Orange getFruit(String type) {
        return new Orange();
    }
}

// 客户端代码
public class FruitClient {
    public static void main(String[] args) {
        FruitFactory factory = new AppleFactory();
        Fruit fruit = factory.getFruit("苹果");
        System.out.println(fruit);
    }
}

