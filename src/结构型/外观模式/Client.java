package 结构型.外观模式;

/***
 * 外观模式（Facade Pattern）是一种结构型设计模式，它提供了一个统一的接口，用于访问子系统中的一群接口。外观模式定义了一个高层接口，使得子系统更容易使用。
 *
 * 生活中的例子：
 * 想象一下你使用计算机的情景。对于用户来说，使用计算机可能是一个相对简单的过程，他们只需打开电源，启动应用程序，进行操作即可。
 * 然而，在计算机内部，有很多复杂的子系统，比如CPU、内存、硬盘、操作系统等。这些子系统的操作可能相对繁琐。
 *
 * 在外观模式中，用户通过计算机外观（例如，计算机的电源按钮、桌面图标等）来访问计算机的各个子系统，而无需了解底层的复杂操作。
 */

// 子系统A
class SubsystemA {
    void operationA() {
        System.out.println("Subsystem A - Operation A");
    }
}

// 子系统B
class SubsystemB {
    void operationB() {
        System.out.println("Subsystem B - Operation B");
    }
}

// 子系统C
class SubsystemC {
    void operationC() {
        System.out.println("Subsystem C - Operation C");
    }
}

// 外观类
class Facade {
    private SubsystemA subsystemA;
    private SubsystemB subsystemB;
    private SubsystemC subsystemC;
    
    public Facade() {
        this.subsystemA = new SubsystemA();
        this.subsystemB = new SubsystemB();
        this.subsystemC = new SubsystemC();
    }
    
    // 提供简化的接口，封装了子系统的复杂操作
    void operate() {
        subsystemA.operationA();
        subsystemB.operationB();
        subsystemC.operationC();
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        // 使用外观类来操作子系统
        Facade facade = new Facade();
        facade.operate();
    }
}
