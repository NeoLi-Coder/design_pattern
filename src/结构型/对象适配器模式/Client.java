package 结构型.对象适配器模式;

/***
 * 假设你有一台笔记本电脑，只有一个 USB 接口，而你有两个设备：一个是老式的 PS/2 鼠标，另一个是现代的 USB 鼠标。你希望能够在笔记本电脑上使用这两种鼠标，但是它们的接口不同。
 *
 * 这时候，你可以使用一个 USB 到 PS/2 的适配器，让这两种不同接口的鼠标都能够连接到你的笔记本电脑上。
 * 这个适配器不再继承 PS/2 鼠标类，而是持有一个 PS/2 鼠标的实例，并实现 USB 接口。
 * 这样，适配器内部通过组合的方式调用 PS/2 鼠标的方法，使得笔记本电脑可以通过 USB 接口来使用 PS/2 鼠标。
 */
// 目标接口
interface USBMouse {
    void connectUSB();
}

// 需要适配的类（PS/2 鼠标）
class PS2Mouse {
    void connectPS2() {
        System.out.println("PS/2 mouse connected.");
    }
}

// 对象适配器类，实现目标接口并持有需要适配的类的实例
class PS2ToUSBAdapter implements USBMouse {
    private PS2Mouse ps2Mouse;
    
    public PS2ToUSBAdapter(PS2Mouse ps2Mouse) {
        this.ps2Mouse = ps2Mouse;
    }
    
    @Override
    public void connectUSB() {
        ps2Mouse.connectPS2();
        System.out.println("PS/2 to USB adapter connected.");
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        // 使用 USB 鼠标
        USBMouse usbMouse = new PS2ToUSBAdapter(new PS2Mouse());
        usbMouse.connectUSB();
    }
}
