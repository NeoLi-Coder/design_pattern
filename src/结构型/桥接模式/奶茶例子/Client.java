package 结构型.桥接模式.奶茶例子;

public class Client {
    public static void main(String[] args) {
        KissTea tea = new KissTea(new Large());
        System.out.println(tea.getType());
        System.out.println(tea.getSize());
    }
}
