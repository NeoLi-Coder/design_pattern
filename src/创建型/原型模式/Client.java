package 创建型.原型模式;

interface Prototype {
    Prototype clone();
}

class ConcretePrototype implements Prototype {
    private int value;
    
    public ConcretePrototype(int value) {
        this.value = value;
    }
    
    @Override
    public Prototype clone() {
        return new ConcretePrototype(this.value);
    }
    
    public int getValue() {
        return this.value;
    }
}

public class Client {
    public static void main(String[] args) {
        ConcretePrototype prototype = new ConcretePrototype(10);
        ConcretePrototype clonedObject = (ConcretePrototype) prototype.clone();
        
        System.out.println("Original Object Value: " + prototype.getValue()); // 输出: Original Object Value: 10
        System.out.println("Cloned Object Value: " + clonedObject.getValue()); // 输出: Cloned Object Value: 10
    }
}
