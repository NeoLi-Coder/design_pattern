package 结构型.桥接模式.奶茶例子;

public class KissTea extends RefinedAbstractTea{   // 创建一个啵啵芋圆奶茶的子类
    protected KissTea(Size size) {   // 在构造时需要指定具体的大小实现
        super(size);
    }

    @Override
    public String getType() {
        return "啵啵芋圆奶茶";   // 返回奶茶类型
    }
    
}
