package 创建型.工厂方法模式;

public abstract class Fruit {
    private final String name;
    
    
    protected Fruit(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name + "@" + hashCode();   // 打印一下当前水果名称，还有对象的hashCode
    }
}
