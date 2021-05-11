package Visitor_Pattern;

public class ConcreteVisitor implements CarPartVisitor {

    @Override
    public void visit(Door door) {
        door.dispaly();
    }

    @Override
    public void visit(Wheel wheel) {
        wheel.display();
    }

    @Override
    public void visit(Engine engine) {
        engine.dispaly();
    }

    @Override
    public void visit(Car car) {
        car.display();
    }

}
