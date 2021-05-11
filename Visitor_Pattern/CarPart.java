package Visitor_Pattern;

public interface CarPart {
    public void accept(CarPartVisitor visitor);
}
