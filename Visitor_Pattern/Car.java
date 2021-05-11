package Visitor_Pattern;

public class Car implements CarPart {
    CarPart[] parts;

    public Car() {
        parts = new CarPart[] { new Engine(), new Door(), new Wheel() };
    }

    @Override
    public void accept(CarPartVisitor visitor) {
        visitor.visit(this);
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(visitor);
        }

    }

    public void display() {
        System.out.println("啟動車子");
    }
}
