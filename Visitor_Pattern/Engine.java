package Visitor_Pattern;

public class Engine implements CarPart {
    @Override
    public void accept(CarPartVisitor visitor) {
        visitor.visit(this);
    }

    public void dispaly() {
        System.out.println("與Engine連接完成");
    }

}
