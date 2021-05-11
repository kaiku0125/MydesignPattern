package Visitor_Pattern;

public interface CarPartVisitor {
    public void visit(Door door);

    public void visit(Wheel wheel);

    public void visit(Engine engine);

    public void visit(Car car);
}
