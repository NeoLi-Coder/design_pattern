package 结构型.桥接模式.奶茶例子;

public abstract class RefinedAbstractTea extends AbstractTea {
    protected RefinedAbstractTea(Size size) {
        super(size);
    }
    
    public String getSize() {   // 添加尺寸维度获取方式
        return size.getSize();
    }
}
