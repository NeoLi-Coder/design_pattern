package 结构型.桥接模式.奶茶例子;

public class Large implements Size {
    
    @Override
    public String getSize() {
        return "大杯";
    }
}
