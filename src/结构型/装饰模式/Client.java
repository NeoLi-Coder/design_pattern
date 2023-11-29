package 结构型.装饰模式;

// 抽象组件
interface Coffee {
    String getDescription();
    double cost();
}

// 具体组件，基础咖啡
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 2.0; // 美式咖啡的价格
    }
}

// 装饰者抽象类
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }
}

// 具体装饰者，牛奶
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return super.cost() + 0.5; // 牛奶的价格
    }
}

// 具体装饰者，糖浆
class SyrupDecorator extends CoffeeDecorator {
    public SyrupDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Syrup";
    }

    @Override
    public double cost() {
        return super.cost() + 0.3; // 糖浆的价格
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        // 基础咖啡
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Cost of Simple Coffee: " + simpleCoffee.cost());  // 输出: Cost of Simple Coffee: 2.0

        // 加入牛奶的咖啡
        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println("Cost of Milk Coffee: " + milkCoffee.cost());  // 输出: Cost of Milk Coffee: 2.5

        // 加入牛奶和糖浆的咖啡
        Coffee syrupMilkCoffee = new SyrupDecorator(milkCoffee);
        System.out.println("Cost of Syrup Milk Coffee: " + syrupMilkCoffee.cost());  // 输出: Cost of Syrup Milk Coffee: 2.8
    }
}
