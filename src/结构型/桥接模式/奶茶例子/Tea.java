package 结构型.桥接模式.奶茶例子;

public interface Tea {   // 由具体类型的奶茶实现
    String getType();   // 不同的奶茶返回的类型不同
}
