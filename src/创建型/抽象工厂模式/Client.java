package 创建型.抽象工厂模式;

// 抽象产品接口
interface Car {
    void drive();
}

interface TV {
    void display();
}

// 具体产品
class SmallCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving a small car.");
    }
}

class BigCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving a big car.");
    }
}

class LCDTV implements TV {
    @Override
    public void display() {
        System.out.println("Displaying on an LCD TV.");
    }
}

class CurvedTV implements TV {
    @Override
    public void display() {
        System.out.println("Displaying on a curved TV.");
    }
}

// 抽象工厂接口
interface AbstractFactory {
    Car createCar();
    TV createTV();
}

// 具体工厂
class FamilyFactory implements AbstractFactory {
    @Override
    public Car createCar() {
        return new BigCar();
    }

    @Override
    public TV createTV() {
        return new CurvedTV();
    }
}

class SingleFactory implements AbstractFactory {
    @Override
    public Car createCar() {
        return new SmallCar();
    }

    @Override
    public TV createTV() {
        return new LCDTV();
    }
}

// 客户端使用工厂
public class Client {
    public static void main(String[] args) {
        AbstractFactory familyFactory = new FamilyFactory();
        Car familyCar = familyFactory.createCar();
        TV familyTV = familyFactory.createTV();

        AbstractFactory singleFactory = new SingleFactory();
        Car singleCar = singleFactory.createCar();
        TV singleTV = singleFactory.createTV();

        familyCar.drive();  // Driving a big car.
        familyTV.display(); // Displaying on a curved TV.

        singleCar.drive();  // Driving a small car.
        singleTV.display(); // Displaying on an LCD TV.
    }
}
