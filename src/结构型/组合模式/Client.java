package 结构型.组合模式;

import java.util.ArrayList;
import java.util.List;

/***
 * 假设你在设计一个图形编辑器，你需要能够绘制不同形状的图形，包括简单的矩形和圆形，以及复杂的组合图形，比如矩形和圆形的组合。这时候，组合模式就可以派上用场。
 *
 * 你可以定义一个抽象类或接口 Shape，它包含一个绘制方法。然后，你可以创建具体的类，比如 Rectangle 和 Circle，它们都实现了 Shape 接口。
 * 接着，你可以创建一个组合类，比如 CompositeShape，它也实现了 Shape 接口，但内部包含了多个 Shape 对象，可以是简单的图形，也可以是组合图形。
 *
 */
// 抽象组件
interface Shape {
    void draw();
}

// 叶子节点，具体的图形类
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

// 组合节点，组合图形类
class CompositeShape implements Shape {
    private List<Shape> shapes = new ArrayList<>();
    
    // 添加图形
    public void addShape(Shape shape) {
        shapes.add(shape);
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing CompositeShape");
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        // 创建简单图形
        Shape rectangle = new Rectangle();
        Shape circle = new Circle();
        
        // 创建组合图形
        CompositeShape compositeShape = new CompositeShape();
        compositeShape.addShape(rectangle);
        compositeShape.addShape(circle);
        
        // 绘制图形
        rectangle.draw();          // 输出: Drawing Rectangle
        System.out.println();
        circle.draw();             // 输出: Drawing Circle
        System.out.println();
        compositeShape.draw();      // 输出: Drawing CompositeShape \n Drawing Rectangle \n Drawing Circle
    }
}
