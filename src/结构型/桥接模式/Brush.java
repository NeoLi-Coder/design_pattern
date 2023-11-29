package 结构型.桥接模式;

// 抽象类：画笔
abstract class Brush {
    // 画画的方法，需要传入一个颜色的实例
    public abstract void draw(Color color);
}

// 实现类：铅笔
class Pencil extends Brush {
    @Override
    public void draw(Color color) {
        System.out.println("Using pencil with " + color.name + " color to draw.");
    }
}

// 实现类：钢笔
class Pen extends Brush {
    @Override
    public void draw(Color color) {
        System.out.println("Using pen with " + color.name + " color to draw.");
    }
}

// 实现类：毛笔
class InkBrush extends Brush {
    @Override
    public void draw(Color color) {
        System.out.println("Using ink brush with " + color.name + " color to draw.");
    }
}

// 抽象类：颜色
abstract class Color {
    // 颜色的名字
    protected String name;

    // 获取颜色的名字
    public String getName() {
        return name;
    }
}

// 实现类：红色
class Red extends Color {
    public Red() {
        name = "red";
    }
}

// 实现类：绿色
class Green extends Color {
    public Green() {
        name = "green";
    }
}

// 实现类：蓝色
class Blue extends Color {
    public Blue() {
        name = "blue";
    }
}

// 桥接类：桥接模式的核心，用来关联画笔和颜色
class Bridge {
    public static void main(String[] args) {
        // 创建一个铅笔的实例
        Brush pencil = new Pencil();
        // 创建一个钢笔的实例
        Brush pen = new Pen();
        // 创建一个毛笔的实例
        Brush inkBrush = new InkBrush();
        // 创建一个红色的实例
        Color red = new Red();
        // 创建一个绿色的实例
        Color green = new Green();
        // 创建一个蓝色的实例
        Color blue = new Blue();
        // 使用铅笔和红色画画
        pencil.draw(red);
        // 使用钢笔和绿色画画
        pen.draw(green);
        // 使用毛笔和蓝色画画
        inkBrush.draw(blue);
    }
}
