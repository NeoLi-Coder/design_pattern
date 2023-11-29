package 结构型.代理模式;

/***
 * 假设你是一名秘书，你的老板需要给客户发一封邮件。然而，由于老板非常忙，他让你负责处理这件事情。在代理模式中，你就是老板的代理。
 *
 * 你可以负责处理邮件的发送，确保邮件格式正确、附件齐全，甚至可以在发送前进行一些检查
 */
// 主题接口
interface RealSubject {
    void sendEmail();
}

// 具体主题，真正的邮件发送者
class RealEmailSender implements RealSubject {
    @Override
    public void sendEmail() {
        System.out.println("Sending email...");
    }
}

// 代理类，秘书
class SecretaryProxy implements RealSubject {
    private RealSubject realSubject;
    
    public SecretaryProxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }
    
    @Override
    public void sendEmail() {
        // 在发送邮件前，可以添加一些额外的逻辑，比如权限检查、格式验证等
        System.out.println("Secretary is checking the email...");
        realSubject.sendEmail();
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        // 创建真正的邮件发送者
        RealSubject realEmailSender = new RealEmailSender();
        
        // 创建代理，即秘书
        SecretaryProxy secretary = new SecretaryProxy(realEmailSender);
        
        // 通过代理发送邮件
        secretary.sendEmail();
    }
}
