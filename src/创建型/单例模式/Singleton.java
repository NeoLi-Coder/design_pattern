package 创建型.单例模式;

// 饿汉单例模式
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();   // 在一开始先不进行对象创建
    
    // 将构造方法设置为私有，不允许new对象
    private Singleton() {
    }
    
    public static Singleton getInstance() {   // 获取全局唯一的单例对象
        return INSTANCE;
    }
}


/**
 * @Description
 *      懒汉模式写法1
 *          缺点 线程不安全
 * @Author Ligp
 * @Date 2023/11/28
 */
class Singleton1 {
    private static Singleton1 INSTANCE;   // 在一开始先不进行对象创建
    
    private Singleton1() {
    }   // 不用多说了吧
    
    public static Singleton1 getInstance() {   // 将对象的创建延后到需要时再进行
        if (INSTANCE == null) {    // 如果实例为空，那么就进行创建，不为空说明已经创建过了，那么就直接返回
            INSTANCE = new Singleton1();
        }
        return INSTANCE;
    }
}

/**
 * @Description
 *      懒汉模式写法2
 *          缺点: 方法添加synchronized，执行效率低
 * @Author Ligp
 * @Date 2023/11/28
 */
class Singleton2 {
    private static Singleton2 INSTANCE;   // 在一开始先不进行对象创建
    
    private Singleton2() {
    }   // 不用多说了吧
    
    // 方法必须添加synchronized关键字加锁
    public static synchronized Singleton2 getInstance() {   // 将对象的创建延后到需要时再进行
        if (INSTANCE == null) {    // 如果实例为空，那么就进行创建，不为空说明已经创建过了，那么就直接返回
            INSTANCE = new Singleton2();
        }
        return INSTANCE;
    }
}

/**
 * @Description
 *      懒汉模式写法3
 *          缺点: 仍然存在多个线程同时判断为null进入线程等待
 * @Author Ligp
 * @Date 2023/11/28
 */
class Singleton3 {
    private static Singleton3 INSTANCE;   // 在一开始先不进行对象创建
    
    private Singleton3() {
    }   // 不用多说了吧
    
    // 方法必须添加synchronized关键字加锁
    public static Singleton3 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton3.class) {
                INSTANCE = new Singleton3();
            }
        }
        return INSTANCE;
    }
}

/**
 * @Description
 *      懒汉模式写法4
 *          缺点: 虽然实现了多线程安全，但是写法过于复杂，代码量多
 * @Author Ligp
 * @Date 2023/11/28
 */
class Singleton4 {
    private static volatile Singleton4 INSTANCE;   // 在一开始先不进行对象创建
    
    private Singleton4() {
    }   // 不用多说了吧
    
    // 方法必须添加synchronized关键字加锁
    public static Singleton4 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton4.class) {
                if (INSTANCE == null) INSTANCE = new Singleton4(); // 创建前再判断一下是否有实例
            }
        }
        return INSTANCE;
    }
    
    public static void main(String[] args) {
        Singleton4 instance = Singleton4.getInstance();
        Singleton4 instance1 = new Singleton4();
        System.out.println(instance);
    }
}


/**
 * @Description
 *      最完美的懒汉式解决方案，没有加锁操作，也能保证
 *
 * @Author Ligp
 * @Date 2023/11/29
 */
class Singleton5 {
    private Singleton5() {
    }
    
    // 由静态内部类持有单例对象，但是根据类加载特性，我们仅使用Singleton类时，不会对静态内部类进行初始化
    private static class Holder {
        private static Singleton5 INSTANCE = new Singleton5();
    }
    
    private Singleton5 getInstance() {// 只有真正使用内部类时，才会进行类初始化
        return Holder.INSTANCE;// 直接获取内部类中的
    }
}
