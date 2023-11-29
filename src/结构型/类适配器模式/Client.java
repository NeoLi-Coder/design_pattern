package 结构型.类适配器模式;

/***
 * 假设你有一台笔记本电脑，但只有一个 USB 接口，而你有两个设备：一个是老式的 PS/2 鼠标，另一个是现代的 USB 鼠标。你希望能够在笔记本电脑上使用这两种鼠标，但是它们的接口不同。
 *
 * 这时候，你可以使用一个 USB 到 PS/2 的适配器，让这两种不同接口的鼠标都能够连接到你的笔记本电脑上。这个适配器会将 PS/2 接口转换成 USB 接口，使得笔记本电脑可以通过 USB 接口来使用 PS/2 鼠标。
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

// 适配器类，继承自需要适配的类，同时实现目标接口
class PS2ToUSBAdapter extends PS2Mouse implements USBMouse {
    @Override
    public void connectUSB() {
        connectPS2();
        System.out.println("PS/2 to USB adapter connected.");
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        // 使用 USB 鼠标
        USBMouse usbMouse = new PS2ToUSBAdapter();
        usbMouse.connectUSB();
    }
}
