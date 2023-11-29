package 创建型.原型模式;

public class Client {
    public static void main(String[] args) {
        ConcretePrototype prototype = new ConcretePrototype(10);
        ConcretePrototype clonedObject = (ConcretePrototype) prototype.clone();
        
        System.out.println("Original Object Value: " + prototype.getValue()); // 输出: Original Object Value: 10
        System.out.println("Cloned Object Value: " + clonedObject.getValue()); // 输出: Cloned Object Value: 10
    }
}
