package Visitor_Pattern;

public class Wheel implements CarPart {
    @Override
    public void accept(CarPartVisitor visitor) {
        visitor.visit(this);
    }

    public void display() {
        System.out.println("輪胎胎壓正常");
    }

}
