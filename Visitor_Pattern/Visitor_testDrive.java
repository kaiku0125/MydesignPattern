package Visitor_Pattern;

public class Visitor_testDrive {
    public static void main(String[] args) {
        CarPartVisitor kevin = new ConcreteVisitor();
        CarPart car = new Car();
        car.accept(kevin);
    }
}
