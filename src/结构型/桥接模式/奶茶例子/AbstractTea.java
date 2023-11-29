package 结构型.桥接模式.奶茶例子;

public abstract class AbstractTea {
    
    protected Size size;   // 尺寸作为桥接属性存放在类中
    
    protected AbstractTea(Size size){   // 在构造时需要知道尺寸属性
        this.size = size;
    }
    
    public abstract String getType();   // 具体类型依然是由子类决定
}
