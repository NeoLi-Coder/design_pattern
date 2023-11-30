package 创建型.工厂方法模式;

/***
 * 假设你是一家汽车制造公司，你生产不同类型的汽车，比如轿车、卡车、SUV等。每种类型的汽车都有自己的生产流程和特定的组件。
 *
 * 在工厂方法模式中，你可以定义一个抽象的汽车工厂接口，然后具体的汽车类型（轿车工厂、卡车工厂、SUV工厂）可以实现这个接口，负责实例化具体的汽车对象。
 */
// 抽象产品接口
interface Car {
    void drive();
}

// 具体产品，轿车
class SedanCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving Sedan Car");
    }
}

// 具体产品，卡车
class Truck implements Car {
    @Override
    public void drive() {
        System.out.println("Driving Truck");
    }
}

// 抽象工厂接口
interface CarFactory {
    Car createCar();
}

// 具体工厂，轿车工厂
class SedanCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new SedanCar();
    }
}

// 具体工厂，卡车工厂
class TruckFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Truck();
    }
}

// 客户端代码
public class CarClient {
    public static void main(String[] args) {
        // 创建轿车
        CarFactory sedanCarFactory = new SedanCarFactory();
        Car sedanCar = sedanCarFactory.createCar();
        sedanCar.drive();  // 输出: Driving Sedan Car
        
        // 创建卡车
        CarFactory truckFactory = new TruckFactory();
        Car truck = truckFactory.createCar();
        truck.drive();     // 输出: Driving Truck
    }
}
