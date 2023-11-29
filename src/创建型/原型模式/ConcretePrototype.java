package 创建型.原型模式;

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
